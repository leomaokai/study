package com.kai.mapper;

import com.kai.pojo.Myuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MyuserMapper {

    //根据ID查询用户
    Myuser getUserById(@Param("id") int id);
}
