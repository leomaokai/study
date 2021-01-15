<%@ page contentType="text/html; charset=UTF-8"  language="java" %>

<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div style="text-align:center">

    <%--以post方式提交表单,提交到我们的login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名:<input type="username" name="username"><br>
        密码:<input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobby" value="C++">C++
        <input type="checkbox" name="hobby" value="Java">Java
        <input type="checkbox" name="hobby" value="Python">Python
        <input type="checkbox" name="hobby" value="Linux">Linux
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>