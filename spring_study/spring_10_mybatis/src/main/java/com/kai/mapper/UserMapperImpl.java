package com.kai.mapper;

import com.kai.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> listUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.listUser();
    }
}
