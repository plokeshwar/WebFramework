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
import com.overture.npc.elementlocators.NextStepsPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_41_Verify_ContentManagementTab_MyNextStepsPage {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	NextStepsPage nextStepPage=null;
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_03_Validate_NextPage_Table() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.nextStepsLink, "Click Next Steps Link");
				
		String expected = "Complete Your FAFSA";
		String actual= nextStepPage.singleAnchorLink.getText();
		cm.captureElementScreenShot(driver, nextStepPage.nextStepTable, ScreenshotName, cm.basepath());
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual,expected , "Assertion Unsuccessful");
		Reporter.log(cm.ReporterText("Assertion Successful. 'Complete Your FAFSA' link available"));
		Reporter.log(cm.ReporterLink(ScreenshotName));
	}
	//===========================================================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_FAFSA_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String ScreenshotName1 = "Validate_Uneditable_Text";

		cm.ReporterText("TestCase : " + ScreenshotName);
		cm.ReporterText("TestCase : " + ScreenshotName1);
		
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.nextStepsLink, "Click Next Steps Link");
		co.click(nextStepPage.singleAnchorLink, "Click on 'Complete Your FAFSA' link");		
		
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		cm.captureElementScreenShot(driver, nextStepPage.alertText, ScreenshotName1, cm.basepath());
		
		Reporter.log(cm.ReporterText("Page navigates to 'Edit Next Step' Page but is uneditable"));
		Reporter.log(cm.ReporterText("Page Title : ")+cm.ReporterLink(ScreenshotName));
		Reporter.log(cm.ReporterText("Alert Text : ")+cm.ReporterLink(ScreenshotName1));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Edit Next Step", "The page did not navigate to Edit Next Step.");
		
		Reporter.log(cm.ReporterText("Page navigates to 'Edit Next Step' Page but is uneditable"));
	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_01_Validate_CreateNewNextStep_Button_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.nextStepsLink, "Click Next Steps Link");
		co.click(nextStepPage.createNewNextStepBtn, "Click on 'Create New Next Step' Button");		
		
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Edit Next Step", "The page did not navigate to Edit Next Step.");
		Reporter.log(cm.ReporterText("Page navigates to 'Edit Next Step' Page and the fields are editable"));
	}
	//===========================================================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		nextStepPage=new NextStepsPage().nextStepInit(driver);
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
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
