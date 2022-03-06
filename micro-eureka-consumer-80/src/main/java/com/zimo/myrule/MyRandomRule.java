package com.zimo.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义 Ribbon 负载均衡策略
 * Created by Zimo on 2022/3/6.
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

    private int total = 0;             // 总共被调用的次数
    private int currentIndex = 0;      // 当前提供服务的机器号

    public Server choose(ILoadBalancer iLoadBalancer, Object key) {
        if (null == iLoadBalancer) {
            return null;
        }
        Server server = null;

        while (null == server) {
            if (Thread.interrupted()) {
                return null;
            }

            // 获取所有有效的服务实例列表
            List<Server> upList = iLoadBalancer.getReachableServers();
            // 获取所有的服务实例列表
            List<Server> allList = iLoadBalancer.getAllServers();

            //如果没有任何的服务实例则返回 null
            int serverCount = allList.size();
            if (0 == serverCount) {
                return null;
            }

            // 与随机策略相似，但每个服务实例只有在调用 n 次后，才会调用其他的服务实例
            if (total < 3) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (null == server) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}
