package com.kai.demo.controller;


import com.kai.demo.mapper.UserMapper;
import com.kai.demo.pojo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/listusers")
    public List<MyUser> listUsers(){
        List<MyUser> myUsers = userMapper.listUsers();
        return myUsers;
    }
}
