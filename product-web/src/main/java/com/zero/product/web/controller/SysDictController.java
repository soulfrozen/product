package com.zero.product.web.controller;


import com.zero.product.web.entity.SysDictEntity;
import com.zero.product.web.service.SysDictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/dict")
public class SysDictController {


    private final SysDictService sysDictService;

    public SysDictController(SysDictService sysDictService) {
        this.sysDictService = sysDictService;
    }

    @GetMapping
    public List<SysDictEntity> selectSysDict() {
        return sysDictService.selectSysDictEntity();
    }

    @GetMapping("/{code}")
    public SysDictEntity selectSysDictByCode(@PathVariable("code") String code) {
        return sysDictService.selectSysDictEntityByCode(code);
    }

}
