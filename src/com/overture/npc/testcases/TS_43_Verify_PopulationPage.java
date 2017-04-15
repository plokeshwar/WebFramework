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
import com.overture.npc.elementlocators.PopulationPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_43_Verify_PopulationPage {
	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	HomePage homePage = null;
	PopulationPage populationPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	@Test(priority = 1)
	public void TC_01_Validate_AddPopulationButton_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(populationPage.addPopulationButton, "Clicking on Add Population Button in Population page.");
		
		String expected = "Add Population";
		String actual= co.getText(populationPage.pageTitle,"Extracting the text from Add Population Page Title.");
		
		cm.captureElementScreenShot(driver, populationPage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The page did not navigate to Add Population Page.");
	}

	//======================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_CancelButton_Action_InAddPopulationPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(populationPage.addPopulationButton, "Clicking on Add Population Button in Population page.");
		co.click(populationPage.cancelButton, "Clicking on Cancel Button in Add Population page.");
		
		String expected = "Populations";
		String actual= co.getText(populationPage.pageTitle,"Extracting the text from Population Page Title.");
		
		cm.captureElementScreenShot(driver, populationPage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected, "The page did not navigate to Population Page.");
	}

	//======================================================================================================
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		populationPage = new PopulationPage().populationPageInit(driver);
		
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.populationsLink, "Clicking on Population link Under Net Price Tab.");
		
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
