<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.homework_156.CourseDAO" %>
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
    <title>deleteCourse</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/CourseController">
<table >
  <thead>
  <tr >
    <th width="30"></th>
    <th width="50">序号</th>
    <th width="200">课程名称</th>
    <th width="100">选课人数</th>
    <th width="50">课程性质</th>
  </tr>
  </thead>
  <tbody>
<%
CourseDAO courseDAO = new CourseDAO();
int pageSize = 4; // 每页显示的行数
int maxNum = 0; // 最大页数
maxNum= courseDAO.getcoursecount()%pageSize==0?courseDAO.getcoursecount()/pageSize:courseDAO.getcoursecount()/pageSize+1;
int pageNum =1;
if(request.getParameter("pageNum")!=null)
{
  int tmp=Integer.parseInt(request.getParameter("pageNum"));
  if(tmp<1)  tmp=1;
  else if(tmp>maxNum) tmp=maxNum;
  pageNum=tmp;
}
else pageNum=1;
ResultSet res = courseDAO.pageQuery(pageSize, pageNum);
int i=0;
    while(res.next()){i++;
        String id = res.getString("cId");
        String name = res.getString("cName");
        int num = res.getInt("cNum");
        String type = res.getString("cType");
  %>
  <tr style="height: 50px;">
    <td><input type="checkbox" name="selectedIds" value=<%=id%>></td>
    <td><%=id%></td>
    <td><%=name%></td>
    <td><%=num%></td>
    <td><select name="Type">
      <option value="选修" <% if (type.equals("选修")) { %>selected<% } %>>选修</option>
      <option value="必修" <% if (type.equals("必修")) { %>selected<% } %>>必修</option>
    </select>
    </td>
  <%}while(i++<4){%>
    <tr style="height: 50px;">
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  <%}%>

  </tbody>
</table>
<br><br>
<div style="text-align:center;">
    <input type="hidden" name="req" value="del">
    <input type="submit" value="删除课程">
</div>
</form>

<div style="text-align:center;">
    <button onclick="location.href='?pageNum=1'">首页</button>
  <button onclick="location.href='?pageNum=<%= pageNum - 1 %>'">上一页</button>
  <button onclick="location.href='?pageNum=<%= pageNum + 1 %>'">下一页</button>
    <button onclick="location.href='?pageNum=<%= maxNum%>'">末页</button>
</div>
</body>
</html>
