package com.zimo.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定制 Ribbon 负载均衡策略配置类
 * 该自定义 Ribbon 负载均衡策略配置类 不能在 com.zimo 包及其子包下
 * 否则所有的 Ribbon 客户端都会采用该策略，无法达到特殊化定制的目的
 * Created by Zimo on 2022/3/6.
 */
@Configuration
public class MyRibbonRuleConfig {

    @Bean
    public IRule myRule() {
        return new MyRandomRule();
    }
}
