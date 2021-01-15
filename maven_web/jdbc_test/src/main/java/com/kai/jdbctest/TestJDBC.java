package com.kai.jdbctest;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";

        String username = "root";
        String password = "123456";

        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //向数据库发送SQL的对象
        Statement statement = connection.createStatement();

        //编写SQL
        String sql = "select * from myusers";
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
