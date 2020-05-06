package com.yiyuclub.testribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class TestribbonApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestribbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @GetMapping("testribbon")
    public String  ribbon(String username){
        System.out.println("执行ribbon中");
        return  restTemplate().getForObject("http://testclient/testclient?username="+username,String.class);
    }
}
