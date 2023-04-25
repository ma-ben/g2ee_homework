package com.example.homework_156;

import java.sql.*;
public class Mysql {

    public static String URL = "jdbc:mysql://localhost:3306/156_JDBC";
    public static final String USER = "root";
    public static final String PASSWORD = "tq200155";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获得数据库连接
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
