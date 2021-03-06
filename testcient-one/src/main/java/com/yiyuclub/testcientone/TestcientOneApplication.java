package com.yiyuclub.testcientone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class TestcientOneApplication {
    @Value("${server.port}")
    long port;

    public static void main(String[] args) {
        SpringApplication.run(TestcientOneApplication.class, args);
    }

    @GetMapping("testclient")
    public String show(String username){
        return port+":"+username;
    }
}
