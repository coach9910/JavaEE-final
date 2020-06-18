package org.example.spring.jdbc;

import org.example.spring.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleJdbc {
    public static List<Role> selectAllr(){
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        String sqlString = "SELECT * FROM role";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Role> list =new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(allUrl)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        Role r= new Role();
                        r.setUsername(resultSet.getString("username"));
                        r.setPassword(resultSet.getString("password"));
                        r.setRole(resultSet.getString("role"));
                        list.add(r);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public static void Register(Role r)throws SQLException{
        String url = "jdbc:mysql://127.0.0.1:3306/test2";

        String allUrl = url + "?user=root&password=991015";

        String driverName = "com.mysql.jdbc.Driver";

        Connection connection =  DriverManager.getConnection(allUrl);


        try {
            String sqlString = "insert into role(username, password, role) values (?,?,?)";
            PreparedStatement t = connection.prepareStatement(sqlString);
            List<Role> s = RoleJdbc.selectAllr();
            t.setString(1,r.getUsername());
            t.setString(2,r.getPassword());
            t.setString(3,r.getRole());
            t.execute();
            Class.forName(driverName);// 加载驱动

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
