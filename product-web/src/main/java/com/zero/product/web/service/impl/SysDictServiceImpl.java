package com.zero.product.web.service.impl;

import com.zero.product.web.entity.SysDictEntity;
import com.zero.product.web.persistence.SysDictMapper;
import com.zero.product.web.service.SysDictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    private final SysDictMapper sysDictMapper;

    public SysDictServiceImpl(SysDictMapper sysDictMapper) {
        this.sysDictMapper = sysDictMapper;
    }

    @Override
    public SysDictEntity selectSysDictEntityByCode(String code) {
        return sysDictMapper.selectSysDictEntityByCode(code);
    }

    @Override
    public List<SysDictEntity> selectSysDictEntity() {
        return sysDictMapper.selectSysDictEntity();
    }
}
