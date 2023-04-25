<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>transformation.jsp</title>
</head>
<body>
<%!

    int x=120,y=99;String str="我是马韬";Date date;
    public void function()
    {
        System.out.println(str+",这是定义的方法");
    }
%>

<h1>1.JSP表达式 </h1>
<b>  显示时间： </b><%= new Date().toString() %>  <b>  ；PI 的值： </b><%=Math.PI %><br>
<button onclick="increment()">（点击增加数字）你已经点击了<span id="counter">0</span>次</button>

<%@ include file = "include.html" %>

<jsp:useBean id="bean" class="com.example.homework_156.MyBean" scope="page"/>

设置属性值前：<jsp:getProperty name="bean" property="val"/><br>


<%-- 设置JavaBean对象的属性 --%>
<jsp:setProperty name="bean" property="val" value="999" />
设置属性值后：<jsp:getProperty name="bean" property="val"/>


<%-- jsp注释 --%>
<!-页面调用日期为<%= (new java.util.Date()).toString() %> -->
</body>
</html>



<script>
    let count = 0;
    function increment() {
        count++;
        document.getElementById("counter").innerHTML = count.toString();
    }
</script>