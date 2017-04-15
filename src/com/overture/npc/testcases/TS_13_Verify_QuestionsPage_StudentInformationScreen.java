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
import com.overture.npc.elementlocators.StudentInformationPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_13_Verify_QuestionsPage_StudentInformationScreen {

	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	

	@Test(priority = 1)
	public void TC_01_Validate_Accordion_Availability() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		Reporter.log(cm.ReporterText("General Header Accordion Link  exists: ")+studentInfoPage.generalHeaderLink.isDisplayed());
		Reporter.log(cm.ReporterText("Academics Header Accordion Link  exists: ")+studentInfoPage.academicsHeaderLink.isDisplayed());
		Reporter.log(cm.ReporterText("Activities Header Accordion Link  exists: ")+studentInfoPage.activitiesHeaderLink.isDisplayed());
		Reporter.log(cm.ReporterText("Faith Header Accordion Link  exists: ")+studentInfoPage.faithHeaderLink.isDisplayed());
		Reporter.log(cm.ReporterText("Family Header Accordion Link  exists: ")+studentInfoPage.familyHeaderLink.isDisplayed());
		Reporter.log(cm.ReporterText("Campuses and Schools Header Accordion Link  exists: ")+studentInfoPage.campusesHeaderLink.isDisplayed());
		Reporter.log(cm.ReporterText("Upper Class and Transfer Students Header Accordion Link  exists: ")+studentInfoPage.upperClassHeaderLink.isDisplayed());
		
		Assert.assertEquals(studentInfoPage.generalHeaderLink.isDisplayed(), true,"General Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.academicsHeaderLink.isDisplayed(), true,"Academics Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.activitiesHeaderLink.isDisplayed(), true,"Activities Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.faithHeaderLink.isDisplayed(), true,"Faith Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.familyHeaderLink.isDisplayed(), true,"Family Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.campusesHeaderLink.isDisplayed(), true,"Campuses and Schools Header Accordion Link is not Displayed");
		Assert.assertEquals(studentInfoPage.upperClassHeaderLink.isDisplayed(), true,"Upper Class and Transfer Students Header Accordion Link is not Displayed");
		
		
	}
	//=======================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Buttons_Availability() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		cm.ReporterText("TestCase : " + ScreenshotName);
		Reporter.log(cm.ReporterText("Cancel Button exists: ")+studentInfoPage.cancelButton.isDisplayed());
		Reporter.log(cm.ReporterText("Save Changes Button exists: ")+studentInfoPage.saveButton.isDisplayed());
		cm.mouseOver(driver, studentInfoPage.saveButton, " Highlighting Save Changes Button");
		Assert.assertEquals(studentInfoPage.cancelButton.isDisplayed(), true,"Cancel Button is not Displayed");
		Assert.assertEquals(studentInfoPage.saveButton.isDisplayed(), true,"Save Changes Button is not Displayed");
		cm.captureElementScreenShot(driver, studentInfoPage.formParagraph, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
	}
	
	//=======================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Accordion_Functionality() throws InterruptedException {
		String ScreenshotName1 = "Validate_Accordion_Functionality1";
		String ScreenshotName2 = "Validate_Accordion_Functionality2";
		String ScreenshotName3 = "Validate_Accordion_Functionality3";
		String ScreenshotName4 = "Validate_Accordion_Functionality4";
		String ScreenshotName5 = "Validate_Accordion_Functionality5";
		String ScreenshotName6 = "Validate_Accordion_Functionality6";
		String ScreenshotName7 = "Validate_Accordion_Functionality7";
		String ScreenshotName8 = "Validate_Accordion_Functionality8";
		
		cm.ReporterText("TestCase : " + ScreenshotName1);
		cm.ReporterText("TestCase : " + ScreenshotName2);
		cm.ReporterText("TestCase : " + ScreenshotName3);
		cm.ReporterText("TestCase : " + ScreenshotName4);
		cm.ReporterText("TestCase : " + ScreenshotName5);
		cm.ReporterText("TestCase : " + ScreenshotName6);
		cm.ReporterText("TestCase : " + ScreenshotName7);
		cm.ReporterText("TestCase : " + ScreenshotName8);
		
		Reporter.log(cm.ReporterText("General Table Exists: ")+studentInfoPage.generalTable.isDisplayed());
		cm.captureElementScreenShot(driver, studentInfoPage.generalTable, ScreenshotName1, cm.basepath());
		Reporter.log(cm.ReporterText("General Table: ")+cm.ReporterLink(ScreenshotName1));
		
		co.click(studentInfoPage.academicsHeaderLink, "clicking on Academics Header");
		Reporter.log(cm.ReporterText("Academic Table Exists: ")+studentInfoPage.academicsTable.isDisplayed());
		Thread.sleep(500);
		cm.captureElementScreenShot(driver, studentInfoPage.academicsTable, ScreenshotName2, cm.basepath());
		Reporter.log(cm.ReporterText("Academics Table: ")+cm.ReporterLink(ScreenshotName2));
		
		co.click(studentInfoPage.activitiesHeaderLink, "clicking on Activities Header");
		Reporter.log(cm.ReporterText("Activities Table Exists: ")+studentInfoPage.activitiesTable.isDisplayed());
		Thread.sleep(500);
		cm.captureElementScreenShot(driver, studentInfoPage.activitiesTable, ScreenshotName3, cm.basepath());
		Reporter.log(cm.ReporterText("Activities Table: ")+cm.ReporterLink(ScreenshotName3));
		
		co.click(studentInfoPage.faithHeaderLink, "clicking on Faith Header");
		Reporter.log(cm.ReporterText("Faith Table Exists: ")+studentInfoPage.faithTable.isDisplayed());
		Thread.sleep(500);
		cm.captureElementScreenShot(driver, studentInfoPage.faithTable, ScreenshotName4, cm.basepath());
		Reporter.log(cm.ReporterText("Faith Table: ")+cm.ReporterLink(ScreenshotName4));
		
		co.click(studentInfoPage.familyHeaderLink, "clicking on Family Header");
		Reporter.log(cm.ReporterText("Family Table Exists: ")+studentInfoPage.familyTable.isDisplayed());
		Thread.sleep(500);
		cm.captureElementScreenShot(driver, studentInfoPage.familyTable, ScreenshotName5, cm.basepath());
		Reporter.log(cm.ReporterText("Family Table: ")+cm.ReporterLink(ScreenshotName5));
		
		co.click(studentInfoPage.campusesHeaderLink, "clicking on Campuses and Schools Header");
		Reporter.log(cm.ReporterText("Campuses & Schools Table Exists: ")+studentInfoPage.campusesTable.isDisplayed());
		Thread.sleep(500);
		cm.captureElementScreenShot(driver, studentInfoPage.campusesTable, ScreenshotName6, cm.basepath());
		Reporter.log(cm.ReporterText("Campuses and Schools Table: ")+cm.ReporterLink(ScreenshotName6));
		
		co.click(studentInfoPage.upperClassHeaderLink, "clicking on Upper Class Header");
		Reporter.log(cm.ReporterText("Upper Class and Transfer Students Table Exists: ")+studentInfoPage.upperClassTable.isDisplayed());
		Thread.sleep(500);
		cm.captureElementScreenShot(driver, studentInfoPage.upperClassTable, ScreenshotName7, cm.basepath());
		Reporter.log(cm.ReporterText("Upper Class and Transfer Students Table: ")+cm.ReporterLink(ScreenshotName7));
		
		co.click(studentInfoPage.otherSchoolSpecificHeaderLink, "clicking on Other School Specific Header");
		Reporter.log(cm.ReporterText("Other School Specific Table Exists: ")+studentInfoPage.otherSchoolSpecificTable.isDisplayed());
		cm.captureElementScreenShot(driver, studentInfoPage.otherSchoolSpecificTable, ScreenshotName8, cm.basepath());
		Reporter.log(cm.ReporterText("Other School Specific Table: ")+cm.ReporterLink(ScreenshotName8));
		}
	//=========================================================================================================================
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		questionPage=new QuestionsPage().globalElementsInit(driver);
		studentInfoPage=new StudentInformationPage().studentInfoInit(driver);
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.questionsLink, "clicking on Questions Link");
		co.click(questionPage.studentInformationLink,  "Clicking on Student Information Link");
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
