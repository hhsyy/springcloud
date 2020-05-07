package com.yiyuclub.testhystrix.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "testclient", fallback = FeignHystrix.class)
public interface TestFeign {
    @GetMapping("testclient")
    String testclient(@RequestParam(value = "username") String username);
}
