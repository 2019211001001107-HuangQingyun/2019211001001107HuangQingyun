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
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login">
Username:&nbsp;<input type="text"  name="Username" required="required"/><br/>
Password:&nbsp;<input type="password"  name="Password" maxlength="8" required="required"/><br/>
<input class="submit" type=submit  value="Submit"  />
<form/>
<%@include file="footer.jsp"%>>
