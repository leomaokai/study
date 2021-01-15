package com.kai.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//等价于 <bean id="user" class="com.kai.pojo.User"/>
//组件
@Component
public class User {
    public String name="kai";

    //相当于 <property name="name" value="maokai"/>
    @Value("maokai")
    public String name2;
}
