package com.kai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller代表这个类被Spring接管
//被注解的类中,如果有方法返回String并且有具体页面跳转
//那么就会被视图器解析
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model){
        model.addAttribute("msg","ControllerTest2");
        return "test";
    }

    @RequestMapping("/t3")
    public String test3(Model model){
        model.addAttribute("msg","ControllerTest3");
        return "test";
    }
}
