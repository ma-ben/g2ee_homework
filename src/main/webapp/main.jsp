<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>main</title>
</head>


<body>
<h1>Login Successful!</h1>

<div style="font-size:80px">
    <p>还有  <span id="countdown">5</span>  秒跳转</p>
</div>

</body>
</html>


<script>
    let countdown = 1;
    const timer = setInterval(function () {
        countdown--;
        document.getElementById("countdown").innerHTML = countdown;
        if (countdown === 0) {
            clearInterval(timer);
            window.location.href = "hitCourse.jsp?";
        }
    }, 1000);//每一秒执行一次
</script>