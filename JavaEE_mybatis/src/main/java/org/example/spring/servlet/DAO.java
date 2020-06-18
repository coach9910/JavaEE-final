package org.example.spring.servlet;

import org.example.spring.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAO {

        public Role login(Connection con, Role role) throws Exception{
            Role resultUser=null;
            String sql="select * from role where username=? and password=? and role=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, role.getUsername());
            pstmt.setString(2, role.getPassword());
            pstmt.setString(3, role.getRole());
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                resultUser=new Role();
                resultUser.setUsername(rs.getString("username"));
                resultUser.setPassword(rs.getString("password"));
                resultUser.setRole(rs.getString("role"));
            }
            return resultUser;
        }

            //注册功能
         public boolean register(Connection con,Role role) throws Exception{
            boolean flag=false;
            PreparedStatement pstmt = null;
            String sql="INSERT INTO role(username,password,role)VALUES(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, role.getUsername());
            pstmt.setString(2, role.getPassword());
            pstmt.setString(3, role.getRole());
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
            return flag;
        }

}
