<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="com.example.homework_156.CourseDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.homework_156.hitCourseDAO" %>
<%@ page import="com.example.homework_156.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <style>
    table {
      border-collapse: collapse;
      margin: auto; /* 表格居中 */
    }
    td, th {
      border: 1px solid black;
      padding: 8px;
    }
    th {
      background-color: #ccc;
    }
  </style>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/hitCourseController">
<%
String ccid = request.getSession().getAttribute("uId").toString();
String ccname = request.getSession().getAttribute("uName").toString();
%>
<div style="text-align:center;">
  <span>学号： <%=ccid %></span>
  <span style="margin:0 80px;"></span>
  <span>姓名： <%=ccname %></span>
</div>

<table >
  <thead>
  <tr >
    <th width="30"></th>
    <th width="50">序号</th>
    <th width="200">课程名称</th>
    <th width="100">分数</th>
  </tr>
  </thead>
  <tbody>
<%
hitCourseDAO hitcourse = new hitCourseDAO();
int pageSize = 4; // 每页显示的行数
int maxNum = 0; // 最大页数
maxNum= hitcourse.getcoursecount(ccid)%pageSize==0?hitcourse.getcoursecount(ccid)/pageSize:hitcourse.getcoursecount(ccid)/pageSize+1;
int pageNum =1;
if(request.getParameter("pageNum")!=null)
{
  int tmp=Integer.parseInt(request.getParameter("pageNum"));
  if(tmp<1)  tmp=1;
  else if(tmp>maxNum) tmp=maxNum;
  pageNum=tmp;
}
else pageNum=1;
ResultSet res = hitcourse.pageQuery(pageSize, pageNum,ccid);
int i=0;
    while(res.next()){i++;
      CourseDAO course = new CourseDAO();
        Course c= course.getcourse(res.getString("cId"));
        String id = res.getString("cId");
        String name = c.getcName();
        int num = res.getInt("score");
  %>
  <tr style="height: 50px;">
    <td><input type="checkbox" name="selectedIds" value=<%=id%>></td>
    <td><%=id%></td>
    <td><%=name%></td>
    <td><%=num%></td>
  <%}while(i++<4){%>
    <tr style="height: 50px;">
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  <%}%>
  </tbody>
</table>
  <div style="text-align:center;">
    <input type="hidden" name="req" value="del">
    <input type="submit" value="退选课程">
</div>
  </form>
<br><br>
<div style="text-align:center;">
  <button onclick="location.href='allCourse.jsp'">课程管理</button>
    <button onclick="location.href='?pageNum=1'">首页</button>
  <button onclick="location.href='?pageNum=<%= pageNum - 1 %>'">上一页</button>
  <button onclick="location.href='?pageNum=<%= pageNum + 1 %>'">下一页</button>
    <button onclick="location.href='?pageNum=<%= maxNum%>'">末页</button>
    <a>每页4条</a>
  <a>共<%=maxNum%>页</a>
  </div>
</body>
</html>
