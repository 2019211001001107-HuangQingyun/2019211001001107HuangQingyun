<%--
  Created by IntelliJ IDEA.
  User: 原生优质青年
  Date: 2021/3/18
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
New User Registration!<br/>

<form method="post">
    <input type="text" placeholder="Username"  required="required"/><br/>
    <input type="text" placeholder="Passname" maxlength="8" required="required"/><br/>
    <input type="text" placeholder="Email" required pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"/><br/>
    <b>Gender</b><input name="sex" type="radio" />Male
    <input name="sex" type="radio"  />Female</br>
    <input name="Date" type="text" placeholder="Date of Birth(yyyy-mm-dd)" required pattern="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])| ((0[48]|[2468][048]|[3579][26])00))-02-29)$ "
           required="required"/><br/>
    <input class="submit" type=submit value="Register"  />

</form>
</body>
</html>
