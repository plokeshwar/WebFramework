package com.overture.npc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.overture.npc.elementlocators.Add_N_Edit_TestCasePage;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.SchoolPreviewPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_08_Verify_SchoolPreviewPage_AddTestCaseScreen {
	
	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	WebElement element=null;
	boolean flag=false;
	String testData=null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolPreviewPage schoolPreviewPage=null;
	Add_N_Edit_TestCasePage add_N_Edit_testCasePage=null;
	
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co = new CommonOperations();

	
	@Test(priority = 1)
	public void TC_01_Validate_TestCaseName_Editbox_InvalidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText(""));
		Reporter.log(cm.ReporterText("***********************************************"));
		
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.type(add_N_Edit_testCasePage.nameEditBox, "", "Entering Blank Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		
		cm.captureElementScreenShot(driver, add_N_Edit_testCasePage.errorMessage, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(add_N_Edit_testCasePage.errorMessage.getText(), "Error:Field name is required","The Name Field Allows Blank Data.");
		
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
	}

	// ==================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_TestCaseName_Editbox_ValidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		testData="TestName"+cm.randomNumberGenerator();
		Reporter.log(cm.ReporterText(""));
		Reporter.log(cm.ReporterText("***********************************************"));
		
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.type(add_N_Edit_testCasePage.nameEditBox, testData, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		cm.captureElementScreenShot(driver,element, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(element.isDisplayed(),true,"The Test Case is not created.");
		flag=true;
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
		
	}

	// ==================================================================================
	

	@Test(priority = 3)
	public void TC_04_Validate_CancelButton_Action_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		testData="TestName"+cm.randomNumberGenerator();
		
		Reporter.log(cm.ReporterText(""));
		Reporter.log(cm.ReporterText("***********************************************"));
		
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));
		
		co.type(add_N_Edit_testCasePage.nameEditBox, testData, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		cm.captureElementScreenShot(driver, element, ScreenshotName+"_Before",cm.basepath());
		Reporter.log(cm.ReporterTextBold("Before : ")+cm.ReporterLink(ScreenshotName+"_Before"));
		
		element.click();
		
		add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		
		co.type(add_N_Edit_testCasePage.nameEditBox, "SeleniumTesting", "Entering New Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.cancelButton, "Clicking the Cancel Button in Edit Test Case Page.");
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		cm.captureElementScreenShot(driver, element, ScreenshotName+"_After",cm.basepath());
		Reporter.log(cm.ReporterTextBold("After : ")+cm.ReporterLink(ScreenshotName+"_After"));
		System.out.println("Asserting the test case");

		Assert.assertEquals(element.isDisplayed(), true,"The Cancel Function Failed.");
		flag=true;
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
	}

	// ==================================================================================
	

	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		schoolPreviewPage=new SchoolPreviewPage().schoolPreviewPageElementsInit(driver);
		add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		co.click(homePage.previewLink, "Clicking on the Preview link.");
		
		co.click(schoolPreviewPage.addTestCaseButton, "Clicking add test case Button in the School Preview page.");
	}

	@AfterMethod
	public void AfterMethod() {
		if(flag){
			flag=co.deleteTestCase(driver, testData);
			}
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
	public void Browser_Opening() {
		System.out.println("Executing Class : "+className);
		co.logHeader(className);
		driver = co.browserOpen();
	}

	@AfterTest
	public void Browser_Closing() {
		co.browserClose(driver);
		co.logFooter();
	}
}
