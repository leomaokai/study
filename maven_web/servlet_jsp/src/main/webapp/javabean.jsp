<%@ page import="com.kai.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //People people = new People();
%>
<jsp:useBean id="people" class="com.kai.pojo.People" scope="page"/>

<jsp:setProperty name="people" property="address" value="xian"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="20"/>
<jsp:setProperty name="people" property="name" value="leo"/>

name:<jsp:getProperty name="people" property="name"/>
id:<jsp:getProperty name="people" property="id"/>
age:<jsp:getProperty name="people" property="age"/>
address:<jsp:getProperty name="people" property="address"/>

</body>
</html>
