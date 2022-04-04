package com.zimo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zimo.service.DeptHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Zimo on 2022/4/4.
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "deptGlobalFallbackMethod")
public class DeptHystrixConsumerController {

    @Resource
    private DeptHystrixService deptHystrixService;

    @RequestMapping("/consumer/dept/hystrix/ok/{id}")
    public String deptInfoOk(@PathVariable("id") Integer id) {
        return deptHystrixService.deptInfoOk(id);
    }

    @RequestMapping("/consumer/dept/hystrix/timeout/{id}")
    //在客户端进行降级
    // @HystrixCommand(fallbackMethod = "deptTimeoutHandler")  // 单个方法降级
    @HystrixCommand  // 全局降级
    public String deptInfoTimeout(@PathVariable("id") Integer id) {
        String result = deptHystrixService.deptInfoTimeout(id);
        log.info(result);
        return result;
    }

    // deptInfo_Timeout方法的 专用 fallback 方法
    public String deptTimeoutHandler(@PathVariable("id") Integer id) {
        log.info("deptInfoTimeout 出错，服务已被降级！");
        return "服务端系统繁忙，请稍后再试！（客户端 deptInfo_Timeout 专属的回退方法触发）";
    }

    /**
     * 全局 fallback 方法
     * 回退防范必须和 hystrix 的执行方法在相同类中
     * @DefaultProperties(defaultFallback = "deptGlobalFallbackMethod") 类上注解，请求方法上使用 @HystrixCommand 注解
     * @return
     */
    public String deptGlobalFallbackMethod() {
        log.info("方法调用出错(全局)，服务已被降级！");
        return "服务端系统繁忙，请稍后再试！（客户端全局回退方法触发）";
    }
}
