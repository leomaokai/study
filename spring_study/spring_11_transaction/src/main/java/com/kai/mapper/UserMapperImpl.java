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
        addUser(new User(16,"zhangsan","2222"));
        deleteUser(16);
        return mapper.listUser();
    }

    @Override
    public int addUser(User user) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return sqlSession.getMapper(UserMapper.class).deleteUser(id);
    }


}
