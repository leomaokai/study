package com.kai.mapper;

import com.kai.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> listUser() {

//        SqlSession sqlSession = getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.listUser();
//        return users;
        return getSqlSession().getMapper(UserMapper.class).listUser();
    }
}
