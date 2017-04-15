<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.overture.npc.methods.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.lang.reflect.Method" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NPC Admin Regression Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>	
<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
<link rel="stylesheet" href="stylesheets/jquery.treetable.css" />
<link rel="stylesheet" href="stylesheets/jquery.treetable.theme.default.css" />	
<script type="text/javascript" src="js/popup.js"></script>
<link href="css/style.css" rel="stylesheet">
<link href="css/stylesheet.css" rel="stylesheet">
<script type="text/javascript">
	$( document ).ready(function() {
		  $( ".loginTable" ).delay( 600 ).slideDown( 1000 );
	/* $('#example-basic').fadeIn(); */
	$('.message').hide();
	     });
	
	function showDiv()
	{
		 $( "#example-basic" ).fadeIn( 400 );
		 $('.message').slideUp( 400 );
		 $('.message').hide();
	}
	function hideDiv()
	{
		 $( "#example-basic" ).fadeOut( 400 );
		 $('.message').slideDown( 400 );
	}
	
	function showInstances()
	{
		 $('.instances').slideDown( 400 );
	}
	
	function hideInstances()
	{
		 $('.instances').hide();
	}
	
	function blinkFont()
	{
	  document.getElementById("blink1").style.color="red";
	  setTimeout("setblinkFont()",1000);
	}
	
	$(document).ready(function() {
		$('#content').removeClass('fullwidth');	    
			$('#content').removeClass('fullwidth').delay(10).queue(function(next){
					$(this).addClass('fullwidth');
			        next();
			   
			    return false;
			});
	});
	$(document).ready(function() {
		$('.circle, .circle1').removeClass('stop');	    
	});
			
	$(document).ready(function() {
	$('.runBtn').click(function() {
		$( ".MainContainer" ).toggle( "slide" );
		});
	});
