package com.yiyuclub.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    @Value("${username}")
    String username;

    @GetMapping("getInfo")
    public String getInfo(){
        return username;
    }
}
