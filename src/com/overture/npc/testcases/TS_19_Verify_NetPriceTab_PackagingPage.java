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

import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.PackagingPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_19_Verify_NetPriceTab_PackagingPage {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	PackagingPage packagingPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Tabs_Availability_Packaging_N_Global() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.packagingLink, "Clicking on Packaging Link in Net Price Tab");
		co.click(packagingPage.packagingTabLink, "Clicking on the Packaging Tab in the Packaging Screen");
		
		cm.captureElementScreenShot(driver, packagingPage.packagingTabLink, ScreenshotName+"_packaging", cm.basepath());
		Reporter.log(cm.ReporterText(packagingPage.packagingTabLink.getText())+"  : "+cm.ReporterLink(ScreenshotName+"_packaging"));
		System.out.println("Asserting the test case A");
		Assert.assertEquals(packagingPage.packagingTabLink.getText(), "Packaging", "Packaging Tab Not Available");
		
		co.click(packagingPage.globalSettingsTabLink, "Clicking on the Global Settings Tab in the Packaging Screen");
		
		cm.captureElementScreenShot(driver, packagingPage.globalSettingsTabLink, ScreenshotName+"_globalSettings", cm.basepath());
		Reporter.log(cm.ReporterText(packagingPage.globalSettingsTabLink.getText())+"  : "+cm.ReporterLink(ScreenshotName+"_globalSettings"));
		System.out.println("Asserting the test case B");
		Assert.assertEquals(packagingPage.globalSettingsTabLink.getText(), "Global Settings", "Global Settings Tab Not Available");
		
	}
	//===========================================================================================================================

	
	
	@Test(priority = 2)
	public void TC_02_Validate_Packaging_Tab_Enabled_On_Clicking() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.packagingLink, "Clicking on Packaging Link in Net Price Tab");
		co.click(packagingPage.packagingTabLink, "Clicking on the Packaging Tab in the Packaging Screen");
		
		cm.captureElementScreenShot(driver, packagingPage.packagingTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case A");
		Assert.assertEquals(packagingPage.packagingTable.isEnabled(), true, "Packaging Table is Not Enabled");
		
		
	}
	//===========================================================================================================================

	
	@Test(priority = 3)
	public void TC_03_Validate_Account_Settings_Tab_Enabled_On_Clicking() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		co.click(homePage.packagingLink, "Clicking on Packaging Link in Net Price Tab");
		co.click(packagingPage.globalSettingsTabLink, "Clicking on the Global Settings Tab in the Packaging Screen");
		
		cm.captureElementScreenShot(driver, packagingPage.globalSettingsTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case B");
		Assert.assertEquals(packagingPage.globalSettingsTable.isEnabled(), true, "Global Settings Table is Not Enabled");
		
	}
	//===========================================================================================================================

	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		packagingPage=new PackagingPage().packagingPageElementsInit(driver);
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
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
