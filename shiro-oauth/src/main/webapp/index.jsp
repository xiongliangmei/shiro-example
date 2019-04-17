<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<title>Title</title>
</head>
<body>
index
<shiro:authenticated>
    <a href="./unauthorized.jsp">认证</a>
</shiro:authenticated>

<shiro:hasRole name="xl">
    <a href="./index.jsp">是否有权限</a>
</shiro:hasRole>
</body>
</html>
