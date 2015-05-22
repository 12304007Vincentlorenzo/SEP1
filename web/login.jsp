<%--
  Created by IntelliJ IDEA.
  User: Zo
  Date: 5/21/2015
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <!-- Custom Theme files -->
    <link href="css/stylelogin.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <!--Google Fonts-->
    <link href='css/loginfont1.css' rel='stylesheet' type='text/css'>
    <link href='css/loginfont2.css' rel='stylesheet' type='text/css'>
    <!--Google Fonts-->
</head>
<script>
    function dologin() {
        var username = document.getElementById("userid").value;
        var password = document.getElementById("password").value;

        myform.action = "<%=basePath%>servlet/LoginServlet";
        myform.submit();
    }
</script>
<%if (session.getAttribute("userid") == null) { %>
<body>
<form id="myform">
<div class="login">
    <h2>Acced Form</h2>

    <div class="login-top">
        <h1>LOGIN FORM</h1>

        <form>
            <input type="text" id="userid" value="User Id" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'User Id';}">
            <input type="password" id="password" value="password" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'password';}">
        </form>
        <div class="forgot">
            <input type="submit" value="Login" onclick="dologin()">
        </div>
    </div>
</div>
<div class="copyright">
    <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="">OUR TEAM</a></p>
</div>
</form>
</body>
<%} else {%>
<jsp:forward page="home.jsp"></jsp:forward>
<%} %>
</html>
