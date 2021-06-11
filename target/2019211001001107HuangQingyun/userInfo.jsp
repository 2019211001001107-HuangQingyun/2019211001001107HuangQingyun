<%--
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
 //read cookies
    Cookie[] Cookies = request.getCookies();
    for(Cookie c:Cookies){
         out.println("<br/>"+c.getName()+"--------"+c.getValue());
    }
%>
<table  >
    <tr>
        <td>ID</td><td><%=request.getAttribute("id")%></td>
    <tr></tr>
        <td>Username</td><td><%=request.getAttribute("username")%></td>
    <tr></tr>
        <td>Password</td><td><%=request.getAttribute("password")%></td>
    <tr></tr>
        <td>Email</td><td><%=request.getAttribute("email")%></td>
    <tr></tr>
        <td>Gender</td><td><%=request.getAttribute("Gender")%></td>
    <tr></tr>
        <td>Birthdate</td><td><%=request.getAttribute("birthdate")%></td>
    <tr></tr>
    </tr>

</table>
<%@include file="footer.jsp"%>
