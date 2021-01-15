package com.kai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    //原来的方式
    //http://localhost:8080/springmvc_04_controller_war_exploded/add?a=1&b=2
    @RequestMapping("/add")
    public String test01(int a, int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", res);
        return "test";
    }

    //RestFul风格
    //http://localhost:8080/springmvc_04_controller_war_exploded/add2/5/6
    @RequestMapping("/add2/{a}/{b}")
    public String test02(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", res);
        return "test";
    }
    //RestFul风格
    //@RequestMapping(value = "/add3/{a}/{b}",method = RequestMethod.GET)
    @GetMapping("/add3/{a}/{b}")
    public String test03(@PathVariable String a, @PathVariable String b, Model model) {
        String res = a + b;
        model.addAttribute("msg", res);
        return "test";
    }
}
