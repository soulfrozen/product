package com.zero.product.web.listener;

import com.zero.product.web.data.SysDictManager;
import com.zero.product.web.entity.SysDictEntity;
import com.zero.product.web.service.SysDictService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysDictManagerInitContextListener implements ApplicationListener<ApplicationReadyEvent> {

    private final SysDictService sysDictService;

    public SysDictManagerInitContextListener(SysDictService sysDictService) {
        this.sysDictService = sysDictService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<SysDictEntity> sysDictEntities = sysDictService.selectSysDictEntity();
        sysDictEntities.forEach(a -> SysDictManager.put(a.getCode(), a));
    }
}
