<%@ page import="com.HuangQingyun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 原生优质青年
  Date: 2021/4/15
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user1=(User) session.getAttribute("user");
%>
<table  >
    <tr>
        <td>ID</td><td><%=user1.getId()%></td>
    <tr></tr>
        <td>Username</td><td><%=user1.getUsername()%></td>
    <tr></tr>
        <td>Password</td><td><%=user1.getPassword()%></td>
    <tr></tr>
        <td>Email</td><td><%=user1.getEmail()%></td>
    <tr></tr>
        <td>Gender</td><td><%=user1.getGender()%></td>
    <tr></tr>
        <td>Birthdate</td><td><%=user1.getBirthdate()%></td>
    <tr></tr>
    <td><a href="updateUser">Update<a/></td>
    </tr>

</table>
<%@include file="footer.jsp"%>
