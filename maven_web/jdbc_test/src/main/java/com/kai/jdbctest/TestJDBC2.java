package com.kai.jdbctest;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String username = "root";
        String password = "123456";
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //编写SQL
        //String sql = "select * from myusers";
        String sql="insert into myusers(id,name,password,email,birthday) value (?,?,?,?,?)";

        //预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery(sql);
//        while (resultSet.next()) {
//            System.out.println("id=" + resultSet.getObject("id"));
//            System.out.println("name=" + resultSet.getObject("name"));
//            System.out.println("password=" + resultSet.getObject("password"));
//            System.out.println("email=" + resultSet.getObject("email"));
//            System.out.println("birthday=" + resultSet.getObject("birthday"));
//        }
        preparedStatement.setInt(1,5);//给第一个占位符 ? 的值赋值为1
        preparedStatement.setString(2,"kai");//给第一个占位符 ? 的值赋值为kai
        preparedStatement.setString(3,"1111");
        preparedStatement.setString(4,"1111@qq.com");
        preparedStatement.setString(5,"2000-01-05");

        //执行SQL
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("ok");
        }

        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
