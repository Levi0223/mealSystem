<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/12/12
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网络点餐系统用户首页</title>
</head>
<body>
<%@ include file="user_head.jsp"%>

<form action="user_del_dc.cc" method="post">
    <table border="1">
        <tr>
            <th>序号</th>
            <th>菜名</th>
            <th>特色</th>
            <th>主料</th>
            <th>价格（元）</th>
            <th>分类</th>
            <th>图片</th>
            <th>点餐率（次）</th>
            <th>备注</th>
        </tr>
        <c:forEach items="${dc}" var="food" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${food.foodname}</td>
                <td>${food.feature}</td>
                <td>${food.material}</td>
                <td>${food.price}</td>
                <td>${food.typename}</td>
                <td><img src="${pageContext.request.contextPath}/${food.picture}" alt="${food.foodname}"></td>
                <td>
                    <c:if test="${food.comment eq 0}">厨师推荐</c:if>
                    <c:if test="${food.comment gt 0}">特价${food.comment}元</c:if>
                </td>
                <td>
                    <label>
                        <input type="checkbox" name="DcIds" value="${food.dcid}">
                    </label>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div align="center">
        <input type="submit" value="从点餐车删除">
    </div>
</form>


</body>
</html>
