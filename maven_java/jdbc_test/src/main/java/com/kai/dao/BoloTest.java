package com.kai.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoloTest {

    public void InsertTest() throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql="insert into mytest(name,age,email,image) values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,"test3");
        ps.setObject(2,"22");
        ps.setObject(3,"11111@111");
        FileInputStream is = new FileInputStream(new File(""));
        ps.setBlob(4,is);
    }
}
