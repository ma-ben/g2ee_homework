<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>course Failure!</title>
</head>
<body>
<h1>course Failure!</h1>

<%
    String emsg = request.getParameter("message");
    String msg = URLDecoder.decode(emsg, StandardCharsets.UTF_8);
    String formattedMsg = msg.replace("\n", "<br>");
    out.println("操作失败: " + formattedMsg);
%>
<br>
<button type="button" onclick="location.href='allCourse.jsp'">点击返回课表</button>

</body>
</html>