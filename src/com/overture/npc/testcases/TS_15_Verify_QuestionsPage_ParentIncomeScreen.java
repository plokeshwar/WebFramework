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

import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.QuestionsPage;
import com.overture.npc.elementlocators.StudentInformationPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_15_Verify_QuestionsPage_ParentIncomeScreen {

	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	HomePage homePage = null;
	QuestionsPage questionPage=null;
	StudentInformationPage studentInfoPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Accordion_Availability() {
		String ScreenshotName1 = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName1);
		Reporter.log(cm.ReporterText("General Header Accordion Link  exists: ")+studentInfoPage.generalHeaderLink.isDisplayed());
		
		Assert.assertEquals(studentInfoPage.generalHeaderLink.isDisplayed(), true,"General Header Accordion Link is not Displayed");
		
		Reporter.log(cm.ReporterText("General Table Exists: ")+studentInfoPage.generalTable.isDisplayed());
		cm.captureElementScreenShot(driver, studentInfoPage.generalTable, ScreenshotName1, cm.basepath());
		Reporter.log(cm.ReporterText("General Table: ")+cm.ReporterLink(ScreenshotName1));
	}
	//==================================================================================================================

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
	//==================================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		questionPage=new QuestionsPage().globalElementsInit(driver);
		studentInfoPage=new StudentInformationPage().studentInfoInit(driver);
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.questionsLink, "clicking on Questions Link");
		co.click(questionPage.parentIncomeLink,  "Clicking on Parent Income Link");
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
