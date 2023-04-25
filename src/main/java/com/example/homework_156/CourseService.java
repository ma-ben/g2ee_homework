package com.example.homework_156;

import java.sql.SQLException;

public class CourseService {
    public String check(Course course) throws SQLException, ClassNotFoundException {
        CourseDAO cdao=new CourseDAO();
        if(cdao.hadcourseid(course.getcId()))
        {
            return "课程序号已存在";
        }
        else if(cdao.hadcoursename(course.getcName()))
        {
            return "课程名已存在";
        }
        else return "可以添加";
    }
}
