<%--
  Created by IntelliJ IDEA.
  User: LEOMESSI
  Date: 2021/1/12
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="rew clearfix">
        <div class="col-md-12 colum">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addbook" method="post">
        <div class="form-group">
            <label for="book1">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="book1" required>
        </div>
        <div class="form-group">
            <label for="book2">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="book2" required>
        </div>
        <div class="form-group">
            <label for="book3">书籍描述</label>
            <input type="text" name="detail" class="form-control" id="book3" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>

</div>
</body>
</html>
