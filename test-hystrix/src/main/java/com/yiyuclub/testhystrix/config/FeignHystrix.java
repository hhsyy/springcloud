package com.yiyuclub.testhystrix.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignHystrix implements TestFeign {
    @Override
    public String testclient(@RequestParam(value = "username")String username) {
        return username+"熔断进行中";
    }
}
