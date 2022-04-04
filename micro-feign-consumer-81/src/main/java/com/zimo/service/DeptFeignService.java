package com.zimo.service;

import com.zimo.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Zimo on 2022/4/4.
 */
@Component  // 添加为容器内的一个组件
@FeignClient(value = "MICROEUREKAPROVIDER") // 服务提供者提供的服务名称，即 application.name
public interface DeptFeignService {

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") int id);

    @GetMapping("/dept/list")
    public List<Dept> list();

    @RequestMapping("/dept/feign/timeout")
    public String deptFeignTimeout();
}
