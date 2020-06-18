package com.zero.product.web.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zero.autoconfigure.util.DomainUtil;
import com.zero.common.core.constant.StatusCode;
import com.zero.common.core.page.PageModel;
import com.zero.common.core.util.JsonUtil;
import com.zero.common.datasource.page.PagingHelper;
import com.zero.common.sequence.util.SequenceUtil;
import com.zero.common.web.util.Shift;
import com.zero.product.core.domain.*;
import com.zero.product.core.domain.impl.DataDictValueFeatureImpl;
import com.zero.product.core.domain.impl.ProductImpl;
import com.zero.product.web.data.SysDictManager;
import com.zero.product.web.entity.*;
import com.zero.product.web.model.EntityFeatureConverter;
import com.zero.product.web.model.EntityProductConverter;
import com.zero.product.web.model.FeatureConverter;
import com.zero.product.api.model.qo.ProductPagingRequest;
import com.zero.product.web.persistence.ProductEntityMapper;
import com.zero.product.web.persistence.ProductFeatureEntityMapper;
import com.zero.product.web.persistence.ProductTextEntityMapper;
import com.zero.product.web.service.ProductCategoryService;
import com.zero.product.web.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final EntityProductConverter entityProductConverter;

    private final EntityFeatureConverter entityFeatureConverter;

    private final ProductEntityMapper productEntityMapper;

    private final FeatureConverter featureConverter;

    private final ProductFeatureEntityMapper productFeatureEntityMapper;

    private final CacheManager cacheManager;

    private final ProductCategoryService productCategoryService;

    private final ProductTextEntityMapper productTextEntityMapper;


    public ProductServiceImpl(EntityProductConverter entityProductConverter, EntityFeatureConverter entityFeatureConverter, ProductEntityMapper productEntityMapper, FeatureConverter featureConverter, ProductFeatureEntityMapper productFeatureEntityMapper, CacheManager cacheManager, ProductCategoryService productCategoryService, ProductTextEntityMapper productTextEntityMapper) {
        this.entityProductConverter = entityProductConverter;
        this.entityFeatureConverter = entityFeatureConverter;
        this.productEntityMapper = productEntityMapper;
        this.featureConverter = featureConverter;
        this.productFeatureEntityMapper = productFeatureEntityMapper;
        this.cacheManager = cacheManager;
        this.productCategoryService = productCategoryService;
        this.productTextEntityMapper = productTextEntityMapper;
    }

    @Transactional
    @Override
    public void create(Product product) {
        ProductEntity productEntity = entityProductConverter.from(product);

        productEntity.setId(SequenceUtil.next());
        List<Feature> features = product.getFeatures();
        check(product);
        features.stream().map(a -> (AbstractFeature) a).forEach(a -> a.setProductCode(product.getProductCode()));

        List<ProductFeatureEntity> productFeatureEntities = entityFeatureConverter.from(features);


        log.info("[] {} , [] {}", JsonUtil.toJson(product), JsonUtil.toJson(productFeatureEntities));

        // description 及 listFeature 信息另存

        List<ProductFeatureEntity> collect = productFeatureEntities.stream().filter(a -> "3".equals(a.getValueType()) || "4".equals(a.getValueType())).collect(Collectors.toList());

        List<ProductTextEntity> textEntityList = collect.stream().map(a -> {
            ProductTextEntity productTextEntity = new ProductTextEntity();
            productTextEntity.setTextId(SequenceUtil.next());
            productTextEntity.setProductCode(a.getProductCode());
            // 将value 交给textEntity处理
            productTextEntity.setValue(a.getValue());

            a.setValue(productTextEntity.getTextId());
            return productTextEntity;
        }).collect(Collectors.toList());

        productFeatureEntities.forEach(DomainUtil::afterProperties);
        DomainUtil.afterProperties(productEntity);
        productEntityMapper.insertProductEntity(productEntity);
        productTextEntityMapper.bulkInsertProductTextEntity(textEntityList);
        productFeatureEntityMapper.bulkInsertProductFeatureEntity(productFeatureEntities);

    }

    private void check(Product product) {

        String productCode = product.getProductCode();
        Product oriProduct = selectProductEntityByProductCode(productCode);
        if (oriProduct != null) {
            throw new RuntimeException("产品编号已存在, productCode:" + productCode);
        }
        ProductCategoryEntity productCategoryEntity = productCategoryService.selectCategory(product.getCategory());
        if (productCategoryEntity == null) {
            throw new RuntimeException("产品类别不存在: " + product.getCategory());
        }

        String tenantId = productCategoryEntity.getTenantId();
        if (tenantId != null && !tenantId.equals(product.getTenantId())) {
            throw new RuntimeException("产品类别不存在: " + product.getCategory());
        }

        String busiType = product.getBusiType();
        boolean busiTypeMatch = productCategoryEntity.getBusiTypes().stream().map(a -> a.getBusiType()).anyMatch(a -> a.equals(busiType));
        if (!busiTypeMatch) {
            throw new RuntimeException("业务种类不匹配:  " + busiType);
        }

        Map<String, ProductCategoryFeatureEntity> categoryFeatureEntityMap = new HashMap<>();
        productCategoryEntity.getFeatures()
                .forEach(a -> categoryFeatureEntityMap.put(a.getName(), a));

        for (Feature feature : product.getFeatures()) {

            ProductCategoryFeatureEntity productCategoryFeatureEntity = categoryFeatureEntityMap.remove(feature.getName());
            if (productCategoryFeatureEntity == null) {

                // 超出限定范围， 跳过？？？
                continue;
            }
            String categoryClazz = productCategoryFeatureEntity.getClazz();
            String categoryDictCode = productCategoryFeatureEntity.getDictCode();
            String categoryValueType = productCategoryFeatureEntity.getValueType();
            String categoryCheckRule = productCategoryFeatureEntity.getCheckRule();

            if (!feature.getClass().getSimpleName().equals(categoryClazz)) {
                throw new RuntimeException("检测异常:要素类不相同: feature.class: " + feature.getClass().getSimpleName() + " category.class: " + categoryClazz);
            }

            if (categoryCheckRule != null) {
                if (feature instanceof RangeFeature) {
                    RangeFeature rangeFeature = (RangeFeature) feature;
                    categoryCheckRule = categoryCheckRule.replaceAll("@minValue", String.valueOf(rangeFeature.getMinValue()));
                    categoryCheckRule = categoryCheckRule.replaceAll("@maxValue", String.valueOf(rangeFeature.getMaxValue()));
                } else if (feature instanceof DataDictValueFeatureImpl){
                    DataDictValueFeatureImpl dataDictValueFeature = (DataDictValueFeatureImpl) feature;
                    categoryCheckRule = categoryCheckRule.replaceAll("@value", String.valueOf(dataDictValueFeature.getValue()));
                    categoryCheckRule = categoryCheckRule.replaceAll("@dictCode", String.valueOf(dataDictValueFeature.getDictCode()));

                } else if (feature instanceof ValueFeature) {
                    ValueFeature valueFeature = (ValueFeature) feature;
                    categoryCheckRule = categoryCheckRule.replaceAll("@value", String.valueOf(valueFeature.getValue()));
                }
                Boolean value = new SpelExpressionParser().parseExpression(categoryCheckRule).getValue(Boolean.class);
                if (!value) {
                    throw new RuntimeException("check 未通过: feature.name: " + feature.getName() + " checkRule: " + productCategoryFeatureEntity.getCheckRule());

                }
            }

//            // TODO 字典类定制的校验， checkrule全面生效后可移除
//            if (feature instanceof DataDictValueFeatureImpl) {
//                DataDictValueFeatureImpl dataDictValueFeature = (DataDictValueFeatureImpl) feature;
//                String dictCode = dataDictValueFeature.getDictCode();
//                if (dictCode == null || !dictCode.equals(categoryDictCode)) {
//                    throw new RuntimeException("DataDictValueFeature dictcode 异常 name: " + feature.getName() );
//                }
//
//                SysDictEntity sysDictEntity = SysDictManager.getSysDictEntity(dictCode);
//                if (sysDictEntity == null) {
//                    throw new RuntimeException("数据字典不存在, code: " + dictCode);
//                }
//                boolean b = sysDictEntity.getItems().stream().anyMatch(a -> a.getCode().equals(dataDictValueFeature.getValue()));
//                if (!b) {
//                    throw new RuntimeException("数据字典值不存在, dictCode: " + dictCode + " code: " + dataDictValueFeature.getValue());
//                }
//            }
        }

        Iterator<Map.Entry<String, ProductCategoryFeatureEntity>> iterator = categoryFeatureEntityMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ProductCategoryFeatureEntity> next = iterator.next();
            String optional = next.getValue().getOptional();
            if ("0".equals(optional)) {
                iterator.remove();
            }
        }

        if (!categoryFeatureEntityMap.isEmpty()) {
            throw new RuntimeException("参数不足:" + categoryFeatureEntityMap.keySet());
        }

    }

    public Product selectProductEntityByProductCode(String productCode) {
        Cache cache = cacheManager.getCache("product:info:");
        String productCache = cache.get(productCode, String.class);
        if (productCache != null) {
            return JsonUtil.fromJson(productCache, Product.class);
        }

        ProductEntity productEntity = productEntityMapper.selectProductEntityByProductCode(productCode);
        if (productEntity == null) {
            return null;
        }
        ProductImpl product = new ProductImpl();
        BeanUtil.copyProperties(productEntity, product);

        List<ProductFeatureEntity> featureEntityList = productFeatureEntityMapper.selectProductFeatureEntityByProductCode(productCode);

        if (featureEntityList == null) {
            return product;
        }
        // 大字段从textEntity中读取
        List<ProductFeatureEntity> collect = featureEntityList.stream().filter(a -> "3".equals(a.getValueType()) || "4".equals(a.getValueType())).collect(Collectors.toList());
        if (collect != null && !collect.isEmpty()) {
            List<ProductTextEntity> textEntityList = productTextEntityMapper.selectProductTextEntityByProductCode(productCode);
            Map<String, String> textMap = new HashMap<>();
            textEntityList.forEach(a -> textMap.put(a.getTextId(), a.getValue()));
            collect.forEach(a -> a.setValue(textMap.get(a.getValue())));
        }

        product.setFeatures(featureConverter.from(featureEntityList));

        if (Product.ProductStatus.PUBLISHED.equals(product.getStatus())) {
            cache.put(productCode, JsonUtil.toJson(product));
        }
        return product;
    }

    @Override
    public PageModel<Product> findAll(ProductPagingRequest request) {

        PagingHelper.startPaging(request.getPageNum(), request.getPageSize());

        // TODO 修改model
        List<ProductEntity> productEntities = productEntityMapper.selectAll(request);


        PageModel<ProductEntity> productEntityPageModel = PagingHelper.pageModel(productEntities);

        // 如果已上架， 填充feature
        List<Product> collect = productEntityPageModel.getContent().stream().map(a -> {
            ProductImpl p = new ProductImpl();
            BeanUtil.copyProperties(a, p);
            return p;
        }).collect(Collectors.toList());
        PageModel<Product> productPageModel = PageModel.from(productEntityPageModel.getNumber(),
                productEntityPageModel.getSize(),
                productEntityPageModel.getTotalElements(),
                productEntityPageModel.getTotalPages(),
                collect);
        return productPageModel;
    }

    @Override
    public void updateProductStatus(String productCode, Product.ProductStatus status) {
        Product product = selectProductEntityByProductCode(productCode);
        if (product == null) {
            Shift.fatal(StatusCode.INVALID_PARAMS_CHECK_ERROR,"产品不存在" + productCode);
        }
        Product.ProductStatus oriStatus = product.getStatus();
        if (Product.ProductStatus.PUBLISHED.equals(status) && Product.ProductStatus.CREATE.equals(oriStatus)) {
            productEntityMapper.updateProductStatus(productCode);
            selectProductEntityByProductCode(productCode);
        } else if(Product.ProductStatus.DOWN.equals(status) && Product.ProductStatus.PUBLISHED.equals(oriStatus)) {
            productEntityMapper.updateProductStatus(productCode);
        } else {
            Shift.fatal(StatusCode.INVALID_PARAMS_CHECK_ERROR,String.format("参数异常 原状态 %s, 修改状态%s", oriStatus, status));
        }
    }
}
