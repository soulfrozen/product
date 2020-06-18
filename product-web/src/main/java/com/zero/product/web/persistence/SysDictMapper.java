package com.zero.product.web.persistence;

import com.zero.product.web.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDictMapper {

    SysDictEntity selectSysDictEntityByCode(String code);

    List<SysDictEntity> selectSysDictEntity();
}
