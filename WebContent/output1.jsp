

<%@page import="com.overture.npc.controller.HomeServlet"%>
<%@page import="org.apache.velocity.runtime.directive.Foreach"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/stylesheet.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NPC RESULT PAGE</title>

<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
	$( document ).ready(function() {
		  $( "#main" ).toggle( "slide" );
	});
	function homeNav()
	{
		window.location = "home.jsp";
	}
	function loginNav()
	{
		window.location="login.html";
	}
</script>
</head>
<body>
<div id="main">
	
	<div class="main_Head" style="display: block;">
				<div class="logo_head">
					<div class="naviBtn">
						<input type="button" value="Home Page" id="button3" onclick="homeNav();"/>
						<input type="button" value="Log Out" id="button3" onclick="loginNav();"/>
					<div class="labelBestView">Results best viewed in Chrome Browser.</div>
					</div>
					
				</div>
				<div class="header">
					<div class="headCont">
					<span>Welcome <%= getServletContext().getAttribute("un") %></span>
						<font>NPC REGRESSION SUITE</font>
					</div>
				</div>
	</div>
</div>
<iframe src="out.jsp" name="iframe_a" width="29%" style="min-height: 655px"></iframe>
<iframe src="img/result.png" name="biraj" width="70%" style="min-height: 655px"></iframe>
 </body>
</html>