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
import com.overture.npc.elementlocators.PreviewPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_09_Verify_SchoolPreviewPage_EditTestCaseScreen {
	
	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	WebElement element=null;
	boolean flag=false;

	LoginPage loginPage = null;
	HomePage homePage = null;
	PreviewPage previewPage=null;
	Add_N_Edit_TestCasePage add_N_Edit_testCasePage=null;
	
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co = new CommonOperations();

	
	@Test(priority = 1)
	public void TC_01_Validate_TestCaseName_Editbox_ValidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData1="TestName"+cm.randomNumberGenerator(), testData2="SeleniumTesting"+cm.randomNumberGenerator();
		Reporter.log(cm.ReporterText(""));
		Reporter.log(cm.ReporterText("***********************************************"));
		
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.type(add_N_Edit_testCasePage.nameEditBox, testData1, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData1+"')]"));
		cm.captureElementScreenShot(driver, element, ScreenshotName+"Before",cm.basepath());
		Reporter.log(cm.ReporterTextBold("Before : ")+cm.ReporterLink(ScreenshotName+"Before"));
		
		element.click();
		
		add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		
		co.type(add_N_Edit_testCasePage.nameEditBox, testData2, "Entering New Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData2+"')]"));
		
		cm.captureElementScreenShot(driver, element, ScreenshotName+"After",cm.basepath());
		Reporter.log(cm.ReporterTextBold("After : ")+cm.ReporterLink(ScreenshotName+"After"));
		
		Assert.assertEquals(element.isDisplayed(), true,"The Test Case Name Did not Change.");
		flag=true;
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
	}

	// ==================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_TestCaseName_Editbox_InValidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		Reporter.log(cm.ReporterText(""));
		Reporter.log(cm.ReporterText("***********************************************"));
		
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.type(add_N_Edit_testCasePage.nameEditBox, testData, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		element.click();
		
		add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		
		co.type(add_N_Edit_testCasePage.nameEditBox, "", "Entering Blank Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		
		cm.captureElementScreenShot(driver, add_N_Edit_testCasePage.errorMessage, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(add_N_Edit_testCasePage.errorMessage.getText(), "Error:Field name is required","The Name Field Allows Blank Data.");
		flag=true;
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
		
	}

	// ==================================================================================
	
	
	@Test(priority = 3)
	public void TC_04_Validate_CancelButton_Action_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		
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
	
	
	
	@Test(priority = 4)
	public void TC_05_Validate_DeleteButton_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		String expected="Selecting to delete will permanently remove the item from the system.\nPlease confirm that you wish to continue.";
		
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
		co.click(add_N_Edit_testCasePage.deleteButton,"Clicking on Delete Button in Edit Test Case page.");
		String actual=co.alertHandler(driver).getText();
		co.alertHandler(driver).dismiss();
		cm.captureDriverScreenShot(driver, ScreenshotName+"_After",cm.basepath());
		Reporter.log(cm.ReporterTextBold("After : ")+cm.ReporterLink(ScreenshotName+"_After"));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected,"The Delete Function Failed.");
		flag=true;
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
	}

	// ==================================================================================
	
	
	
	@Test(priority = 5)
	public void TC_06_Validate_Delete_OK_PopUPAction() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		boolean displayFlag=false;
		
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
		co.click(add_N_Edit_testCasePage.deleteButton,"Clicking on Delete Button in Edit Test Case page.");
		co.alertHandler(driver).accept();
		
		try {
			displayFlag= driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]")).isDisplayed();
		} catch (Exception e) {
			
		}
		
		cm.captureDriverScreenShot(driver, ScreenshotName+"_After",cm.basepath());
		Reporter.log(cm.ReporterTextBold("After : ")+cm.ReporterLink(ScreenshotName+"_After"));
		System.out.println("Asserting the test case");
		Assert.assertEquals(displayFlag, false,"The Delete Function Failed.");
		
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
	}

	// ==================================================================================
	
	
	
	@Test(priority = 4)
	public void TC_07_Validate_Delete_CancelButton_PopUPAction() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		
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
		co.click(add_N_Edit_testCasePage.deleteButton,"Clicking on Delete Button in Edit Test Case page.");
		co.alertHandler(driver).dismiss();
		cm.captureDriverScreenShot(driver, ScreenshotName+"_After",cm.basepath());
		Reporter.log(cm.ReporterTextBold("After : ")+cm.ReporterLink(ScreenshotName+"_After"));
		System.out.println("Asserting the test case");
		Assert.assertEquals(previewPage.headerText.isDisplayed(), true,"The Cancel Function Failed.");
		flag=true;
		Reporter.log(cm.ReporterText("***********************************************"));
		Reporter.log(cm.ReporterText(""));
	}

	// ==================================================================================
	

	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		previewPage=new PreviewPage().previewElementsInit(driver);
		add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		co.click(homePage.previewLink, "Clicking on the Preview link.");
		co.click(previewPage.addTestCaseButton, "Clicking add test case Button in the Preview page.");
	}

	@AfterMethod
	public void AfterMethod() {
		if(flag){
			co.deletePreviewTestCase(driver, element, flag);
		}
	}

	@BeforeClass
	public void Login() {
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
