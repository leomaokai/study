<%--
  Created by IntelliJ IDEA.
  User: LEOMESSI
  Date: 2021/1/12
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="rew clearfix">
        <div class="col-md-12 colum">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updatebook" method="post">

        <%--隐藏域传递--%>
        <input type="hidden" name="bookID" value="${getbook.bookID}">

        <div class="form-group">
            <label for="book1">书籍名称</label>
            <input type="text" name="bookName" class="form-control" value="${getbook.bookName}" id="book1" required>
        </div>
        <div class="form-group">
            <label for="book2">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${getbook.bookCounts}" id="book2" required>
        </div>
        <div class="form-group">
            <label for="book3">书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${getbook.detail}" id="book3" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>

</div>
</body>
</html>
