<%@ page import="com.HuangQingyun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 原生优质青年
  Date: 2021/4/28
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>User Update <h1/>
    <%

        User u=(User) session.getAttribute("user");
        %>
    <form method="post" action="${pageContext.request.contextPath}/updateUser">
        <input type="hidden" name="id" value="<%=u.getId()%>">

        <input type="text" placeholder="Username"  name="Username" required="required" value="<%=u.getUsername()%>"/><br/>
        <input type="text" placeholder="Password" name="Password" maxlength="8" required="required" value="<%=u.getPassword()%>"/><br/>
        <input type="text" placeholder="Email" name="Email" required pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$" value="<%=u.getEmail()%>"/><br/>
        <b>Gender</b><input name="Gender" type="radio"  value="Male" <%=u.getGender().equals("Male")?"checked":""%>/>Male
        <input name="Gender" type="radio"  value="Female" <%=u.getGender().equals("Female")?"checked":""%>/>Female</br>
        <input name="BrithDate" type="text" placeholder="Date of Birth(yyyy-mm-dd)" required pattern="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])| ((0[48]|[2468][048]|[3579][26])00))-02-29)$ "
               required="required" value="<%=u.getBirthdate()%>"/><br/>
        <input class="submit" type=submit  value="Save Changes" />

    </form>
<%@include file="footer.jsp" %>
