package com.atguigu.crowd.mvc.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDateTime;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月21日
 * @desc LocalDateTimeMapper
 */
public class LocalDateTimeMapper extends ObjectMapper {
    private static final long serialVersionUID = -3384287877273601299L;

    public LocalDateTimeMapper() {
        SimpleModule localDateTimeModule = new SimpleModule("localDateTimeModule");
        localDateTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        this.registerModule(localDateTimeModule);
    }
}
