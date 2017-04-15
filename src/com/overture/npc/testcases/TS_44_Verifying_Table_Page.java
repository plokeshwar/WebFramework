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
import com.overture.npc.elementlocators.TablesPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_44_Verifying_Table_Page {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	HomePage homePage = null;
	TablesPage tablesPage=null;
	
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	

	@Test(priority = 1)
	public void TC_01_Validate_Sub_Header() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		co.click(tablesPage.addNewTableButton,"clicking on add new tables button present in tables page.");
		String expected="Add New Table";		
		String actual=co.getText(tablesPage.subHeader,"extracting text from the sub Header in add tables page.");
		
		cm.captureElementScreenShot(driver, tablesPage.subHeader, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"page did not navigated to the add tables page");
	}
	//===========================================================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_Blank_TextBox() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		co.click(tablesPage.addNewTableButton,"clicking on add new tables button present in tables page.");
		String expected="";		
		String actual=co.getText(tablesPage.tableNameEditBox,"extracting text containt of the name textfield.");
		
		
		cm.captureElementScreenShot(driver, tablesPage.tableNameEditBox, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"the input element was found to contain some value");
	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_InputField() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		co.click(tablesPage.addNewTableButton,"clicking on add new tables button present in tables page.");
		String expected="Please Select an Input";		
		String actual=co.getText(tablesPage.tableInput,"extracting the text from the textField.");
		
		
		cm.captureElementScreenShot(driver, tablesPage.tableInput, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"the inputField was not found");
	}
	//===========================================================================================================================
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		tablesPage= new TablesPage().tablePageInit(driver);
		
		cm.mouseOver(driver, homePage.netPriceTab, "Net Price Tab");
		co.click(homePage.tablesLink,"Clicking on Table link present under net price tab.");
		
		
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
