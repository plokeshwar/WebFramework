

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

	
	<div class="main_Container">


		<div class="paginate" >
		<% HomeServlet homeServlet=new HomeServlet();
		String browserName []=homeServlet.browserNames();
		for(int j=0;j<browserName.length;j++)
		    { 	
		    %>
		 	<table class="testCases"><thead><tr><th colspan="5">Summary of Execution : <%= getServletContext().getAttribute("date") %></th></tr><tr></tr></thead>
		    <tbody>
		    <tr style="display: table-row;" class="colorText">
		    	<td>User</td>
		    	<td>Browser</td>
		    	<td>Environment</td>
		    	<td>Email ID</td>
		    </tr>
		 
		    <tr style="display: table-row; text-align: center">
		    	<td><%= getServletContext().getAttribute("un") %></td>
		    	<td><%= browserName[j].toUpperCase()%></td>
		    	<td><%= getServletContext().getAttribute("environmentIndicator") %></td>
		    	<td>
		    	<%  String str= getServletContext().getAttribute("emailIndicator").toString();
		    		String s[] =str.split(";");	
				    for ( int i = 0; i < s.length; i++ ) {
				    out.println(s[i]);
				    out.println("<br>");
				    }
				%>
				</td> 
		    </tr>
		    </tbody>
		    </table>
		     <div class="resultPage">
		    <h4 align="left" ><font color="black">Detailed Results <em style="color: green"><%=browserName[j].toUpperCase()%></em> browser. <a href="test-output/<%=browserName[j].toUpperCase()%>/html/index.html" target="biraj"><font color="red">Click Here</font></a></font></h4>
			<h4 align="left" ><font color="black">Graphic Results  <em style="color: green"><%=browserName[j].toUpperCase()%></em> browser. <a href="test-output/<%=browserName[j].toUpperCase()%>/GraphReporting/testng-xslt/index.html" target="biraj"><font color="red">Click Here</font></a></font></h4>
			<h4 align="left" ><font color="black">Download ZIP file <a href="Results_<%=browserName[j].toUpperCase()+"_"+getServletContext().getAttribute("date").toString()%>.zip"><font color="red">Click Here</font></a></font></h4>
		</div>
		<% }%>
		 </div>
	</div>
	</div>
	</body>
	</html>