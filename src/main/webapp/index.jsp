<%--
  Created by IntelliJ IDEA.
  User: 原生优质青年
  Date: 2021/3/9
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>Jsp — helloworld！</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%@include file="header.jsp"%>
<%--  <h1>welcome to my Home page</h1>--%>
<%--  --%>
<%--  <a href="${pageContext.request.contextPath}/hello">HttpServlet--week2</a><br/>--%>
<%--  <a href="${pageContext.request.contextPath}/my">LifeCycleServlet--week3</a><br/>--%>
<%--  <a href="register.jsp">Regist.Jsp--week3</a><br/>--%>
<%--  <a href="${pageContext.request.contextPath}/config">ConfigDemoServlet--week4</a><br/>--%>

<h1>welcome to my Online Shop Home page</h1>
<form method="get" target='_blank' action="${pageContext.request.contextPath}/search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search" >
</form>
<%@include file="footer.jsp"%>
<%--  </body>--%>
<%--</html>--%>
