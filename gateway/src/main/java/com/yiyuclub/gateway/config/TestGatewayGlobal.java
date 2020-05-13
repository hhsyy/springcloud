package com.yiyuclub.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class TestGatewayGlobal implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> username = exchange.getRequest().getQueryParams().get("username");
        System.out.println(username);
        return chain.filter(exchange);
    }

    /**
     * 设置优先级别，值越大优先级别越低
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