</script>
</head>
<body>
<div class="MainContainer">
	<form action="Home" method="get">
	<div class="main_Head" style="display: block;">
				<div class="logo_head"><h5 align="right" ><font color="red">To view the last run results...<a href="output.jsp"><font color="red">Click Here</font></a></font></h5></div>
				<div class="header">
					<div class="headCont">
					<span>	Welcome <%= getServletContext().getAttribute("un") %></span>
					
						<font>NPC ADMIN REGRESSION SUITE</font>
					</div>
				</div>
	</div>
	
	<div class="tableInfo">
		<div class="tableInfo_inner">
		<div class="head">
			<span>Please fill in some details before proceeding</span>
		</div>
		<div class="divider">
			<span>-------------------------------------------------------------------------------------------------------------------</span>
		</div>
		<div class="wrapper">
					<div class="wrap_child">
						<span>Environment :</span>
						<div class="iconTxtBox">
							<input type="radio" name="environment" checked="checked" value="dev" >DEV
							<input type="radio" value="UAT" name="environment" >UAT
							<input type="radio" value="PROD"  name="environment">PROD
						</div>
					</div>
					<div class="wrap_child">
						<span>Browser :</span>
						<div class="iconTxtBox" style="padding-top: 5px;">
							<input type="radio" name="browser" value="chrome" />
							<label>Chrome</label>
							<input type="radio" name="browser" checked="checked" value="firefox"/>
							<label >Firefox</label>
							<input type="radio" name="browser" disabled="disabled" value="ie" />
							<label >IE</label>
							<input type="radio" name="browser" value="phantomjs" />
							<label >Ghost Browser</label>
							<input type="radio" name="browser" value="safari" />
							<label >Mac Safari</label>
							
						</div>
					</div>
			
			<div class="wrap_child">
							<span>Want to Run Multiple Instances? </span>
						<div class="iconTxtBox">
							<input type="radio" name="multipleInstances"  value="Yes" onclick="showInstances();" checked="checked"> Yes
							<input type="radio" value="No" name="multipleInstances" onchange="hideInstances();" >No
						</div>
					</div>
					<div class="instances" > 
					<div class="wrap_child">
						<span>Select Number of Instances :</span>
						<select name="instanceCount" id="instanceCount" style="width:153px;">
					    <option value="1" selected="selected">1</option>
    					<option value="2" >2</option>
    					<option value="4" >4</option>
    					<option value="6" >6</option>
    					<option value="8" >8</option>
    					<option value="10">10</option>
						</select>
  						<!-- <input type="radio" name="instance" checked="checked" value="2" >2
							<input type="radio" value="4" name="instance" >4
							<input type="radio" value="6"  name="instance">6 -->
					</div>
					</div>
			
					<div class="wrap_child">
						<span>Want to Run all Test Cases? :</span>
						<div class="iconTxtBox">
							<input type="radio" name="runCases"  value="Yes" onclick="hideDiv();"> Yes
							<input type="radio" value="No" name="runCases" onchange="showDiv();" checked="checked">No
						</div>
					</div>
					<div class="wrap_child">
						<span>Want to Email Results? :</span>
						<div class="iconTxtBox">
							<input type="text" placeholder="Please enter email address.." name="emailID" tabindex="1" >
						</div>
					</div>
					<div id="wrap_button">
				           <input type="submit" name="runTestCases" value="RUN" class="runBtn" onclick="javascript:openPopup('Employment_Details', 'backgroundPopup');"/>
					</div>
		</div>
		</div>
	</div>
		
		
		<table id="example-basic">
        <caption></caption>
        <thead>
          <tr>
            <th></th>
            <th>Test Suites</th>
          </tr>
        </thead>
        <bean:define id="contextPath" value="<%= request.getContextPath() %>" />
				<%
					CommonMethods cm=new CommonMethods();
                	Class[] classes = cm.getClasses("com.overture.npc.testcases");
                %>
        <tbody>
        <% for (int i = 0, j=1; i < classes.length; i++,j++) { %>	
           <% if(classes[i].getSimpleName().contains("TS_")){ %>
          <tr data-tt-id="<%=j %>" class="colorParent">
            <td><input type ="checkbox" name="cgroup" value=<%=classes[i].getSimpleName()%>></td>
            <td><%=classes[i].getSimpleName()%></td>
          </tr>
          <% Class tClass = classes[i];
                       Method[] methods = tClass.getMethods();
                       for (int ii = 0, jj=1; ii < methods.length; ii++,jj++) { %>
                       
                       <% if(methods[ii].toString().contains("TC_")){ %>
                       <tr data-tt-id="<%=j %>.<%=jj%>" data-tt-parent-id="<%=j %>">
                       	<td>&nbsp;</td>
			            <td class="colorChild"><span class="indenter"></span><%=methods[ii].toString().substring(methods[ii].toString().indexOf("TC_"),methods[ii].toString().indexOf("(")) %></td>
			            
			          </tr>
                       <%} }%> <%} %>
          <%} %>
        </tbody>
      </table>
	<div class="message">
  <span>*Information*</span> <br/>
  <center><font>"You have selected to run all the Cases.</font><font>All the Test Suites will be executed.."</font></center>
 </div>
	</form>
	</div>
	<div id="backgroundPopup"></div>
	<div class="toPopup" id="Employment_Details" > 
			<div id="content">
					<span class="expand"></span>
				</div>
			<div id="popup_content"> <!--your content start-->
			
				  <div class="container">
						 <div class="circle"></div>
					    <div class="circle1"></div>
					</div>
				<div class="cont">
					<font>Please wait.. Test cases are getting executed.</font><font style="margin-left: 2%;">This may take a while</font>
					<div class="contentBar">
				    	<div id="block_1" class="barlittle"></div>
				        <div id="block_2" class="barlittle"></div>
				        <div id="block_3" class="barlittle"></div>
				        <div id="block_4" class="barlittle"></div>
				        <div id="block_5" class="barlittle"></div>
				    </div>
					
				 </div>  
	        </div> <!--your content end-->
	    
	 </div> <!--toPopup end-->

  	<script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/jquery-ui.js"></script>
    <script src="js/src/jquery.treetable.js"></script>
    <script>
      $("#example-basic").treetable({ expandable: true });
      $("#example-basic tr.colorParent:odd").css('background-color','#A9E2F3');
      $("#example-basic tr.colorParent:even").css('background-color','white');
      $("#example-basic td.colorChild").css('background-color','#CEECA2');
      $("#example-basic td.colorChild").css('font-style','italic');
      $("#example-basic td.colorChild").css('font-size','13px');
    </script>
</body>
</html>
