package com.kai.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kai.pojo.User;
import com.kai.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/json")
public class UserController2 {

    @RequestMapping("/j1")
    public String test1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User("茂凯", 5, "man");
        User user2 = new User("茂凯", 5, "man");
        User user3 = new User("茂凯", 5, "man");
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        String str = mapper.writeValueAsString(userList);
        return str;
        //[{"name":"茂凯","age":5,"sex":"man"},
        // {"name":"茂凯","age":5,"sex":"man"},
        // {"name":"茂凯","age":5,"sex":"man"}]
    }

    @RequestMapping("/j2")
    public String test2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        //ObjectMapper将时间解析后的默认格式为Timestamp时间戳
        return mapper.writeValueAsString(date);
        //1610374644299
    }
    @RequestMapping("/j3")
    public String test3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        //自定义日期格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return mapper.writeValueAsString(sdf.format(date));
        //"2021-01-11 22:22:12"
    }
    @RequestMapping("/j4")
    public String test4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //使用ObjectMapper来格式化输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义日期格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        Date date = new Date();
        return mapper.writeValueAsString(date);
        //"2021-01-11 22:27:28"
    }
    //使用工具类
    @RequestMapping("/j5")
    public String test5(){
        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
        //"2021-01-11 22:35:25"
    }
    //使用工具类
    @RequestMapping("/j6")
    public String test6(){
        User user1 = new User("茂凯", 5, "man");
        User user2 = new User("茂凯", 5, "man");
        User user3 = new User("茂凯", 5, "man");
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return JsonUtils.getJson(userList);
    }

}
