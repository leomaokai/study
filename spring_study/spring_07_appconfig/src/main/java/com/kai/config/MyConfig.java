package com.kai.config;


import com.kai.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    //方法名相当于bean标签中的id属性
    //方法的返回值相当于bean标签的class属性
    @Bean
    public User testconfig(){
        return new User();
    }
}
