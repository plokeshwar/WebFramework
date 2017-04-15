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
import com.overture.npc.elementlocators.QuestionsPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_12_Verify_Navigation_of_Links_Available_in_Questions_Page {

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	QuestionsPage questionPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Manage_Custom_Button_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		
		co.click(questionPage.manageCustomButton, "Clicking the Manage Custom Button in Question Page.");

		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Questions - Manage Custom Lists", "The page did not navigate to Questions - Manage Custom Lists.");
	}
	
	//============================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Parent_Assets_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(questionPage.parentAssetLink, "Clicking the Parent Assets Link in Question Page.");

		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Questions - Parent Assets Screen", "The page did not navigate to Questions - Parent Assets Screen.");
	}
	
	//============================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Parent_Household_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(questionPage.parentHouseholdLink, "Clicking the Parent Household Link in Question Page.");

		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Questions - Parent Household Screen", "The page did not navigate to Questions - Parent Household Screen.");
	}
	
	//============================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_Parent_Income_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(questionPage.parentIncomeLink, "Clicking the Parent Income Link in Question Page.");

		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Questions - Parent Income Screen", "The page did not navigate to Questions - Parent Income Screen.");
	}
	
	//============================================================================================
	
		
	@Test(priority = 5)
	public void TC_05_Validate_Student_Finances_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(questionPage.studentFinancesLink, "Clicking the Student Finances Link in Question Page.");

		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Questions - Student Finances Screen", "The page did not navigate to Questions - Student Finances Screen.");
	}
	
	//============================================================================================
	
	@Test(priority = 6)
	public void TC_06_Validate_Student_Information_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(questionPage.studentInformationLink, "Clicking the Student Information Link in Question Page.");

		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(homePage.pageTitle.getText(), "Questions - Student Information Screen", "The page did not navigate to Questions - Student Information Screen.");
	}
	
	//============================================================================================
	
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		questionPage=new QuestionsPage().globalElementsInit(driver);
		
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.questionsLink, "Clicking the Questions Link in Preview Page.");
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
