package com.kai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在templates下面的所有页面,只能通过controller跳转
//需要模板引擎
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg1","hello,Spring");
        model.addAttribute("msg2","<h1>hello,Spring</h1>");

        model.addAttribute("users", Arrays.asList("kai","leo"));
        return "test";
    }
}
