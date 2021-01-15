package com.kai.controller;


import com.kai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //不加@RequestParam localhost:8080/xxx/user/t1?name=leomaokai
    //加上@RequestParam localhost:8080/xxx/user/t1?username=leomaokai
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1.接收前端参数
        System.out.println("接收到前端的参数:"+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        //3.跳转视图
        return "test";
    }

    //前端接受User对象: id name age
    // localhost:8080/xxx/user/t2?name=leomaokai&id=10&age=20
    /*
    1.接收前端用户传递的参数,判断参数的名字,如果名字直接在方法上,可以直接使用
    2.假设传递的是一个对象user,匹配User对象中的字段名,如果名字一致,则可匹配
     */
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    /*
    ModeMap:继承了LinkedHashMap,拥有LinkedHashMap的全部功能
    Model:精简版
     */
    @GetMapping("/t3")
    public String test3(ModelMap modelMap){
        modelMap.addAttribute("msg","ModelMap");
        return "test";
    }
}
