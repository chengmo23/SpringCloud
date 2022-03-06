package com.zimo.controller;

import com.zimo.entity.Dept;
import com.zimo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务提供者的控制层
 * Created by Zimo on 2022/3/5.
 */
@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.selectAll();
    }

}
