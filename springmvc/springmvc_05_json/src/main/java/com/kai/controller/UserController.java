package com.kai.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody //不会走视图解析器,会直接返回一个字符串
    public String json1(){

        //创建一个对象
        User user = new User("kai",10,"man");
        //页面直接返回tostring
        return user.toString();
        //User(name=kai, age=10, sex=man)
    }

    @RequestMapping("/j2")
    @ResponseBody //不会走视图解析器,会直接返回一个字符串
    public String json2() throws JsonProcessingException {

        //jackson  ObjectMapper
        ObjectMapper mapper=new ObjectMapper();

        User user = new User("kai",10,"man");

        String valueAsString = mapper.writeValueAsString(user);
        return valueAsString;
        //{"name":"kai","age":10,"sex":"man"}
    }

    //解决json乱码,produces
    @RequestMapping(value = "/j3",produces = "application/json;charset=utf-8")
    @ResponseBody //不会走视图解析器,会直接返回一个字符串
    public String json3() throws JsonProcessingException {


        ObjectMapper mapper=new ObjectMapper();

        User user = new User("你好",10,"男");

        String valueAsString = mapper.writeValueAsString(user);
        return valueAsString;
        //{"name":"你好","age":10,"sex":"男"}
    }

    //解决json乱码,配置Springmvc
    @RequestMapping(value = "/j4")
    @ResponseBody //不会走视图解析器,会直接返回一个字符串
    public String json4() throws JsonProcessingException {


        ObjectMapper mapper=new ObjectMapper();

        User user = new User("茂凯",10,"男");

        String valueAsString = mapper.writeValueAsString(user);
        return valueAsString;
        //{"name":"茂凯","age":10,"sex":"男"}
    }
}
