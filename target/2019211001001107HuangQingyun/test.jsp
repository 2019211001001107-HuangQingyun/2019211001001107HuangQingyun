<%--
  Created by IntelliJ IDEA.
  User: 原生优质青年
  Date: 2021/5/27
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
    <UL>
        <c:forEach var="i" begin="1" end="10">
        <LI>${i}<LI>
        </c:forEach>
    </UL>

</head>
<body>

</body>
</html>
