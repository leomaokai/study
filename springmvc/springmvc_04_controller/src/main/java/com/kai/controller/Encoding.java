package com.kai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Encoding {

    @PostMapping("/e1/t1")
    public String test1(@RequestParam("name") String name, Model model){
        //过滤器解决乱码
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test";
    }

    @PostMapping("/e1/t2")
    public String test2(@RequestParam("name") String name, Model model){
        //过滤器解决乱码
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test";
    }
}
