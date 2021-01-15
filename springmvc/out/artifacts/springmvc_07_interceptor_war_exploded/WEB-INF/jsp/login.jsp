<%--
  Created by IntelliJ IDEA.
  User: LEOMESSI
  Date: 2021/1/15
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录页面</h1>
<form action="${pageContext.request.contextPath}/dologin" method="post">
    <p>
        用户名:
        <input type="text" name="username">
    </p>
    <p>
        密码:
        <input type="text" name="password">
    </p>
    <input type="submit" value="提交">
</form>
</body>
</html>
