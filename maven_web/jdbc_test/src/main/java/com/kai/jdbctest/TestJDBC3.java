package com.kai.jdbctest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC3 {
    @Test
    public void test() {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String username = "root";
        String password = "123456";

        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库


            connection = DriverManager.getConnection(url, username, password);


            //通知数据库打开事务
            connection.setAutoCommit(false);

            String sql = "select * from myusers where id=5";
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();


            //制造错误
            //int i = 1 / 0;
            String sql2 = "select * from myusers where id=4";
            ResultSet resultSet1 = connection.prepareStatement(sql2).executeQuery();

            connection.commit();

            while (resultSet.next()) {
                System.out.println("name=" + resultSet.getObject("name"));
            }
            while (resultSet1.next()) {
                System.out.println("name=" + resultSet1.getObject("name"));
            }
        } catch (Exception throwables) {
            try {
                //如果出现异常,就通知数据库回滚事务
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }

    }
}
