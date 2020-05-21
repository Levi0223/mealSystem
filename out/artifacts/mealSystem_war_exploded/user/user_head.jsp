<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/12/19
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1 style="text-align: center">欢迎${login_name},进入点餐系统</h1>
<hr style="border: 1px solid #00FF00">
<p style="text-align: right">
    <a href="${pageContext.request.contextPath}/user_index.cc">用户首页</a>
    <a href="${pageContext.request.contextPath}/user_show_dc.cc">查看点餐车</a>
    <a href="${pageContext.request.contextPath}/user_edit.cc">修改用户资料</a>
    <a href="${pageContext.request.contextPath}/user_exit.cc">退出点餐系统</a>
</p>