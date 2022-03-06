package com.zimo.controller;

import com.zimo.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Zimo on 2022/3/6.
 */
@RestController
public class DeptControllerConsumer {

    // 这种方式是直接调用服务的方法，没有用到Spring Cloud
    // private static final String REST_URL_PROVIDER_PREFIX = "http://localhost:8001/";

    // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://MICROEUREKAPROVIDER";

    // RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/list", List.class);
    }
}
