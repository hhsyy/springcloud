package com.yiyuclub.testloadbalancerclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class TestLoadbalancerclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestLoadbalancerclientApplication.class, args);
    }

    @Autowired
    private LoadBalancerClient client;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("test-loadbalancerclient")
    public String test(String username){
        ServiceInstance instance = client.choose("testclient");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/testclient?username=" + username;
        return restTemplate().getForObject(url, String.class);
    }


}
