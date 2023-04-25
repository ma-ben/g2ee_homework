package com.example.homework_156;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "CourseController", value = "/CourseController")
public class CourseController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String req=request.getParameter("req");
        if(req.equals("add"))
        {
            if(request.getParameter("cid").isEmpty()||request.getParameter("cname").isEmpty()||request.getParameter("cnum").isEmpty()||request.getParameter("ctype").isEmpty())
            {
                String emsg = URLEncoder.encode("你有信息没填写，不能添加", StandardCharsets.UTF_8);
                response.sendRedirect("courseFailure.jsp?message="+emsg);
                return ;
            }
            String cid=request.getParameter("cid");
            String cname = request.getParameter("cname");
            int cnum = Integer.parseInt(request.getParameter("cnum"));
            String ctype = request.getParameter("ctype");
            String msg;
            Course course=new Course(cid,cname,cnum,ctype);
            CourseService ser=new CourseService();
            CourseDAO cdao=new CourseDAO();
            try {msg=ser.check(course);} catch (SQLException | ClassNotFoundException e) {throw new RuntimeException(e);}
            if(msg.equals("可以添加")) {
                try {cdao.addcourse(course);} catch (SQLException | ClassNotFoundException e) {throw new RuntimeException(e);}
                response.sendRedirect("allCourse.jsp");
            }
            else
            {
                String emsg = URLEncoder.encode(msg, StandardCharsets.UTF_8);
                response.sendRedirect("courseFailure.jsp?message="+emsg);
            }
        }
        else if(req.equals("del"))
        {
            String[] ids = request.getParameterValues("selectedIds");
            CourseDAO cdao = new CourseDAO();
            if (ids == null) {
                String emsg = URLEncoder.encode("你没选择任何课程，不能删除", StandardCharsets.UTF_8);
                response.sendRedirect("courseFailure.jsp?message=" + emsg);
            }
            else
            {
                boolean flag= false;
                StringBuilder emsg = new StringBuilder(URLEncoder.encode("", StandardCharsets.UTF_8));
                for (String id : ids)
                {
                    hitCourseDAO hitcdao = new hitCourseDAO();
                    String nnmm= null;
                    try {
                        nnmm = hitcdao.hadSelectCourse(id);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    if(!Objects.isNull(nnmm))
                    {
                        flag=true;

                        try {
                            emsg.append("\n").append(URLEncoder.encode(nnmm + "选择了" + cdao.getcourse(id).getcName() + "课程，不能删除", StandardCharsets.UTF_8));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        continue;
                    }
                    cdao.deletecourse(id);
                }
                if(flag) response.sendRedirect("courseFailure.jsp?message=" + emsg);
                else response.getWriter().print("<script>alert('delete successful!');window.location.href='allCourse.jsp'</script>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
