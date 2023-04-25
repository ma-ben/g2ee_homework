package com.example.homework_156;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class CourseDAO {

    //添加课程
    public void addcourse(@NotNull Course c) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql
        String sql = "INSERT INTO course(cId, cName, cNum, cType)"
                +"values("+"?,?,?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1,c.getcId() );
        ptmt.setString(2, c.getcName());
        ptmt.setInt(3, c.getcNum());
        ptmt.setString(4, c.getcType());
        //执行
        ptmt.execute();
        ptmt.close();
        conn.close();
    }

    //获取所有课程
    public ResultSet getallcourse() throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn;
        conn = Mysql.getConnection();
        //sql, 每行加空格
        String sql = "select * from  course";

        //预编译SQL，减少sql执行
        Statement ptmt = null;
            ptmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //执行
        return ptmt.executeQuery(sql);
    }

    public ResultSet pageQuery(int pageSize, int pageNum) throws SQLException, ClassNotFoundException {
int start = (pageNum - 1) * pageSize; // 起始位置
        //获取连接
        Connection conn;
        conn = Mysql.getConnection();
// 执行分页查询
String sql = "SELECT * FROM course LIMIT ? OFFSET ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, pageSize);
pstmt.setInt(2, start);
ResultSet rs = pstmt.executeQuery();
return rs;
    }
    //判断课程号是否存在
    public boolean hadcourseid(String cid) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql, 每行加空格
        String sql = "select * from  course where cId=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, cid);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if(rs.next())
        {
            ptmt.close();
            conn.close();
            return true;
        }
        else
        {
            ptmt.close();
            conn.close();
            return false;
        }
    }


    public int getcoursecount() throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        String sql = "select count(*) from  course";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
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

    //判断课程名是否存在
    public boolean hadcoursename(String cName) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql, 每行加空格
        String sql = "select * from  course where cName=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, cName);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()) {
            ptmt.close();
            conn.close();
            return true;
        } else {
            ptmt.close();
            conn.close();
            return false;
        }
    }

    public Course getcourse(String id) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql, 每行加空格
        String sql = "select * from  course where cId=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, id);
        //执行
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()) {
            Course c = new Course();
            c.setcId(rs.getString("cId"));
            c.setcName(rs.getString("cName"));
            c.setcNum(rs.getInt("cNum"));
            c.setcType(rs.getString("cType"));
            return c;
        } else {
            return null;
        }
    }
    //删除课程
    public void deletecourse(String id) {

        //获取连接
        Connection conn = null;
        try {
            conn = Mysql.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        //sql, 每行加空格
        String sql = "delete from  course where cId=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //传参
        try {
            ptmt.setString(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //执行
        try {
            ptmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updatecourse(@NotNull Course c) throws SQLException, ClassNotFoundException {
        //获取连接
        Connection conn = Mysql.getConnection();
        //sql, 每行加空格
        String sql = "update course set cName=?,cNum=?,cType=? where cId=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setString(1, c.getcName());
        ptmt.setInt(2, c.getcNum());
        ptmt.setString(3, c.getcType());
        ptmt.setString(4, c.getcId());
        //执行
        ptmt.executeUpdate();
    }
}
