package com.zimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Zimo on 2022/3/5.
 */
@SpringBootApplication
@EnableEurekaClient  // Spring cloud Eureka 客户端，自动将本服务注册到 Eureka Server 注册中心中
public class MicroEurekaProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroEurekaProvider8003Application.class, args);
    }
}
