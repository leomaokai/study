<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--JSP表达式
    用来将程序的输出输出到客户端
    <%= 变量或者表达式%>
--%>
<%=new java.util.Date()%>
<hr>

<%--JSP脚本片段--%>
<%
    int sum=0;
    for (int i = 0; i < 100; i++) {
        sum+=i;
    }
    out.println(sum);
%>

<%
    for (int i = 0; i < 5; i++) {


%>
    <h1>Hello,JSP <%=i%></h1>
<%
    }
%>


</body>
</html>
