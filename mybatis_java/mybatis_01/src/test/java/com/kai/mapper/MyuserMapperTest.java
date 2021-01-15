package com.kai.mapper;

import com.kai.pojo.Myuser;
import com.kai.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyuserMapperTest {

    @Test
    public void test() {

        //获得SqlSession对象

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:getMapper
        MyuserMapper mapper = sqlSession.getMapper(MyuserMapper.class);
        List<Myuser> userList = mapper.getUserList();

//        //方式二:
//        List<Myuser>  userList= sqlSession.selectList("com.kai.dao.MyuserDao.getUserList");


        for (Myuser myuser : userList) {
            System.out.println(myuser);
        }


        //关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void getuserbyid() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        MyuserMapper mapper = sqlSession.getMapper(MyuserMapper.class);
        Myuser userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void adduser() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyuserMapper mapper = sqlSession.getMapper(MyuserMapper.class);
        int leo = mapper.addUser(new Myuser(4, "hello", "111111"));
        if (leo > 0) {
            System.out.println("ok");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateuser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyuserMapper mapper = sqlSession.getMapper(MyuserMapper.class);
        int kklt = mapper.updateUser(new Myuser(4, "kklt", "666666"));
        if (kklt > 0) {
            System.out.println("ok");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteuser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyuserMapper mapper = sqlSession.getMapper(MyuserMapper.class);
        int i = mapper.deleteUser(4);
        if (i > 0) {
            System.out.println("ok");
        }
        sqlSession.commit();
        sqlSession.close();
    }


    static Logger logger = Logger.getLogger(MyuserMapperTest.class);

    @Test
    public void testlog4j() {
        logger.info("info:进入了log4j方法");
        logger.debug("debug:进入了log4j方法");
        logger.error("error:进入了log4j方法");
    }

    @Test
    public void testlimt(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyuserMapper mapper = sqlSession.getMapper(MyuserMapper.class);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("startIndex",0);
        hashMap.put("pageSize",10);
        List<Myuser> userListbyLimit = mapper.getUserListbyLimit(hashMap);
        for (Myuser myuser : userListbyLimit) {
            System.out.println(myuser);
        }
        sqlSession.close();;
    }
    @Test
    public void testRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RowBounds rowBounds = new RowBounds(0, 5);
        List<Myuser> userlist = sqlSession.selectList("com.kai.mapper.MyuserMapper.getUserByRowBounds",null,rowBounds);
        for (Myuser myuser : userlist) {
            System.out.println(myuser);
        }
        sqlSession.close();
    }
}
