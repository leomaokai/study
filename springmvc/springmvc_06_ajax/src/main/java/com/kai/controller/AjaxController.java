package com.kai.controller;


import com.kai.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test01() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void test02(String name, HttpServletResponse response) throws IOException {
        System.out.println(name);
        if (name.equals("maokai")) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a3")
    public List<User> test03() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("maokai1", 5));
        userList.add(new User("maokai2", 10));
        userList.add(new User("maokai3", 15));
        return userList;
    }

    @RequestMapping("/a4")
    public String test04(String name, String pwd) {
        String msg = "";
        if (name != null) {
            if ("admin".equals(name))
                msg = "ok";
            else {
                msg = "error";
            }
        }
        if (pwd != null) {
            if ("123456".equals(pwd))
                msg = "ok";
            else {
                msg = "error";
            }
        }
        return msg;
    }
}
