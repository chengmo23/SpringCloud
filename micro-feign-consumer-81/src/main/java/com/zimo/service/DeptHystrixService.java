package com.zimo.service;

import com.zimo.service.impl.DeptHystrixFallBackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zimo on 2022/4/4.
 */
@Component  // 添加为容器内的一个组件
@FeignClient(value = "MICROHYSTRIXPROVIDER", fallback = DeptHystrixFallBackServiceImpl.class) // 服务提供者提供的服务名称，即 application.name
public interface DeptHystrixService {

    @RequestMapping("/dept/hystrix/ok/{id}")
    public String deptInfoOk(@PathVariable("id") Integer id);

    @RequestMapping("/dept/hystrix/timeout/{id}")
    public String deptInfoTimeout(@PathVariable("id") Integer id);
}
