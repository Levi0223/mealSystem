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
<%@ include file="user_head.jsp"%>
<form action="user_index.cc" method="post">
    <label>
        <select name="type">
            <option value="" >全部</option>
            <c:forEach items="${foodTypes}" var="type">
                <option value="${type.id}" ${type.id==param.type?'selected':''}>${type.typename}</option>
            </c:forEach>
        </select>
    </label>

    <input type="text" name="sn" placeholder="请输入菜名" value="${param.sn}">
    <input type="submit" value="搜索">
</form>
<form action="user_add_dc.cc" method="post">
    <table border="1">
        <tr>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
            <th>6</th>
            <th>7</th>
            <th>8</th>
            <th>9</th>
        </tr>
        <c:forEach items="${allFood}" var="food" varStatus="vs">
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
                        <input type="checkbox" name="FIds" value="${food.id}">
                    </label>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div align="center">
        <input type="submit" value="加入点餐车">
    </div>
</form>


</body>
</html>
