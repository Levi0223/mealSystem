<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/12/11
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网络点餐系统</title>
    <style>
        h1{
            text-align: center;
            color: pink;
        }

        div{
            text-align: center;
        }
    </style>
</head>
<body>

<br />
<h1>网络点餐系统</h1>

<div>
    <a href="homepage.cc">进入点餐系统</a>
    <a href="login.html">登录</a>
    <a href="register.html">注册</a>
</div>
<br />
<table align="center">
    <tr>
        <td colspan="3"><b>热门菜品</b></td>
    </tr>
    <tr>
        <c:forEach items="${hot}" var="food">
            <td>
                <img src="${food.picture}" alt="${food.foodname}"/><br>
                <a href="show_detail.cc?id=${food.id}" target="_blank">${food.foodname}</a>
                ${food.price}元
            </td>
        </c:forEach>
    </tr>
    <tr>
        <td colspan="3"><b>今日特价</b></td>
    </tr>
    <tr>
        <c:forEach items="${cheap}" var="food">
            <td>
                <img src="${food.picture}" alt="${food.foodname}"/><br>
                <a href="show_detail.cc?id=${food.id}" target="_blank">${food.foodname}</a>
                    ${food.comment}元
            </td>
        </c:forEach>
    </tr>
    <tr>
        <td colspan="3"><b>厨师推荐</b></td>
    </tr>
    <tr>
        <c:forEach items="${chiefRecommend}" var="food">
            <td>
                <img src="${food.picture}" alt="${food.foodname}"/><br>
                <a href="show_detail.cc?id=${food.id}" target="_blank">${food.foodname}</a>
                    ${food.price}元
            </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
