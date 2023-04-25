package com.example.homework_156;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet(name = "hitCourseController", value = "/hitCourseController")
public class hitCourseController  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String req=request.getParameter("req");
        if(req.equals("add"))
        {
            String[] ids = request.getParameterValues("selectedIds");
            hitCourseDAO hitcdao = new hitCourseDAO();
            if (ids == null) {
                response.sendRedirect("allCourse.jsp");
            }
            else
            {
                for (String id : ids)
                {
                    try {
                        if(!hitcdao.hadCourseById(request.getSession().getAttribute("uId").toString(),id))
                        {
                            CourseDAO cdao= new CourseDAO();
                            Course course = null;
                            try {
                                course = cdao.getcourse(id);
                            } catch (SQLException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            course.setcNum(course.getcNum()+1);
                            try {
                                cdao.updatecourse(course);
                            } catch (SQLException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            hitcdao.addCourse(request.getSession().getAttribute("uId").toString(), id);
                        }
                        else
                        {
                            response.getWriter().print("<script>alert('you have selected this course!');window.location.href='allCourse.jsp'</script>");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                response.getWriter().print("<script>alert('select successful!');window.location.href='hitCourse.jsp'</script>");
            }
        }
        else if(req.equals("del"))
        {
            String[] ids = request.getParameterValues("selectedIds");
            hitCourseDAO hitcdao = new hitCourseDAO();
            if (ids == null) {
                response.sendRedirect("hitCourse.jsp");
            }
            else
            {
                for (String id : ids)
                {
                    CourseDAO cdao= new CourseDAO();
                    Course course = null;
                    try {
                        course = cdao.getcourse(id);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    course.setcNum(course.getcNum()-1);
                    try {
                        cdao.updatecourse(course);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    hitcdao.deleteCourse(request.getSession().getAttribute("uId").toString(),id);
                }
                response.getWriter().print("<script>alert('exit successful!');window.location.href='hitCourse.jsp'</script>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
