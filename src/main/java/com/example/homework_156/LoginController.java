package com.example.homework_156;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String school = request.getParameter("school");
        String dept = request.getParameter("dept");
        String ver=request.getParameter("ver-code");
        LoginService ser=new LoginService();
        String msg= null;

        try {
            msg = ser.check(new Login(id,username,pwd,school,dept),ver);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(msg.equals("登陆成功！"))
        {
                    request.getSession().setAttribute("uId",id);
        request.getSession().setAttribute("uName",username);
            response.sendRedirect("main.jsp?");
        }
        else
        {
            String emsg = URLEncoder.encode(msg, StandardCharsets.UTF_8);
            response.sendRedirect("loginFailure.jsp?message="+emsg);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
