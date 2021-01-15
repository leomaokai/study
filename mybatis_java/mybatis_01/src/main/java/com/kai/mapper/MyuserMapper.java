package com.kai.mapper;

import com.kai.pojo.Myuser;

import java.util.List;
import java.util.Map;

public interface MyuserMapper {
    //查询全部用户
    List<Myuser> getUserList();

    //根据ID查询用户
    Myuser getUserById(int id);

    //增加一个用户
    int addUser(Myuser tempuser);

    //修改用户
    int updateUser(Myuser tempuser);

    //删除一个用户
    int deleteUser(int id);

    //分页
    List<Myuser> getUserListbyLimit(Map<String,Integer> map);
    List<Myuser> getUserByRowBounds();
}
