package com.overture.npc.testcases;

import java.util.ArrayList;
import java.util.List;

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

import com.overture.npc.elementlocators.AccountSettingsPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_04_Verify_AccountTab_AccountSettingsPage {

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	AccountSettingsPage accountSettingPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Save_Changes_Button() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		String expected="Do you want to save the changes??";
		
		co.click(accountSettingPage.saveChanges, "Clicking Save Changes Button in Account Setting Page.");

		String actual = co.getText(accountSettingPage.SaveChangesPopUpText, "Extracting popup text value");
		
		co.click(accountSettingPage.SaveChangesPopUpNo, "Clicking on No option on the popup.");
		
		Reporter.log(cm.ReporterText("Screen Shot Not Taken, as Validating Pop-up."));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}
	
	//============================================================================================
	
	
	
	@Test(priority = 2)
	public void TC_02_Validate_Pop_UP_OK_Function() {
		String ScreenshotName1 = new Object(){}.getClass().getEnclosingMethod().getName();
		String ScreenshotName2 = ScreenshotName1+"_Before";
		String testData=null;

		cm.ReporterText("TestCase : " + ScreenshotName1);
		
		cm.captureElementScreenShot(driver, accountSettingPage.aidYear, ScreenshotName2, cm.basepath());
		Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(ScreenshotName2)));
		
		testData=co.switchingAidYear(driver);
		
		co.click(accountSettingPage.saveChanges, "Clicking Save Changes Button in Account Setting Page.");
		
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		co.click(accountSettingPage.SaveChangesPopUpYes, "Clicking on Yes option on pop-up.");
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		String expected="Settings were saved successfully";
		String actual=accountSettingPage.message.getText();
		Assert.assertEquals(actual, expected,"Successful Saved Message Did not Display");
		
		homePage = new HomePage().homePageInit(driver);
		co.click(homePage.accountSettingsLink, "Clicking the Account Settings Link in Accounts Tab.");
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		String aidYearText1 =co.getFirstSelectedDropDown(accountSettingPage.aidYear);
		
		cm.captureElementScreenShot(driver, accountSettingPage.aidYear, ScreenshotName1, cm.basepath());
		Reporter.log(cm.ReporterText("After : "+cm.ReporterLink(ScreenshotName1)));
		System.out.println("Asserting the test case");
		Assert.assertEquals(aidYearText1, testData,"Before and After AidYear Not Matching");
	}
	//============================================================================================
	
	
	@Test(priority = 3)
	public void TC_03_Validate_Pop_UP_Cancel_Function() {
		String ScreenshotName1 = new Object(){}.getClass().getEnclosingMethod().getName();
		String ScreenshotName2 = ScreenshotName1+"_Before";
		
		cm.ReporterText("TestCase : " + ScreenshotName1);
		
		
		cm.captureElementScreenShot(driver, accountSettingPage.aidYear, ScreenshotName2, cm.basepath());
		Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(ScreenshotName2)));
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		String expected=co.getFirstSelectedDropDown(accountSettingPage.aidYear);
		co.switchingAidYear(driver);
		
		co.click(accountSettingPage.saveChanges, "Clicking Save Changes Button in Account Setting Page.");
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		co.click(accountSettingPage.SaveChangesPopUpNo, "Clicking on No option on the popup.");
		
		homePage = new HomePage().homePageInit(driver);
		co.click(homePage.accountSettingsLink, "Clicking the Account Settings Link in Accounts Tab.");
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		
		String actual=co.getFirstSelectedDropDown(accountSettingPage.aidYear);
		
		
		cm.captureElementScreenShot(driver, accountSettingPage.aidYear, ScreenshotName1, cm.basepath());
		Reporter.log(cm.ReporterText("After : "+cm.ReporterLink(ScreenshotName1)));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		
	}
	//============================================================================================
		
	
	@Test(priority = 4)
	public void TC_04_Validate_Cancel_Button() {
		String ScreenshotName1 = new Object(){}.getClass().getEnclosingMethod().getName();
		String ScreenshotName2 = ScreenshotName1+"_Before";
		
		cm.ReporterText("TestCase : " + ScreenshotName1);
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		cm.captureElementScreenShot(driver, accountSettingPage.aidYear, ScreenshotName2, cm.basepath());
		Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(ScreenshotName2)));
		
		String expected=co.getFirstSelectedDropDown(accountSettingPage.aidYear);
		co.switchingAidYear(driver);
		
		co.click(accountSettingPage.cancel, "Clicking Cancel Button in Account Setting Page.");
		
		homePage = new HomePage().homePageInit(driver);
		co.click(homePage.accountSettingsLink, "Clicking the Account Settings Link in Accounts Tab.");
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		
		
		String actual=co.getFirstSelectedDropDown(accountSettingPage.aidYear);
		
		cm.captureElementScreenShot(driver, accountSettingPage.aidYear, ScreenshotName1, cm.basepath());
		Reporter.log(cm.ReporterText("After : "+cm.ReporterLink(ScreenshotName1)));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
		
	}
	//============================================================================================
	

	@Test(priority = 5)
	public void TC_05_Validate_Aid_Year_DropDown() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		String expectedList="--Select--,2015-16,2016-17";
		
		ArrayList<String> expected = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.dropdownValueFinder(driver, accountSettingPage.aidYear);
		
		co.click(accountSettingPage.aidYear, "Clicking on the Aid-Year drop down list.");
		
		cm.captureDriverScreenShot(driver, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterText(cm.ReporterLink(ScreenshotName)));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}
	
	//============================================================================================
	
	
	@Test(priority = 6)
	public void TC_06_Validate_Calculation_Radio_Button() {
		String ScreenshotName1 = new Object(){}.getClass().getEnclosingMethod().getName();
		String ScreenshotName2 = ScreenshotName1+"_Before";
		String calcRoundingIDAtrribute=null;
		List<WebElement> calcRounding=null;

		cm.ReporterText("TestCase : " + ScreenshotName1);
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		cm.captureElementScreenShot(driver, accountSettingPage.calcRoundingRow, ScreenshotName2, cm.basepath());
		Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(ScreenshotName2)));
		
		calcRounding = accountSettingPage.calcRoundingRadioButton;
		for (WebElement s1 : calcRounding) {
			if(s1.getAttribute("checked")==null){
				calcRoundingIDAtrribute=s1.getAttribute("id");
				co.click(s1, "Clicking the radio button in Calculation Rounding.");
				break;
			}
		}
		
		co.click(accountSettingPage.saveChanges, "Clicking Save Changes Button in Account Setting Page.");
		
		co.click(accountSettingPage.SaveChangesPopUpYes, "Clicking on Yes option on pop-up.");
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
	Assert.assertEquals(accountSettingPage.message.getText(), "Settings were saved successfully","The page was not saved succesfully.");
		
		homePage = new HomePage().homePageInit(driver);
		co.click(homePage.accountSettingsLink, "Clicking the Account Settings Link in Accounts Tab.");
		
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		
		calcRounding = accountSettingPage.calcRoundingRadioButton;
		for (WebElement s1 : calcRounding) {
			if(s1.getAttribute("checked")!=null && s1.getAttribute("checked").equals("true")){
				cm.captureElementScreenShot(driver, accountSettingPage.calcRoundingRow, ScreenshotName1, cm.basepath());
				Reporter.log(cm.ReporterText("After : "+cm.ReporterLink(ScreenshotName1)));
				System.out.println("Asserting the test case");
			Assert.assertEquals(s1.getAttribute("id"), calcRoundingIDAtrribute,"Before and After CalcRounding RadioButton Not Matching");
				break;
				}
			
		}
		
	}
	//============================================================================================
	
	
	@Test(priority = 9)
	public void TC_09_Validate_School_Maintainance_Radio_Button() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		
		for (WebElement s1 : accountSettingPage.schoolMaintainence) {
			if(s1.getAttribute("checked")==null && s1.getAttribute("id").equalsIgnoreCase("enableSite1")){
				co.click(s1, "Clicking on Enable Site Radio Button");
				}
			else if(s1.getAttribute("checked")==null && s1.getAttribute("id").equalsIgnoreCase("enableSite2")){
					co.click(s1,"Clicking Put Site On Hold Radio Button.");
					break;
				}
		}
		
		String expected = "You have put your Net Price Calculator on hold. Do you want be redirected to edit the Maintenance Page Content?";
		String  actual= co.getText(accountSettingPage.SiteOnHoldPopUP, "Extracting text from Site On Hold PopUP");
		
		cm.captureElementScreenShot(driver, accountSettingPage.SiteOnHoldPopUP, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		co.click(accountSettingPage.SiteOnHoldPopUP_NoThanks, "Clicking on No Thanks Close Window Button in Site On Hold Pop UP.");
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expected);
	}
	
	//============================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		
		//cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		co.pause(3000);
		cm.mouseOver(driver, homePage.accountSettingsLink,"account setting link.");
		co.click(homePage.accountSettingsLink, "Clicking the Account Settings Link in Accounts Tab.");
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
