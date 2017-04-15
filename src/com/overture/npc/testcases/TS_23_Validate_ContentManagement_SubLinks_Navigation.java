package com.overture.npc.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.overture.npc.elementlocators.ChangePasswordPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_23_Validate_ContentManagement_SubLinks_Navigation {

	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	
	@Test(priority = 1)
	public void TC_01_Validate_ContentEditor_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.contentEditorLink, "Clicking on Content Editor Link in Content Managment Page.");
		
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Content Editor", "The page did not navigate to Content Editor Page.");
	}
	
	//===========================================================================================================================
	
	
	@Test(priority =2)
	public void TC_02_Validate_NextSteps_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.nextStepsLink,"Clicking Next Step Link in Content Management Page.");
		
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "My Next Steps", "The page did not navigate to Next Steps Page.");
	}
	
	//===========================================================================================================================
	@Test(priority = 3)
	public void TC_03_Validate_PageConfigurations_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.pageConfigurationsLink, "Clicking on Page Configuration Link in Content Management page.");
		
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Page Configurations", "The page did not navigate to Page Configurations Page.");
	}

	//===========================================================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
	
		if(cm.waiters(homePage.contentManagmentTabSample)){
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		}
		}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void LogingIn() {
		co.login(driver);
	}

	@AfterClass
	public void AfterClass() {
		co.signOut(driver);
	}
	
	@BeforeTest
	public void Browser_Opening(){
		co.logHeader(className);
		driver = co.browserOpen();
	}
	
	@AfterTest
	public void Browser_Closing() {
		co.browserClose(driver);
		co.logFooter();
	}

}
