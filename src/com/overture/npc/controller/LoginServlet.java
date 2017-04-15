package com.overture.npc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private enum userName {
	    MOSS, SETUPADMIN, NAGARJUNA, PRAVIN, GABY;
	}
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String un,pwd;
		boolean flag=false;
		
		un=request.getParameter("userName").toUpperCase();
		pwd=request.getParameter("password").toUpperCase();
		getServletContext().setAttribute("un",un);
		if(un=="" && pwd==""){
			request.setAttribute("nullUNPWD", "null");
			RequestDispatcher rd=request.getRequestDispatcher("/AuthenticationFailure.jsp");
			rd.forward(request, response);
		}
		else if(!un.equals("NPC") && !un.equals("SETUPADMIN") && !un.equals("NAGARJUNA") && !un.equals("PRAVIN")&& !un.equals("GABY")){
			request.setAttribute("nullUNPWD", "null");
			RequestDispatcher rd=request.getRequestDispatcher("/AuthenticationFailure.jsp");
			rd.forward(request, response);
			
		}
		else{
		userName usern = userName.valueOf(un.toUpperCase()); // surround with try/catch

		switch(usern) {
		    case PRAVIN:
		    	if(pwd.equalsIgnoreCase("PRAVIN"))
		    	{flag=true;}
		        break;
		    case NAGARJUNA:
		    	if(pwd.equalsIgnoreCase("NAGARJUNA"))
		    	{flag=true;}
		        break;
		    case MOSS:
		    	if(pwd.equalsIgnoreCase("NPC"))
		    	{flag=true;}
		        break;
		    case SETUPADMIN:
		    	if(pwd.equalsIgnoreCase("SETUPADMIN"))
		    	{flag=true;}
		        break;
		    case GABY:
		    	if(pwd.equalsIgnoreCase("GABY"))
		    	{flag=true;}
		        break;
		    
		}
		
		
		if(flag){
			request.setAttribute("un", un.toUpperCase());
            RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
            rd.forward(request, response);

			System.out.println("WELCOME : "+un.toUpperCase());
			
		}
		else{
			request.setAttribute("invalidAuth", "invalid");
			RequestDispatcher rd=request.getRequestDispatcher("/AuthenticationFailure.jsp");
			rd.forward(request, response);
			
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
