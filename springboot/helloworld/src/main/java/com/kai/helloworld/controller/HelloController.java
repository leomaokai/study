package com.kai.helloworld.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//自动装配
@RestController
public class HelloController {

    //接口 http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        return "hello,SpringBoot";
    }
}
