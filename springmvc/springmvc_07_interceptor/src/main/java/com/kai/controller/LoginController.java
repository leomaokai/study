package com.kai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/dologin")
    public String login(String username, String password, HttpSession session){
        //把用户的信息存在Session中
        session.setAttribute("userLoginInfo",username);
        return "redirect:/main";
    }
    @RequestMapping("/main")
    public String tomain(){
        return "main";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("userLoginInfo");
        return "login";
    }
}
