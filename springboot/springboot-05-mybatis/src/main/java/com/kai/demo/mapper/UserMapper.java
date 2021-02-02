package com.kai.demo.mapper;


import com.kai.demo.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是一个mybatis的Mapper类
@Mapper
@Repository
public interface UserMapper {

    List<MyUser> listUsers();
    MyUser getUser(int id);
    int addUser(MyUser myUser);
    int updateUser(MyUser myUser);
    int deleteUser(int id);
}
