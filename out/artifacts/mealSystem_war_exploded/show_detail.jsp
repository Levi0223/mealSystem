<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/12/12
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜品详情</title>
</head>
<style>
    th{
        width: 20%;
    }
</style>
<body>
<h2 align="center">菜品详情</h2>
<c:if test="${not empty food}">
    <table width="50%" border="1" align="center">
        <tr>
            <th>菜名</th>
            <td>${food.foodname}</td>
        </tr>
        <tr>
            <th>特色</th>
            <td>${food.feature}</td>
        </tr>
        <tr>
            <th>食材</th>
            <td>${food.material}</td>
        </tr>
        <tr>
            <th>价格</th>
            <td>${food.price}元</td>
        </tr>
        <tr>
            <th>类型</th>
            <td>${food.typename}</td>
        </tr>
        <tr>
            <th>图片</th>
            <td><img src="${food.picture}" alt="${food.foodname}"></td>
        </tr>
        <tr>
            <th>点击率</th>
            <td>${food.hits}次</td>
        </tr>
        <tr>
            <th>备注</th>
            <td>
                <c:if test="${food.comment eq 0}">厨师推荐</c:if>
                <c:if test="${food.comment gt 0}">特价${food.comment}元</c:if>
            </td>
        </tr>

    </table>
</c:if>
</body>
</html>
