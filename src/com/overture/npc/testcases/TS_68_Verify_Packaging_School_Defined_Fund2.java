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
import com.overture.npc.elementlocators.PackagingPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_68_Verify_Packaging_School_Defined_Fund2 {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	HomePage homePage = null;
	PackagingPage packagingPage=null;

	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();

	private boolean flag;
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Assignment_Table() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		String expected="School Defined Fund1";		
		String actual=co.getText(packagingPage.pageTitle,"extracting text from the  Header in Edit Packaging page.");
		
		cm.captureElementScreenShot(driver, packagingPage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"page did not navigated to the  Edit Packaging School Defined Fund1 page.");
	}
	
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Fixed_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.click(packagingPage.fixedLink,"clicking on fixed link present in the Edit Packaging School Defined Fund1 page.");
		
	
		String expected="Add Fixed Value of:";
		String actual=packagingPage.newRow.getText();
		
		
		cm.captureElementScreenShot(driver, packagingPage.newRow, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"new row not added.");
	}
	
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Save_Button() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.click(packagingPage.fixedLink,"clicking on fixed link present in the Edit Packaging School Defined Fund1 page.");
		String testData=cm.randomNumberGenerator();
		
		co.type(packagingPage.editPackageInputField,testData,"Entering some values into the text field in Edit Packaging School Defined Fund1 page.");
		co.click(packagingPage.editPackageSaveButton,"clicking the save button in Edit Packaging School Defined Fund1 page.");
		co.alertHandler(driver).accept();
		packagingPage= new PackagingPage().packagingPageElementsInit(driver);
		co.click(packagingPage.school_Defined_Fund1Link,"clicking on School Defined Fund1 link.");
		String actual=packagingPage.editPackageInputField.getAttribute("value");
		Reporter.log(cm.ReporterTextBold("Expected : "+testData));
		Reporter.log(cm.ReporterTextBold("Actual : "+actual));
		cm.captureElementScreenShot(driver, packagingPage.editPackageInputField, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, testData,"Save value is not present");
		flag=Boolean.TRUE;
		
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 4)
	public void TC_04_Validate_Cancel_Button() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.click(packagingPage.editPackageCancelButton,"clicking on cancel button present in School Defined Fund1 page.");
		packagingPage= new PackagingPage().packagingPageElementsInit(driver);
		Boolean expected=true;
		Boolean actual=packagingPage.packagingTabLink.isEnabled();
		cm.captureElementScreenShot(driver,packagingPage.packagingTabLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"not navigated to the Packaging main page.");
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 5)
	public void TC_05_Validate_Factor_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		
		co.click(packagingPage.factorLink,"clicking on Add Factor of link present in the Edit Packaging School Defined Fund1 page.");
		
	
		String expected="Add Factor Of:";
		String actual=packagingPage.newRow.getText();
		
		
		cm.captureElementScreenShot(driver, packagingPage.newRow, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"new row not added.");
	}
	
	//===========================================================================================================================
	
	
	@Test(priority = 6)
	public void TC_06_Validate_ValueTable_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.click(packagingPage.ValueTableLink,"clicking on Value From Table link present in the Edit Packaging School Defined Fund1 page.");
		
	
		String expected="Add Value From Table:";
		String actual=packagingPage.newRow.getText();
		
		
		cm.captureElementScreenShot(driver, packagingPage.newRow, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(actual, expected,"new row not added.");
	}
	
	//===========================================================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		packagingPage= new PackagingPage().packagingPageElementsInit(driver);
		cm.mouseOver(driver, homePage.netPriceTab, "Net Price Tab");
		co.click(homePage.packagingLink,"Clicking on Table link present under net price tab.");
		co.click(packagingPage.packagingTabLink, "Clicking on packaging tab present inside packaging link.");
		co.click(packagingPage.school_Defined_Fund1Link,"clicking on School Defined Fund1 link.");
		
		if(packagingPage.assignmentPackageList.size()>0){
			co.deleteAssignmentPackages(driver);	
			
		}
		
		
		if(packagingPage.assignmentPackageList.size()>0){
			
		co.click(packagingPage.editPackageSaveButton,"Clicking on Save Changes button in Edit package page.");
		co.alertHandler(driver).accept();
		packagingPage= new PackagingPage().packagingPageElementsInit(driver);
		
		co.click(packagingPage.school_Defined_Fund1Link,"clicking on School Defined Fund1 link.");
		}
		
	}

	@AfterMethod
	public void AfterMethod() {
		if(flag)
		{
			if(packagingPage.assignmentPackageList.size()>0){
				co.deleteAssignmentPackages(driver);		
			}
			co.click(packagingPage.editPackageSaveButton,"Clicking on Save Changes button in Edit package page.");
			co.alertHandler(driver).accept();
			packagingPage= new PackagingPage().packagingPageElementsInit(driver);
			flag=Boolean.FALSE;
		}
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
