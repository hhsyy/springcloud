package com.yiyuclub.testsleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSleuthApplication.class, args);
    }

    @GetMapping("rev")
    public String rev(String name){
        System.out.println("正在执行");
        return name;
    }

}
