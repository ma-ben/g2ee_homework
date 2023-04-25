package com.example.homework_156;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Objects;

public class hitCourseDAO {
    public void addCourse(String uId,String cId) {
                //获取连接
        Connection conn = null;
        try {
            conn = Mysql.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        //sql
        String sql = "INSERT INTO hitcourse(uId, cId, score)"
                +"values("+"?,?,?)";
        //预编译
        PreparedStatement ptmt = null; //预编译SQL，减少sql执行
        try {
            ptmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //传参
        try {
            ptmt.setString(1,uId );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ptmt.setString(2, cId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ptmt.setInt(3, 100);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //执行
        try {
            ptmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ptmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCourse(String uId,String cId){
        //获取连接
        Connection conn = null;
        try {
            conn = Mysql.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        //sql
        String sql = "DELETE FROM hitcourse WHERE uId=? AND cId=?";
        //预编译
        PreparedStatement ptmt = null; //预编译SQL，减少sql执行
        try {
            ptmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //传参
        try {
            ptmt.setString(1,uId );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ptmt.setString(2, cId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //执行
        try {
            ptmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ptmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean hadCourseById(String uId,String cId) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql
        String sql = "SELECT * FROM hitcourse WHERE uId=? AND cId=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
        //传参
        ptmt.setString(1,uId );
        ptmt.setString(2, cId);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if(rs.next()) return true;
        else return false;
    }
    public String hadSelectCourse(String cId) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql
        String sql = "SELECT * FROM hitcourse WHERE cId=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
        //传参
        ptmt.setString(1, cId);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if(rs.next()) {
            LoginDAO ldao = new LoginDAO();
            Login l = ldao.getuser(rs.getString("uId"));
            if (!Objects.isNull(l)) return l.getUsername();
            else return null;
        }
        else return null;
    }
    public ResultSet pageQuery(int pageSize, int pageNum,String uId) throws SQLException, ClassNotFoundException {
        int start = (pageNum - 1) * pageSize; // 起始位置
        //获取连接
        Connection conn;
        conn = Mysql.getConnection();
        // 执行分页查询
        String sql = "SELECT * FROM hitcourse WHERE uId=? LIMIT ? OFFSET ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uId);
        pstmt.setInt(2, pageSize);
        pstmt.setInt(3, start);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    public int getcoursecount(String uId) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        String sql = "select count(*) from  hitcourse WHERE uId=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, uId);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if(rs.next())
        {
            return rs.getInt(1);
        }
        else
        {
            return 0;
        }
    }
}
