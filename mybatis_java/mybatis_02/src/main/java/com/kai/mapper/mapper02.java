package com.kai.mapper;

import com.kai.pojo.Myuser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface mapper02 {

    @Select("select * from myuser")
    List<Myuser> getUserList();

    //多个参数时,参数前面必须加上@Param注解
    @Select("select * from myuser where id=#{id} and name=#{name} ")
    Myuser getUserByIDNAME(@Param("id")int id,@Param("name") String name);

    @Insert("insert into myuser(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(Myuser user);

    @Update("update myuser set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(Myuser user);

    @Delete("delete from myuser where id=#{id}")
    int deleteUser(@Param("id") int id);
}
