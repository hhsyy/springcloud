package com.yiyuclub.testfeign.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFeignController {

    @Autowired
    TestFeign testFeign;

    @GetMapping("test")
    public String test(String username){
        return testFeign.show(username);
    }
}
