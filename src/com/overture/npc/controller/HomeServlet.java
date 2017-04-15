package com.overture.npc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.Reporter;

import com.overture.npc.executer.TestCaseDriver;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.Emailer;
import com.overture.npc.methods.FileZipper;
import com.overture.npc.methods.POJO;

public class HomeServlet extends HttpServlet {
	POJO pj = new POJO();
	public static String email,basepath, browser, envIndicator, environmentUrl, intanceCounter, bwsr, schemaNameAdmin, schemaNameStudent;
	public static int instanceCounter=0;
	public String runCaseIndicator[]=null;
	public static String bwr[]=null;
	public String multipleInstances[]=null;
	public String instanceCount[]=null;

	private static final long serialVersionUID = 1L;
	public static CommonMethods cm=new CommonMethods();
	private boolean flag;
	private String date=null;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean runAllCaseIndicator = false, emailIndicator = false;

		basepath = getServletContext().getRealPath(File.separator);

		runCaseIndicator= request.getParameterValues("runCases");
			if (runCaseIndicator[0].equalsIgnoreCase("Yes")) {
				runAllCaseIndicator = true;
			}
		

		String en[] = request.getParameterValues("environment");
		for (String s1 : en) {
			if (s1.toString().equalsIgnoreCase("DEV")) {
				environmentUrl = "http://10.0.0.103/schooladmin/app/login/mn";
				envIndicator="dev";
				schemaNameAdmin = "SLMP_ADMIN_DEV";
				schemaNameStudent = "SLMP_STUDENT_DEV";
			} else if (s1.toString().equalsIgnoreCase("UAT")){
				environmentUrl = "https://npcuat2.overturecorp.com/schooladmin/app/login/stgabriel";
				envIndicator="uat";
			}
			 else if (s1.toString().equalsIgnoreCase("PROD")){
			environmentUrl = "https://npc.collegeboard.org/schooladmin/app/login/pravin";
			envIndicator="prod";
			 }
			
		}

		bwr = request.getParameterValues("browser");
		bwsr=bwr[0];
		
		multipleInstances = request.getParameterValues("multipleInstances");
		
		if(multipleInstances[0].equalsIgnoreCase("Yes")){
		instanceCount = request.getParameterValues("instanceCount");
		instanceCounter=Integer.parseInt(instanceCount[0]);
		}
		email = request.getParameter("emailID");
		System.out.println("EMAIL : "+email);
		if (email != null && email !="") {
			emailIndicator = true;
		
			System.out.println("Result emails will be sent to the following recipients  : ");
			String[] a = email.split(";");
			for (int ii = 0; ii < a.length; ii++) {
				System.out.println("=====> " + ii + " : " + a[ii]);
			}
		} else {
			email="NA";
			System.out.println("No Email Address Entered, Hence No Result emails will be sent.");
		}
		
		getServletContext().setAttribute("environmentIndicator",envIndicator);
		getServletContext().setAttribute("emailIndicator",email);
		
		cm.deleteFile(new File(basepath+"/test-output"),false);
	
//========================================================================================
	for (int i=0;i<bwr.length;i++) {
		
		cm.deleteFile(new File(cm.basepath()+"/Reports/ScreenShots"),true);
		cm.deleteFile(new File(cm.basepath()+"/test-output"),true);
		browser=bwr[i];
		
		date=cm.dateGetter();
		getServletContext().setAttribute("date",date);
		
		if (runAllCaseIndicator == true)
		{
			List<String> values = new ArrayList<String>();
			ArrayList<String> ls = cm.getClassName("com.overture.npc.testcases");
			for (int ii = 0; ii < ls.size(); ii++)
			{
				System.out.println("=====>" + ii + "  : " + ls.get(ii));
				if(ls.get(ii).contains("TS_"))
					{
						values.add(ls.get(ii));
					}
			}
			pj.setTestCaseName(values);
			new TestCaseDriver(pj.getTestCaseName()).testExecuter(pj);
			
			cm.fileTransfer(cm.basepath(),basepath,browser.toUpperCase());
			
			cm.fileEditingGraphFolder(basepath, browser.toUpperCase());
			cm.fileEditingHTMLFolder(basepath, browser.toUpperCase());
			
			FileZipper.zipFolder(basepath,date,browser.toUpperCase());
			
			String attachFileName = "emailable-report.html";
			Emailer.sendMail(basepath, emailIndicator, email, attachFileName,browser.toUpperCase(),environmentUrl, envIndicator);
			
			cm.terminateProcess(browser.toUpperCase());
			
			Reporter.log("");
			Reporter.log("======================= END =================================");
			
			flag=true;

		} 
//========================================================================================		
		else {
			String[] e = request.getParameterValues("cgroup");
			if (e != null)
			{
				int p = 1;
				pj.setTestCaseName(Arrays.asList(e));
				System.out.println("THESE CASES WILL BE EXECUTED  :  ");
				for (String str : e)
				{
					System.out.println("=====>" + p + " : " + str);
					p++;
				}
				System.out.println("--------------------------------------------------------------");
				
				new TestCaseDriver(pj.getTestCaseName()).testExecuter(pj);
				cm.fileTransfer(cm.basepath(),basepath,browser.toUpperCase());
				
				cm.fileEditingGraphFolder(basepath, browser.toUpperCase());
				cm.fileEditingHTMLFolder(basepath, browser.toUpperCase());
				
				FileZipper.zipFolder(basepath,date,browser.toUpperCase());
				
				String attachFileName = "emailable-report.html";
				Emailer.sendMail(basepath, emailIndicator, email, attachFileName,browser.toUpperCase(),environmentUrl, envIndicator);
				
				cm.terminateProcess(browser.toUpperCase());
				
				Reporter.log("");
				Reporter.log("======================= END =================================");
				flag=true;
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
			}
		}
		
		}
	
		if(flag)
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("/output1.jsp");
			
			rd.forward(request, response);
			flag=false;
		}
	}
	
	public String getConnectionString(){
		
		
		return "";
	}

	public String [] browserNames() {
		return bwr;
	}
	
	public String browser() {
		return bwsr;
	}
	
	public String browserName() {
		System.out.println("BROWSER : "+bwsr);
		return bwsr;
	}
	
	public String bwrPath() {
		return basepath;
	}

	public String environmentUrl() {
		return environmentUrl;
	}
	
	public String environmentName() {
		return envIndicator;
	}
	
	public String getSchemaName() {
		return schemaNameAdmin;
	}
	
	
	public int getInstanceCount() {
		return instanceCounter;
	}
	
	public String [] browCount(){
		return bwr;
	}
	
		protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
