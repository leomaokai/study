<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/a3", function (data) {
                    console.log(data);
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "</tr>"
                    }
                    $("#content").html(html);
                });
            })
        });
    </script>
</head>
<input type="button" value="加载数据" id="btn">
<body>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <tbody id="content"></tbody>
</table>
</body>
</html>
