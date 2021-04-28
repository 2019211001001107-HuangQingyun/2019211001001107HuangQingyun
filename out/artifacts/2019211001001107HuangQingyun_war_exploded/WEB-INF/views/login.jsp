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
<%
    Cookie[] cookies = request.getCookies();
    String username="",password="",rememberMeVal="";
    if(cookies!=null){
        for(Cookie c:cookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login">
Username:&nbsp;<input type="text"  name="Username" required="required" value="<%=username%>"/><br/>
Password:&nbsp;<input type="password"  name="Password" maxlength="8" required="required" value="<%=password%>"/><br/>
    <input type="checkbox"name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>>RememberMe<br/>
<input class="submit" type=submit  value="Submit"  />
<form/>
<%@include file="footer.jsp"%>>
