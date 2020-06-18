package com.zero.product.core.domain;

public class GuaranteeModel {

    private String productCode;//产品编码
    private String orgCode;//保障机构编号
    private Integer guaDay;//代偿触发日（T+N）
    private String guaTime;//担保触发时间（cron表达式）
    private Integer guaOrder;//担保优先级
    private String isAuto;//是否自动代偿(0-否，1-是)
    private String typeCode;//参与人类型编号
    private String isLading;//提单机构是否关联
    private String belongCode;//代偿后债权归属人
    private String isBuyBack;//是否触发回购（0-否，1-是）
    private Integer buyBackPeriod;//连续逾期次数后触发回购

    private String recComp;

    private String orgName;
    private String orgType;
    private String orgTypeName;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getGuaDay() {
        return guaDay;
    }

    public void setGuaDay(Integer guaDay) {
        this.guaDay = guaDay;
    }

    public String getGuaTime() {
        return guaTime;
    }

    public void setGuaTime(String guaTime) {
        this.guaTime = guaTime;
    }

    public Integer getGuaOrder() {
        return guaOrder;
    }

    public void setGuaOrder(Integer guaOrder) {
        this.guaOrder = guaOrder;
    }

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getIsLading() {
        return isLading;
    }

    public void setIsLading(String isLading) {
        this.isLading = isLading;
    }

    public String getBelongCode() {
        return belongCode;
    }

    public void setBelongCode(String belongCode) {
        this.belongCode = belongCode;
    }

    public String getIsBuyBack() {
        return isBuyBack;
    }

    public void setIsBuyBack(String isBuyBack) {
        this.isBuyBack = isBuyBack;
    }

    public Integer getBuyBackPeriod() {
        return buyBackPeriod;
    }

    public void setBuyBackPeriod(Integer buyBackPeriod) {
        this.buyBackPeriod = buyBackPeriod;
    }

    public String getRecComp() {
        return recComp;
    }

    public void setRecComp(String recComp) {
        this.recComp = recComp;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }
}
