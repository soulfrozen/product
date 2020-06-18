package com.zero.product.web.service;

import com.zero.product.web.entity.SysDictEntity;

import java.util.List;

public interface SysDictService {

    SysDictEntity selectSysDictEntityByCode(String code);

    List<SysDictEntity> selectSysDictEntity();
}
