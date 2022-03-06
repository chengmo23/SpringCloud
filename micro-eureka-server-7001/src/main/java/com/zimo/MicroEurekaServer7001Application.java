package com.zimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Zimo on 2022/3/5.
 */
@SpringBootApplication
@EnableEurekaServer  // 开启 Eureka server，接受其他微服务的注册
public class MicroEurekaServer7001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroEurekaServer7001Application.class, args);
    }
}
