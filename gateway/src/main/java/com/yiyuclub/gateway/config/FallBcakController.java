package com.yiyuclub.gateway.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBcakController {

    @GetMapping("/fallback")
    public String fallback() {
        System.out.println("执行中");
        return "服务熔断测试run";
    }

}
