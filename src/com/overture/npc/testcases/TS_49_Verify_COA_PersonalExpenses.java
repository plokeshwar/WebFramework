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

import com.overture.npc.elementlocators.CostOfAttendancePage;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_49_Verify_COA_PersonalExpenses {
	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	boolean flag=false;
	
	HomePage homePage = null;
	CostOfAttendancePage coaPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	@Test(priority = 1)
	public void TC_01_Validate_TransportationLink_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		String expected = "Edit Expense - Personal Expenses";
		String actual= co.getText(coaPage.pageTitle,"Extracting the text from COA Page Title.");
		
		cm.captureElementScreenShot(driver,coaPage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The page did not navigate to Edit Expense Page.");
	}

	//======================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_PersonalExpensesLink_FixedLink() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(coaPage.fixedLink, "Clicking on Fixed Link in Edit Expense page.");
		
		boolean expected = coaPage.rowOne.isDisplayed();
		boolean actual= true;
		
		cm.captureElementScreenShot(driver,coaPage.rowOne, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The Row did not generate after clicking Fixed Link.");
	}

	//======================================================================================================
	
	
	@Test(priority = 3)
	public void TC_03_Validate_PersonalExpensesLink_CancelButton() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(coaPage.cancelButton, "Clicking on Cancel button in Edit Expense page.");
		
		String expected = "Cost of Attendance - Expenses";
		String actual= co.getText(coaPage.pageTitle,"Extracting the text from COA Page Title.");
		
		cm.captureElementScreenShot(driver,coaPage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The Cancel Button Function Failed.");
	}

	//======================================================================================================
	
	
	@Test(priority = 4)
	public void TC_04_Validate_PersonalExpensesLink_SaveChangesButton() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(coaPage.saveChangesButton, "Clicking on Save Changes button in Edit Expense page.");
		
		String expected = "Saving will overwrite any previously saved information.  Please select OK to continue.";
		String actual= co.alertHandler(driver).getText();
		
		co.alertHandler(driver).dismiss();
		
		Reporter.log(cm.ReporterTextBold("ScreenShot Not Taken as validating PopUP."));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The Save Changes Button Pop Up Function Failed.");
	}

	//======================================================================================================
	

	@Test(priority = 5)
	public void TC_05_Validate_PersonalExpensesLink_SaveChanges_popUP_OK_function() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		String testData=cm.randomNumberGenerator();

		co.click(coaPage.fixedLink, "Clicking on Fixed Link in Edit Expense page.");
		co.type(coaPage.fixedValueOne, testData, "Entering Value in Edit Expense page.");
		
		co.click(coaPage.saveChangesButton, "Clicking on Save Changes button in Edit Expense page.");
		co.alertHandler(driver).accept();
		
		coaPage= new CostOfAttendancePage().COAPageInit(driver);
		co.click(coaPage.personalExpensesLink, "Clicking on Personal Expenses Link COA page.");
		
		String expected = testData;
		String actual= coaPage.fixedValueOne.getAttribute("value");
		Reporter.log(cm.ReporterTextBold("Expected : "+expected));
		Reporter.log(cm.ReporterTextBold("Actual : "+actual));
		
		cm.captureElementScreenShot(driver,coaPage.fixedValueOne, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The Save Changes Button Pop Up Function Failed.");
		flag=true;
	}

	//======================================================================================================
	
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		coaPage= new CostOfAttendancePage().COAPageInit(driver);
		
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.COALink, "Clicking on COA link Under Net Price Tab.");
		co.click(coaPage.personalExpensesLink, "Clicking on Personal Expenses Link COA page.");
			if(co.elementSize(coaPage.coaFixedRows)>2){
				co.deleteCOAExpense(driver);
			}
	}

	@AfterMethod
	public void AfterMethod() {
	if(flag){
			coaPage= new CostOfAttendancePage().COAPageInit(driver);
			co.click(coaPage.deleteRowOne, "Clicking On Delete Image in Edit Expense Page.");
			co.click(coaPage.saveChangesButton, "Clicking on Save Changes button in Edit Expense page.");
			co.alertHandler(driver).accept();
			flag=false;
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
