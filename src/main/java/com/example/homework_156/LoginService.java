package com.example.homework_156;

import java.sql.SQLException;

public class LoginService {
    public String check(Login login,String ver) throws SQLException, ClassNotFoundException {
        if(!ver.equals("8774"))
        {
            return "验证码错误！";
        }
        else
        {
            LoginDAO lgd = new LoginDAO();
            Login user = lgd.getuser(login.getUid());
            if(!user.getUsername().equals(login.getUsername())) return "用户名错误";
            if(!user.getPassword().equals(login.getPassword())) return "密码错误";
        }
        return "登陆成功！";
    }

}