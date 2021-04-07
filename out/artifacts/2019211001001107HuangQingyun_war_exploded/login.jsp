<%--
  Created by IntelliJ IDEA.
  User: 原生优质青年
  Date: 2021/4/7
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<b>Login</b><br/>
<form method="post" action="${pageContext.request.contextPath}/login">
<b>Username<b/>:&nbsp;<input type="text"  name="Username" required="required"/><br/>
<b>Password<b/>:&nbsp;<input type="text"  name="Password" maxlength="8" required="required"/><br/>
<input class="submit" type=submit  value="Login"  />
<form/>
<%@include file="footer.jsp"%>>
