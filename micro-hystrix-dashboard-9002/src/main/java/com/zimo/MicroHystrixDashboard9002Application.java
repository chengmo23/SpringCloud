package com.zimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Zimo on 2022/4/4.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class MicroHystrixDashboard9002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroHystrixDashboard9002Application.class, args);
    }
}
