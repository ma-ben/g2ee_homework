<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/4/11
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/CourseController">
<table>
    <tr>
        <td><label for="cid">课程序号:</label></td>
        <td>
            <input type="text" id="cid" name="cid" placeholder="课程序号">
        <td>
    </tr>
    <tr>
        <td><label for="cname">课程名称:</label></td>
        <td>
            <input type="text" id="cname" name="cname" placeholder="课程名称">
        <td>
    </tr>
    <tr>
        <td><label for="cnum">选课人数:</label></td>
        <td><input type="text" id="cnum" name="cnum" placeholder="选课人数"></td>
    </tr>
    <tr>
        <td><label for="ctype">课程性质:</label></td>
        <td><input type="text" id="ctype" name="ctype" placeholder="课程性质"></td>
    </tr>
</table>
    <input type="hidden" name="req" value="add">
    <input type="submit" value="增加课程">
</form>

</body>
</html>
