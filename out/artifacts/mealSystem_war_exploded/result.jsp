<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/11/28
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="color: #7FFFD4">操作提示界面</h2>
<h3 style="color: aqua">${requestScope.msg}</h3>
<a href="${href}">${empty href ? "" : "返回"}</a>
</body>
</html>
