package com.zero.product.api.listener;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zero.common.core.util.JsonUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class JsonUtilCustomerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private List<Module> modules;

    public JsonUtilCustomerContextListener(List<Module> modules) {
        if (CollectionUtils.isEmpty(modules)) {
            this.modules = modules;
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (CollectionUtils.isEmpty(modules)) {
            return;
        }
        Field[] fields = JsonUtil.class.getDeclaredFields();

        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                if (field.getType() == ObjectMapper.class) {
                    try {
                        ObjectMapper o = (ObjectMapper) field.get(null);
                        o.registerModules(modules);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
