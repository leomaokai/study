package com.kai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    @GetMapping("/userlist")
    public List<Map<String,Object>> userList(){
        String sql="select * from myuser";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }
    @GetMapping("/adduser")
    public String addUser(){
        String sql="insert into myuser(id,name,pwd) values (16,'hahaha','111')";
        jdbcTemplate.update(sql);
        return "addOk";
    }
    @GetMapping("/updateuser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql="update myuser set name=?,pwd=? where id="+id;

        Object[] objects = new Object[2];
        objects[0]="xiaoming";
        objects[1]="5555555";
        jdbcTemplate.update(sql,objects);
        return "updateOk";
    }
    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql="delete from myuser where id=?";
        jdbcTemplate.update(sql,id);
        return "deleteOK";
    }
}
