package com.example.homework_156;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void adduser(Login g) throws SQLException, ClassNotFoundException {
                //获取连接
                Connection conn = Mysql.getConnection();
                //sql
                String sql = "INSERT INTO user(uId, uName, uPw, uSchool, uDepartment)"
                        +"values("+"?,?,?,?,?)";
                //预编译
                PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

                //传参
                ptmt.setString(1,g.getUid() );
                ptmt.setString(2, g.getUsername());
                ptmt.setString(3, g.getPassword());
                ptmt.setString(4, g.getSchool());
                ptmt.setString(5,g.getDept());

                //执行
                ptmt.execute();
                ptmt.close();
                conn.close();
        }
        public Login getuser(String uid) throws SQLException, ClassNotFoundException {
                Login g = null;
                //获取连接
                Connection conn = Mysql.getConnection();
                //sql, 每行加空格
                String sql = "select * from  user where uid=?";
                //预编译SQL，减少sql执行
                PreparedStatement ptmt = conn.prepareStatement(sql);
                //传参
                ptmt.setString(1, uid);
                //执行
                ResultSet rs = ptmt.executeQuery();
                while(rs.next()){
                        g = new Login();
                        g.setUid(uid);
                        g.setUsername(rs.getString("uName"));
                        g.setPassword(rs.getString("uPw"));
                        g.setSchool(rs.getString("uSchool"));
                        g.setDept(rs.getString("uDepartment"));
                }
                ptmt.close();
                conn.close();
                return g;
        }
}
