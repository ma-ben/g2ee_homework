<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>

<body>
    <h1><%= "Login" %></h1>

    <form method="post" action="${pageContext.request.contextPath}/LoginController">
        <table>
            <tr>
                <td><label for="id">学号:</label></td>
                <td>
                    <input type="text" id="id" name="id" placeholder="学号" value="9211080N0133">
                <td>
            </tr>
            <tr>
                <td><label for="username">用户:</label></td>
                <td>
                    <input type="text" id="username" name="username" placeholder="学生姓名" value="马韬">
                <td>
            </tr>
            <tr>
                <td><label for="pwd">密码:</label></td>
                <td><input type="password" id="pwd" name="pwd" placeholder="密码123" value="123"></td>
            </tr>
            <tr>
                <td><label for="ver-code">验证码:</label></td>
                <td>
                    <input type="text" id="ver-code" name="ver-code" value="8774">
                </td>
                <td><img src="./aaa.jpg" height="30" alt="验证码"><td>
            </tr>
            <tr>
                <td><label for="school">所在学院:</label></td>
                <td><select id="school" name="school" onchange="onSelect1Change()">
                        <option value="computer">计算机学院</option>
                        <option value="foreign">外国语学院</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="dept">所在系:</label></td>
                <td><select id="dept" name="dept">
                        <option value="cs">计算机科学与技术</option>
                        <option value="se">软件工程</option>
                    </select>
                </td>
            </tr>
        </table>

        <table>
            <tr>

                <td><input type="submit" value="登录"></td>
                <td><a href="#">帮助</a></td>
                <td><a href="#">忘密</a></td>
            </tr>
        </table>
    </form>

</body>
</html>

<script>
    function onSelect1Change()
    {
        const dept = document.getElementById("school");
        const val = dept.value;
        const options = [];
        if (val === "computer")
        {
            options.push({ value: "cs", text: "计算机科学与技术" });
            options.push({ value: "se", text: "软件工程" });
        }
        else if (val === "foreign")
        {
            options.push({ value: "english", text: "英语" });
            options.push({ value: "french", text: "法语" });
        }
        const major = document.getElementById("dept");
        major.innerHTML = "";
        for (let i = 0; i < options.length; i++)
        {
            const option = document.createElement("option");
            option.value = options[i].value;
            option.text = options[i].text;
            major.appendChild(option);
        }
    }
</script>