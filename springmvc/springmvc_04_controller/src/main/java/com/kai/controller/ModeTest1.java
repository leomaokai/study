package com.kai.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModeTest1 {

    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest req, HttpServletResponse resp){
        //使用视图解析器
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        return "test";
    }
    @RequestMapping("/m1/t2")
    public String test2(Model model){
        //转发,无法直接访问WEB-INF中的jsp,hello.jsp在web目录下
        model.addAttribute("msg","hello");
        return "/hello.jsp";
    }
    @RequestMapping("/m1/t3")
    public String test3(Model model){
        //转发二
        model.addAttribute("msg","hello");
        return "forward:/hello.jsp";
    }
    @RequestMapping("/m1/t4")
    public String test4(Model model){
        //重定向
        model.addAttribute("msg","hello");
        return "redirect:/hello.jsp";
    }
}
