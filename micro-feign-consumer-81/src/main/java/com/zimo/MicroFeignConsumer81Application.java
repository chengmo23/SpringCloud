package com.zimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Zimo on 2022/4/4.
 */
@SpringBootApplication
@EnableFeignClients  // 开启 OpenFeign 功能
@EnableHystrix  // 启用 Hystrix
public class MicroFeignConsumer81Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroFeignConsumer81Application.class, args);
    }
}
