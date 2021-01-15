package com.kai.mytest;

import com.kai.mapper.StudentMapper;
import com.kai.mapper.TeacherMapper;
import com.kai.pojo.Student;
import com.kai.pojo.Teacher;
import com.kai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {

    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> listStudent = mapper.listStudent();
        for (Student student : listStudent) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> listStudent = mapper.listStudent2();
        for (Student student : listStudent) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
