package com.kai.dao.role;

import com.kai.dao.BaseDao;
import com.kai.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{


    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet resultSet=null;
        List<Role> roleList=new ArrayList<Role>();
        if(connection!=null){
            String sql="select * from smbms_role";
            Object[] params={};
            resultSet = BaseDao.execute(connection, pstm, resultSet, sql, params);

            while(resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRoleName(resultSet.getString("roleName"));
                role.setRoleCode(resultSet.getString("roleCode"));
                roleList.add(role);
            }
            BaseDao.closeResource(null,pstm,resultSet);
        }
        return roleList;
    }
}
