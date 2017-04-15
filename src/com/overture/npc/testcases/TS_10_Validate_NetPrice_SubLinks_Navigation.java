package com.overture.npc.testcases;

import org.openqa.selenium.By;
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
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_10_Validate_NetPrice_SubLinks_Navigation {

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_COA_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.COALink, "Clicking on COA Link in Home Page.");
		String actualText=co.getText(homePage.pageTitle,"Extracting the PageTitle");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actualText, "Cost of Attendance - Expenses", "The page did not navigate to COA Page.");
	}
	
	
	
	//===========================================================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_Packaging_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.packagingLink, "Clicking on Packaging Link in Home Page.");
		
		cm.captureElementScreenShot(driver, homePage.packagingtabs, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='packagingtabs']")) != null);
	}
	
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Populations_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.populationsLink, "Clicking on Populations Link in Home Page.");
		String actualText=co.getText(homePage.pageTitle,"Extracting the PageTitle");
		
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		
		Assert.assertEquals(actualText, "Populations", "The page did not navigate to Populations Page.");
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 4)
	public void TC_04_Validate_Questions_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.questionsLink, "Clicking on Questions Link in Home Page.");
		String actualText=co.getText(homePage.pageTitle,"Extracting the PageTitle");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actualText, "Questions", "The page did not navigate to Questions Page.");
	}
	
	//===========================================================================================================================
	
	
	
	/**
	 * This test case will validate if clicking on School Computed Values link, user navigates to Computed Values Page.
	 * <p>
	 * Step1 : Click on School Computed Values link visible under the Net Price Tab in home page.
	 * <p>
	 *  Expected Result : Computed Values Page should show up.
	 * */
	@Test(priority = 5)
	public void TC_05_Validate_SchoolComputedValues_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.schoolComputedValuesLink, "Clicking on School Computed Value Link in Home Page.");
		String actualText=co.getText(homePage.pageTitle,"Extracting the PageTitle");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actualText, "Computed Values", "The page did not navigate to Computed Values Page.");
	}
	
	
	
	//===========================================================================================================================
	
	
	@Test(priority = 6)
	public void TC_06_Validate_Tables_Link_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		co.click(homePage.tablesLink, "Clicking on Tables Link in Home Page.");
		String actualText=co.getText(homePage.pageTitle,"Extracting the PageTitle");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actualText,"Tables", "The page did not navigate to Tables Page.");
	}
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void BeforeClass() {
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
