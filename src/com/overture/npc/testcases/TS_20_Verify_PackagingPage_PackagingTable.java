package com.overture.npc.testcases;
import java.util.ArrayList;

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

import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.PackagingPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_20_Verify_PackagingPage_PackagingTable {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	PackagingPage packagingPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Packages_List() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		
		String expectedList = "Parent Contribution, Student Contribution, Pell Grant, Institutional Scholarship - A, Institutional Grant - A, State Grant - A, Student Work, Student Loan - A, Parent Loan, Consolidated Self Help, Institutional Scholarship - B, Institutional Grant - B, State Grant - B, Student Loan - B, Institutional Scholarship - C, Institutional Grant - C, State Grant - C, Student Loan - C, School Defined Fund1, School Defined Fund2";

		ArrayList<String> expect = cm.createArrayList(expectedList);
		Reporter.log(cm.ReporterText("--------------------------------------------------------"));
		ArrayList<String> actual = cm.linkFinderByClass(driver, packagingPage.packagingTable);

		cm.captureDriverScreenShot(driver, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual.containsAll(expect), true,"The actual and expected list do not match.");	
			
	}
	//===========================================================================================================================

	
	@Test(priority = 2)
	public void TC_02_Validate_ParentContribution_StudentContribution_PellGrant_DefaultActive() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		Reporter.log(cm.ReporterText("Validating If Parent Contribution Active Status is Active By Default."));
		cm.captureElementScreenShot(driver, packagingPage.parentContributionActiveStatus, ScreenshotName+"_Parent", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_Parent"));
		Assert.assertEquals(packagingPage.parentContributionActiveStatus.isEnabled(), true,"Parent Contribution Activity Status is Not Enabled.");
		
		Reporter.log(cm.ReporterText("Validating If Student Contribution Active Status is Active By Default."));
		cm.captureElementScreenShot(driver, packagingPage.studentContributionActiveStatus, ScreenshotName+"_Student", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_Student"));
		Assert.assertEquals(packagingPage.parentContributionActiveStatus.isEnabled(), true,"Parent Contribution Activity Status is Not Enabled.");
		
		Reporter.log(cm.ReporterText("Validating If Pell Grant Active Status is Active By Default."));
		cm.captureElementScreenShot(driver, packagingPage.pellGrantActiveStatus, ScreenshotName+"_PellGrant", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_PellGrant"));
		Assert.assertEquals(packagingPage.pellGrantActiveStatus.isEnabled(), true,"Pell Grant Activity Status is Not Enabled.");
	}
	//===========================================================================================================================

	@Test(priority = 3)
	public void TC_03_Validate_NonDefault_Packages_Checkbox_Enabled() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		Assert.assertEquals(co.findCheckboxEnabled(driver, packagingPage.nonDefaultPackageList), true,"One of the check boxes are disabled.");
	}
	//===========================================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_SaveChanges_Button_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		String expected="Are you sure you want to save?";
		
		co.click(packagingPage.packagingTabSaveChangesButton, "Clicking Save Changes Button in Packaging Page.");

		String actual=co.alertHandler(driver).getText();
		
		co.alertHandler(driver).dismiss();
		
		Reporter.log(cm.ReporterText("Screen Shot Not Taken, as Validating Pop-up."));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}
	
	//============================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		packagingPage=new PackagingPage().packagingPageElementsInit(driver);
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		
		co.click(homePage.packagingLink, "Clicking on Packaging Link in Net Price Tab");
		co.click(packagingPage.packagingTabLink, "Clicking on the Packaging Tab.");
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