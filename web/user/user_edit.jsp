<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2019/12/19
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网络点餐系统用户信息修改</title>
</head>
<body>
<%@ include file="user_head.jsp" %>
<form action="user_update.cc" method="post" id="myform">
    <h1 align="center">用&nbsp;户&nbsp;注&nbsp;册</h1>
    <table align="center" class="default">
        <tr>
            <th colspan="2">用户信息修改</th>
        </tr>

        <tr>
            <td>用户名：</td>
            <td><input type="text" placeholder="请输入你的用户名：" name="username" required readonly value="${user.username}"/>
            </td>
        </tr>
        <tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" placeholder="请输入你的密码：" name="password" required/></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" placeholder="请输入你的电话：" name="tel" required value="${user.telephone}"/></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><textarea name="address" placeholder="请输入你的地址：" required rows="3" cols="20">${user.address}</textarea></td>
        </tr>


        <tr>
            <td></td>
            <td>
                <input type="submit" value="修改"/>
                <input type="reset"/>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
