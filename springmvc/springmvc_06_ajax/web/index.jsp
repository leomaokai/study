<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.js"></script>
    <script>
        function a() {
            jQuery.post({
                url: "${pageContext.request.contextPath}/a1",
                data: {"name": $("#username").val()},
                success: function (data,status) {
                    console.log("data:"+data);
                    console.log("status:"+status);
                }
            })
        }

    </script>
</head>
<body>
<%--  失去焦点时发送一个请求到后台--%>

用户名<input type="text" id="username" onblur="a()">

</body>
</html>
