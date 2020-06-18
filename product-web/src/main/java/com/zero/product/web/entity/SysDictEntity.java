package com.zero.product.web.entity;

import com.zero.common.core.domain.BasicEntity;
import lombok.Data;

import java.util.List;

@Data
public class SysDictEntity extends BasicEntity<String> {

    private String code;

    private String label;

    private String description;

    private List<SysDictItemEntity> items;
}
