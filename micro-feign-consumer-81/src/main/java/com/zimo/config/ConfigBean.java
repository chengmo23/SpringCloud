package com.zimo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * Created by Zimo on 2022/4/4.
 */
@Configuration
public class ConfigBean {

    /**
     * OpenFeign 日志增强
     * 配置 OpenFeign 记录的内容
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
