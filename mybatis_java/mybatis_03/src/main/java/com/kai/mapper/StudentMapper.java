package com.kai.mapper;

import com.kai.pojo.Student;

import java.util.List;

public interface StudentMapper{

    //查询所有的学生信息,以及对应的老师信息
    public List<Student> listStudent();
    public List<Student> listStudent2();
}
