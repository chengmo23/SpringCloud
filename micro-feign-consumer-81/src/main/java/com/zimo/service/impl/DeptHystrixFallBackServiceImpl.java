package com.zimo.service.impl;

import com.zimo.service.DeptHystrixService;
import org.springframework.stereotype.Component;

/**
 * Hystrix 服务降级
 * 解耦降级逻辑
 * Created by Zimo on 2022/4/4.
 */
@Component
public class DeptHystrixFallBackServiceImpl implements DeptHystrixService {

    @Override
    public String deptInfoOk(Integer id) {
        return "--------------------系统繁忙，请稍后重试！（解耦回退方法触发）-----------------------";
    }

    @Override
    public String deptInfoTimeout(Integer id) {
        return "--------------------系统繁忙，请稍后重试！（解耦回退方法触发）-----------------------";
    }
}
