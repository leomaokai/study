package com.kai;


import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kai.mapper.UserMapper;
import com.kai.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MybatisPlusWrapper {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // email 不为空且年龄大于等于20
        // SELECT id,name,age,email,create_date,update_date,version,deleted
        // FROM user WHERE deleted=0
        // AND (email IS NOT NULL AND age >= ?)
        wrapper
                .isNotNull("email")
                .ge("age",20);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","hahaha");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test03(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Jack");
        System.out.println(userMapper.selectOne(wrapper));
    }

    @Test
    public void test04(){
        // 查询年龄在10到20岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",10,20);
        // Integer count = userMapper.selectCount(wrapper);
        // System.out.println(count);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test05(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 查询名字中待用o的且按id降序排序
        wrapper.like("name","o").orderByDesc("id");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }
}
