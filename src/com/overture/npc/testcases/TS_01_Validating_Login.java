package com.overture.npc.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_01_Validating_Login {
	
	//Initializing variables.
	String actual, expected, msg;
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	// Initializing Page objects.
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;

	// Creating Class objects.
	HomeServlet homeServlet = new HomeServlet();
	CommonMethods cm = new CommonMethods();
	CommonOperations co =new CommonOperations();
	
//===================================================================================
	@BeforeTest
	public void Browser_Opening(){
		System.out.println("Executing Class : "+className);
		co.logHeader(className);
		driver = co.browserOpen();
	}
//===================================================================================
	
	@BeforeMethod
	public void BeforeMethod_Initializing_All_Required_Page_Elements() {
		loginPage = new LoginPage().loginPageInit(driver);
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
	}
//===================================================================================
	@Test(priority = 1)
	public void TC_01_Validate_Login_Valid_Credentials() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.login(driver);
		
		actual = driver.getTitle();
		expected = "Account Settings | NPC School Admin";
		msg = "User Not Allowed to Login with Valid Credentials";

		cm.captureDriverScreenShot(driver, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, msg);
		
		co.click(homePage.SignOutLink, "Clicking on the sign out link");
		co.click(globalPage.LoginPageReDirector, "Clicking on login page redirector");
	}
//===================================================================================
	@Test(priority = 2)
	public void TC_02_Validate_Login_Invalid_Credentials() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.type(loginPage.UserName, "pravinAdmin_1", "Entering Invalid Username");
		co.type(loginPage.Password, "Password1!", "Entering Valid Password");
		co.click(loginPage.LoginButton, "Clicking on the Login Button");

		co.pause(2500);
		actual = co.getText(loginPage.errorMessage, "Extracting Error Text");
		expected = "Error: Invalid Login";
		msg = "User Allowed to Login with Invalid Credentials";

		cm.captureElementScreenShot(driver,loginPage.errorMessage, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, msg);
	}

//===================================================================================
	@AfterMethod
	public void AfterMethod() {
	}

//===================================================================================
	@AfterTest
	public void Browser_Closing() {
		co.browserClose(driver);
		co.logFooter();
	}
}