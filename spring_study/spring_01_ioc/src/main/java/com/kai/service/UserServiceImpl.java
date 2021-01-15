package com.kai.service;

import com.kai.dao.UserDao;
import com.kai.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    //利用set进行动态实现
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
