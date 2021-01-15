package com.kai.mapper;

import com.kai.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> listUser();

//    添加一个用户
    int addUser(User user);

//    删除一个用户
    int deleteUser(int id);
}
