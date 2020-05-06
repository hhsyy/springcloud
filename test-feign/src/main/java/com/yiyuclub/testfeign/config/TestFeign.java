package com.yiyuclub.testfeign.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "testclient")
public interface TestFeign {

    @GetMapping("testclient")
    String show(@RequestParam(value = "username") String username);
}
