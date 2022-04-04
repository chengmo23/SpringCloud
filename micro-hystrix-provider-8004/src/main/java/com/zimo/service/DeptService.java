package com.zimo.service;

/**
 * Created by Zimo on 2022/4/4.
 */
public interface DeptService {

    // hystrix 熔断器实例 ok
    public String  deptInfoOk(Integer id);

    // hystrix 熔断器超时案例
    public String deptInfoTimeout(Integer id);

    // Hystrix 熔断机制案例
    public String deptCircuitBreaker(Integer id);
}
