package com.yiyuclub.testhystrix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    public TestFeign testFeign;

    @GetMapping("test")
    public String test(String username){
        return  testFeign.testclient(username);
    }
}
