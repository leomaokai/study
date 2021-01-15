package com.kai.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/t1")
    public String test01(){
        System.out.println("MyController");
        return "ok";
    }
}
