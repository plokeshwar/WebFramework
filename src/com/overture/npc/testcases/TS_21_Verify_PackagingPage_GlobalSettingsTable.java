package com.overture.npc.testcases;
import java.util.List;

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

import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.PackagingPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_21_Verify_PackagingPage_GlobalSettingsTable {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	PackagingPage packagingPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_AvailabilityOfTwo_Tables_in_GlobalSettingsTab() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		String [] expect = {"Manage Cap Limit", "Manage Floor Limit"};

		List<WebElement> actualList = packagingPage.globalSettingsTable.findElements(By.className("pageTitle"));
		
		for(int i=0;i<actualList.size();i++){ 
				Reporter.log(cm.ReporterText("Validating If "+expect[i]+" is Available in Global Settings Tab as Title."));
				cm.captureElementScreenShot(driver, actualList.get(i), ScreenshotName+i, cm.basepath());
				Reporter.log(actualList.get(i).getText()+" : "+cm.ReporterLink(ScreenshotName+i));
				Assert.assertEquals(actualList.get(i).getText().equalsIgnoreCase(expect[i]),true,"One of the Title Did not Match");
		}
			
			
	}
	//===========================================================================================================================


	
	@Test(priority = 2)
	public void TC_02_Validate_Checkbox_Enabled_CapLimit() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");

		Assert.assertEquals(co.findCheckboxEnabled(driver, packagingPage.globalSettingsGlobalCapList), true,"One of the check boxes are disabled.");
	}
	//===========================================================================================================================
	
	
	@Test(priority = 3)
	public void TC_03_Validate_Checkbox_Enabled_FloorLimit() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		Assert.assertEquals(co.findCheckboxEnabled(driver, packagingPage.globalSettingsGlobalFloorList), true,"One of the check boxes are disabled.");
	}
	//===========================================================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_CapLimitAmount_ValidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		co.globalSettingsTextBoxValidator_Valid(driver, packagingPage.globalSettingsGlobalCapList, "123");
	}
	
	//===========================================================================================================================
	
	@Test(priority = 6)
	public void TC_06_Validate_FloorLimitAmount_ValidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		co.globalSettingsTextBoxValidator_Valid(driver, packagingPage.globalSettingsGlobalFloorList, "123");
	}
	
	//===========================================================================================================================


	@Test(priority = 7)
	public void TC_07_Validate_CapLimitAmount_InvalidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		co.globalSettingsTextBoxValidator_Invalid(driver, packagingPage.globalSettingsGlobalCapList, "ABC");
	}
	
	//===========================================================================================================================

	@Test(priority = 8)
	public void TC_08_Validate_FloorLimitAmount_InvalidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		System.out.println("Asserting the test case");
		co.globalSettingsTextBoxValidator_Invalid(driver, packagingPage.globalSettingsGlobalFloorList, "ABC");
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 9)
	public void TC_09_Validate_SaveChanges_Button_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);

		String expected="Are you sure you want to save?";
		
		co.click(packagingPage.globalSettingsTabLink, "Clicking on Global Settings Tab in Packaging page.");
		co.click(packagingPage.globalSettingsSaveChangesButton, "Clicking Save Changes Button in Global Settings Tabe.");

		String actual=co.alertHandler(driver).getText();
		
		co.alertHandler(driver).dismiss();
		
		Reporter.log(cm.ReporterText("Screen Shot Not Taken, as Validating Pop-up."));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}
	
	//============================================================================================
	
	
	@Test(priority = 10)
	public void TC_10_Validate_Cancel_Button_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		co.click(packagingPage.globalSettingsTabLink, "Clicking on Global Settings Tab in Packaging page.");
		co.click(packagingPage.globalSettingsCancelButton, "Clicking Cancel Button in Global Settings Tab.");

		cm.captureElementScreenShot(driver, packagingPage.packagingTabLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(packagingPage.packagingTabLink.isEnabled(), true,"The Cancel Button Action in Global Settings Tab Failed.");
		
	}
	
	//============================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		packagingPage=new PackagingPage().packagingPageElementsInit(driver);
		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");
		
		co.click(homePage.packagingLink, "Clicking on Packaging Link in Net Price Tab");
		co.click(packagingPage.globalSettingsTabLink, "Clicking on the Global Settings Tab.");
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