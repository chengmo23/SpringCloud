package com.zimo.controller;

import com.zimo.entity.Dept;
import com.zimo.service.DeptFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zimo on 2022/4/4.
 */
@RestController
public class DeptFeignConsumerController {

    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptFeignService.get(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptFeignService.list();
    }

    // openFeign-ribbon 客户端一般默认等待一秒钟，超过该时间就会报错
    @RequestMapping("/consumer/dept/feign/timeout")
    public String deptFeignTimeout() {
        return deptFeignService.deptFeignTimeout();
    }
}
