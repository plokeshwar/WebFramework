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

import com.overture.npc.elementlocators.TestCaseStudentPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_70_Verify_GO_Link{
	
	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	WebElement element=null;
	String originalDriver =null, subDriver=null, testData=null;
	boolean flag=false;
	String actual=null,expected=null;
	
	TestCaseStudentPage tcStudentPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co = new CommonOperations();

	@Test(priority = 1)
	public void TC_01_Validate_Go_Link_Navigation() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseName);
		
		Reporter.log(cm.ReporterText("Validating Go Link Navigation."));
		
		expected="Net Price Calculator - Pravin University";
		actual=driver.getTitle();
		cm.captureDriverScreenShot(driver, testCaseName, cm.basepath());
		Reporter.log(cm.ReporterLink(testCaseName));
		Assert.assertEquals(actual, expected,"The Page Did not Navigate to Net Price Calculator.");
	}

	// ==================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_EnterAsGuestLink_Navigation() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseName);
		co.click(tcStudentPage.EnterAsGuestLink, "Clicking on Enter as Guest link.");
		expected="Student Information";
		actual=co.getText(tcStudentPage.pageTitle,"Extracting the Page Title Text from Test Case Student Page.");
		cm.captureElementScreenShot(driver, tcStudentPage.pageTitle, testCaseName, cm.basepath());
		Reporter.log(cm.ReporterLink(testCaseName));
		Assert.assertEquals(actual, expected,"Enter as Guest Link Function Failed.");
	}

	// ==================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_NextLink_Navigation() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseName);

		co.type(tcStudentPage.studentFirstName, "SeleniumTesting", "Entering Student Name.");
		co.selectDropDown(tcStudentPage.studentCompletingCalculator, "Student", "Selecting Student as Completing the Calculator.");
		co.selectDropDown(tcStudentPage.studentBirthYear, "1995", "Selecting 1995 as Student Birth Year.");
		co.selectDropDown(tcStudentPage.studentGradeYearCode, "2nd yr college", "Selecting 2nd yr college as Student Grade Year.");
		co.selectDropDown(tcStudentPage.studentResidencyStateCode, "Alabama", "Selecting Alabama as Student Residency State Code.");
		co.selectDropDown(tcStudentPage.studentMaritalStatusCode, "Single", "Selecting Single as Student Marital Status.");
		co.selectDropDown(tcStudentPage.studentHousingCode, "On campus", "Selecting On Campus as Student Housing Code.");
		co.click(tcStudentPage.NextButton, "Clicking Next Button");
		
		expected="Parent Household";
		actual=co.getText(tcStudentPage.pageTitle,"Extracting the Page Title Text from Test Case Student Page.");
		cm.captureElementScreenShot(driver, tcStudentPage.pageTitle, testCaseName, cm.basepath());
		Reporter.log(cm.ReporterLink(testCaseName));
		Assert.assertEquals(actual, expected,"The Next Link Function Failed.");
	}

	// ==================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_BackLink_Navigation() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseName);
		
		cm.captureElementScreenShot(driver, tcStudentPage.pageTitle, testCaseName+"Next", cm.basepath());
		Reporter.log(cm.ReporterTextBold("After Next Button Click : ")+cm.ReporterLink(testCaseName+"Next"));
		
		tcStudentPage=new TestCaseStudentPage().studentTestCasePageInit(driver);
		
		co.click(tcStudentPage.BackButton, "Clicking Back Button");
		expected="Student Information";
		actual=co.getText(tcStudentPage.pageTitle,"Extracting the Page Title Text from Test Case Student Page.");
		cm.captureElementScreenShot(driver, tcStudentPage.pageTitle, testCaseName+"Back", cm.basepath());
		Reporter.log(cm.ReporterTextBold("After Back Button Click : ")+cm.ReporterLink(testCaseName+"Back"));
		Assert.assertEquals(actual, expected,"The Back Link Function Failed.");
	}

	// ==================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_LeaveCalculatorLink_Navigation() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(testCaseName);
		co.click(tcStudentPage.leaveCalculator,"Clicking Leave Calculator Link.");
		
		expected="College Board's Net Price Calculator | College Board - Net Price Calculator";
		actual=driver.getTitle();
		
		cm.captureDriverScreenShot(driver, testCaseName, cm.basepath());
		Reporter.log(cm.ReporterLink(testCaseName));
		Assert.assertEquals(actual, expected,"The Page Did not Navigate to College Board Page.");
	}

	// ==================================================================================

	@BeforeMethod
	public void BeforeMethod() {
	tcStudentPage=new TestCaseStudentPage().studentTestCasePageInit(driver);
	}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void LogingIn() {
		co.login(driver);
		
		tcStudentPage=new TestCaseStudentPage().studentTestCasePageInit(driver);
		
		originalDriver = co.controlOfMainDriver(driver);
		testData="TestName"+cm.randomNumberGenerator();
		flag=co.addTestCase(driver, testData);
		
		element=driver.findElement(By.xpath("//table[@id='preview-list']//tr[contains(.,'"+testData+"')]//a[contains(.,'GO')]"));
		co.click(element, "Clicking GO Link for Test Case : "+testData);
		
		String subDriver=co.controlOfSubDriver(driver);
		co.driverSwitch(driver, subDriver, "Giving the Driver Control to the SubDriver.");
		}

	@AfterClass
	public void AfterClass() {
		
		driver.close();
		co.driverSwitch(driver, originalDriver, "Switching the driver back to main Control.");
			if(flag){
					flag=co.deleteTestCase(driver, testData);
					}
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