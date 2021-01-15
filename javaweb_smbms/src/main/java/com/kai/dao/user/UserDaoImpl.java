package com.kai.dao.user;

import com.kai.dao.BaseDao;
import com.kai.pojo.Role;
import com.kai.pojo.User;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (connection != null) {
            String sql = "select * from smbms_user where userCode=? ";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    @Override
    public int updatePwd(Connection connection, int id, String password) throws SQLException {

        PreparedStatement pstm = null;
        int execute = 0;
        if (connection != null) {
            String sql = "update smbms_user set userPassword=? where id=?";
            Object[] params = {password, id};
            execute = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return execute;
    }

    @Override
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms.smbms_user u, smbms.smbms_role r where u.userRole=r.id");

            ArrayList<Object> list = new ArrayList<>();//存放我们的参数
            if (!StringUtils.isNullOrEmpty(username)) {
                sql.append(" and u.userName like ? ");
                list.add("%" + username + "%");
            }
            if (userRole > 0) {
                sql.append(" and u.userRole = ?  ");
                list.add(userRole);
            }
            //将List转换为数组
            Object[] objects = list.toArray();
            System.out.println(sql.toString());
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), objects);
            if (rs.next()) {
                count = rs.getInt("count");
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return count;
    }

    @Override
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<User> userlist = new ArrayList<User>();
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");

            ArrayList<Object> list = new ArrayList<Object>();//存放我们的参数
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ? ");
                list.add("%" + userName + "%");
            }
            if (userRole > 0) {
                sql.append(" and u.userRole = ?  ");
                list.add(userRole);
            }
            //在数据库中,分页使用 limit startIndex,pageSize
            //0,5   0  1  2  3  4
            //5,5   5  6  7  8  9
            //10,5  10 11 12 13 14
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] objects = list.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), objects);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setUserRole(rs.getInt("userRole"));
                user.setUserRoleName(rs.getString("userRoleName"));
                userlist.add(user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userlist;
    }

}
