<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AUTHENTICATION FAILURE</title>
<center><img src="img/logo.png" width="250" height="60" border="1"/></center>
</head>
<body>

<form action="Authentication" method="get">
<center><h1>AUTHENTICATION FAILURE</h1></center>
<% if (request.getAttribute("nullUNPWD")=="null") {
                %>
                
                   <center><td><Font><h4>You Have Not Provided Either Username/Password</h4></font></td></center>
                
                <% }%>

<% if (request.getAttribute("invalidAuth")=="invalid") {
                %>
                
                   <center><td><Font><h4>Invalid Username/Password</h4></font></td></center>
                
                <% }%>
<br/>

<center><input type="submit" name="back" value="BACK"/></center> 
<br><br>

</form>

</body>
</html>
