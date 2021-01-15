package com.kai.dao;

import com.kai.bean.Mytest;
import com.kai.bean.Myusers;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryTest {

    //查询一个对象
    public <T> T getInstance(Class<T> tClass, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据:ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = tClass.newInstance();
                for (int i = 0; i < columnCount; ++i) {
                    //获取列值
                    Object columnVal = rs.getObject(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //使用反射,给对象相对应的属性赋值
                    Field declaredField = tClass.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnVal);
                }
                return t;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            BaseDao.closeResources(conn, ps, rs);
        }
        return null;
    }

    //查询多个对象
    public <T> List<T> getForList(Class<T> tClass,String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据:ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = tClass.newInstance();
                for (int i = 0; i < columnCount; ++i) {
                    //获取列值
                    Object columnVal = rs.getObject(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //使用反射,给对象相对应的属性赋值
                    Field declaredField = tClass.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnVal);
                }
                list.add(t);
            }
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            BaseDao.closeResources(conn, ps, rs);
        }
        return null;
    }


    @Test
    public void test(){
        //查询单条数据测试
        String sql1="select id,name from myusers where id = ?";
        Myusers myusers = getInstance(Myusers.class, sql1, 2);
        System.out.println(myusers);
        String sql2="select id,name from mytest where id =?";
        Mytest mytest = getInstance(Mytest.class, sql2, 2);
        System.out.println(mytest);
        System.out.println("---------------------------");
        //查询多条数据测试
        String sql3="select id,name,password from myusers where id < ?";
        List<Myusers> list = getForList(Myusers.class, sql3, 5);
        for (Myusers Myusers1 : list) {
            System.out.println(Myusers1);
        }

    }
}
