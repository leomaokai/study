package com.kai.swagger.controller;


import com.kai.swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping( "/hello")
    public String hello(){
        return "hello,swagger";
    }


    //只要我们接口中返回值存在实体类,就能扫描的Swagger中
    @PostMapping( "/user")
    public User user(){
        return new User();
    }
}
