package com.zero.product.web.data;

import com.zero.product.web.entity.SysDictEntity;
import com.zero.product.web.entity.SysDictItemEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysDictManager {

    private static Map<String, SysDictEntity> SYS_DICT_MAP = new HashMap<>();

    public static SysDictEntity getSysDictEntity(String code) {
        return SYS_DICT_MAP.get(code);
    }

    public static void put(String code, SysDictEntity entity) {
        SYS_DICT_MAP.put(code, entity);
    }

    public static boolean checkExist(String dictCode, String code) {
        SysDictEntity sysDictEntity = getSysDictEntity(dictCode);
        if (sysDictEntity == null) {
            return false;
        }
        List<SysDictItemEntity> items = sysDictEntity.getItems();
        if (items == null) {
            return false;
        }
        return items.stream().anyMatch(a -> a.getCode().equals(code));
    }
}
