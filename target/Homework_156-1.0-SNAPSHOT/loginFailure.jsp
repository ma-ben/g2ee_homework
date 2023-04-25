<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Login Failure!</title>
</head>
<body>
<h1>Login Failure!</h1>
<%
    String emsg = request.getParameter("message");
    String msg = URLDecoder.decode(emsg, StandardCharsets.UTF_8);
    out.println("登陆失败:" + msg);
%>
<br>
<button type="button" onclick="location.href='login.jsp'">点击重新登录</button>

</body>
</html>
