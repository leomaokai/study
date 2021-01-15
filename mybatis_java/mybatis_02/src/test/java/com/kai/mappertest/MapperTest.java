package com.kai.mappertest;

import com.kai.mapper.mapper02;
import com.kai.pojo.Myuser;
import com.kai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MapperTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        mapper02 mapper = sqlSession.getMapper(mapper02.class);
        List<Myuser> userList = mapper.getUserList();
        for (Myuser myuser : userList) {
            System.out.println(myuser);
        }

        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        mapper02 mapper = sqlSession.getMapper(mapper02.class);
        Myuser user = mapper.getUserByIDNAME(1, "messi");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        mapper02 mapper = sqlSession.getMapper(mapper02.class);
        mapper.addUser(new Myuser(16,"test03","111113"));
        sqlSession.close();
    }
    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        mapper02 mapper = sqlSession.getMapper(mapper02.class);
        mapper.updateUser(new Myuser(16,"test04","111114"));
        sqlSession.close();
    }
    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        mapper02 mapper = sqlSession.getMapper(mapper02.class);
        mapper.deleteUser(16);
        sqlSession.close();
    }
}
