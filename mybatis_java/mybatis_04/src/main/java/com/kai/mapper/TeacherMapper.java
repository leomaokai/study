package com.kai.mapper;

import com.kai.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);

    //获取老师下的所有学生和老师的信息
    Teacher getTeachers(@Param("tid")int id);
    Teacher getTeachers2(@Param("tid")int id);
}