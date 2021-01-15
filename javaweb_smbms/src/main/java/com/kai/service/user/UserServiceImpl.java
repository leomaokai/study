package com.kai.service.user;

import com.kai.dao.BaseDao;
import com.kai.dao.user.UserDao;
import com.kai.dao.user.UserDaoImpl;
import com.kai.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    //业务层都会调用Dao层,所以我们要引用Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao=new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection=null;
        User user=null;
        try {
            connection= BaseDao.getConnection();
            //通过Dao层调用具体的数据库操作
            user=userDao.getLoginUser(connection,userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public boolean updatePwd(int id, String password) {
        Connection connection=null;
        boolean flag=false;

        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePwd(connection,id,password)>0){
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    @Override
    public int getUserCount(String username, int userRole) {

        Connection connection = null;
        int count=0;
        System.out.println("queryUserName ---- > " + username);
        System.out.println("queryUserRole ---- > " + userRole);
        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return count;
    }
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null,0);
        System.out.println(userCount);
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {

        Connection connection=null;
        List<User> users = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
            users = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return users;
    }
    @Test
    public void testget(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = userService.getUserList("",1,1,5);
        System.out.println(userList);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

}


