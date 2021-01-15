package com.kai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class ControllerTest3 {

    @RequestMapping("/test")
    public String test4(Model model){
        model.addAttribute("msg","test4");
        return "test";
    }
}
