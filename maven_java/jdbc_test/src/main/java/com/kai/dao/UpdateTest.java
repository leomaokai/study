package com.kai.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class UpdateTest {

    public <T>boolean deleteone(Class<T> tClass, String sql, Object... args) {
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
                return true;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            BaseDao.closeResources(conn, ps, rs);
        }
        return false;
    }
}
