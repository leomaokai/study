package com.kai.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kai.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

@RestController
@RequestMapping("/fastjson")
public class UserController3 {

    @RequestMapping("/t1")
    public String test1(){
        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User("wang", 15, "man");
        User user2 = new User("wang", 15, "man");
        User user3 = new User("wang", 15, "man");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        //Java对象转JSON字符串
        String s = JSON.toJSONString(userList);
        String s1 = JSON.toJSONString(user1);
        //JSON转Java对象
        User user = JSON.parseObject(s1, User.class);
        System.out.println(user);

        //Java对象转JSON字符串
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println(jsonObject1);
        //JSON转Java对象
        User javaObject = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println(javaObject);
        return s;
    }
}
