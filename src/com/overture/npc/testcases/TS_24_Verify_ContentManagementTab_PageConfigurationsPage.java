package com.overture.npc.testcases;


import java.util.ArrayList;

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

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.elementlocators.ChangePasswordPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.PageConfigurationsPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_24_Verify_ContentManagementTab_PageConfigurationsPage {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	HomeServlet homeServlet=new HomeServlet();
	ChangePasswordPage passwordPage=null;
	PageConfigurationsPage pageConfig=null;
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	@Test(priority = 1)
	public void TC_01_Validate_ChooseFile_Button_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		Assert.assertEquals(true, pageConfig.browseButton.isEnabled(),"Browse Button is not Enabled");
		Reporter.log("Checked if Browse button is Enabled");
	}
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Upload_Button_Action() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();		
		
		cm.captureElementScreenShot(driver, pageConfig.browseButton, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterText("Before : ")+cm.ReporterLink(ScreenshotName));
		String fileName=homeServlet.bwrPath()+"/img/testBrowse/actualPic.jpg";
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.type(pageConfig.browseButton, fileName, "Choosing an image file and trying to upload");
		
		cm.captureElementScreenShot(driver, pageConfig.browseButton, ScreenshotName+"_1", cm.basepath());
		Reporter.log(cm.ReporterText("After : ")+cm.ReporterLink(ScreenshotName+"_1"));
		
		co.click(pageConfig.uploadButton, "Clicking on Upload Button");
		cm.captureElementScreenShot(driver, pageConfig.logo, ScreenshotName+"_2", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_2"));
		
		Assert.assertEquals(false,pageConfig.errorMessage.isDisplayed(),"The uploaded image is not in correct format");
		
		String fileNameOrig=homeServlet.bwrPath()+"/img/testBrowse/orig.gif";
		pageConfig=new PageConfigurationsPage().pageConfigurationsInit(driver);
		co.type(pageConfig.browseButton, fileNameOrig, "Choosing the original image file and trying to upload");
		co.click(pageConfig.uploadButton, "Clicking on Upload Button to set original image");
		
	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_Upload_Button_Action_InvalidFile() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String expected="Error:File must be a jpg or a gif.";
		
		cm.captureElementScreenShot(driver, pageConfig.browseButton, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterText("Before : ")+cm.ReporterLink(ScreenshotName));
		String fileName=homeServlet.bwrPath()+"/img/testBrowse/invalidFormat.png";
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.type(pageConfig.browseButton, fileName, "Choosing an image file and trying to upload");
		
		cm.captureElementScreenShot(driver, pageConfig.browseButton, ScreenshotName+"_1", cm.basepath());
		Reporter.log(cm.ReporterText("After : ")+cm.ReporterLink(ScreenshotName+"_1"));
		
		co.click(pageConfig.uploadButton, "Clicking on Upload Button");
		cm.captureElementScreenShot(driver, pageConfig.errorMessage, ScreenshotName+"_2", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_2"));
		
		System.out.println("Asserting Test Case");
		Assert.assertEquals(pageConfig.errorMessage.getText(),expected, "The error message did not match" );
		
	}
	//===========================================================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_Upload_Button_Action_InvalidImageSize() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String expected="Error:File is too big, please ensure that it is smaller than 100kb";
		
		cm.captureElementScreenShot(driver, pageConfig.browseButton, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterText("Before : ")+cm.ReporterLink(ScreenshotName));
		String fileName=homeServlet.bwrPath()+"/img/testBrowse/highSize.jpg";
		cm.ReporterText("TestCase : " + ScreenshotName);
		co.type(pageConfig.browseButton, fileName, "Choosing an image file and trying to upload");
		
		cm.captureElementScreenShot(driver, pageConfig.browseButton, ScreenshotName+"_1", cm.basepath());
		Reporter.log(cm.ReporterText("After : ")+cm.ReporterLink(ScreenshotName+"_1"));
		
		co.click(pageConfig.uploadButton, "Clicking on Upload Button");
		cm.captureElementScreenShot(driver, pageConfig.errorMessage, ScreenshotName+"_2", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"_2"));
		
		System.out.println("Asserting Test Case");
		Assert.assertEquals(pageConfig.errorMessage.getText(),expected,"The error message did not match");
		
	}
	//===========================================================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_TextBoxes_Enable() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		Assert.assertEquals(pageConfig.cohortAidText.isEnabled(), true,"The cohort Ais % Text is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.cohortAidText, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		
		Assert.assertEquals(pageConfig.stateGrantText.isEnabled(), true,"The state grant Textbox is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.stateGrantText, ScreenshotName+"1", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"1"));
		
		Assert.assertEquals(pageConfig.institutionalGrantText.isEnabled(), true,"The institutional grant textbox is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.institutionalGrantText, ScreenshotName+"2", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"2"));
		
		Assert.assertEquals(pageConfig.instScholarshipText.isEnabled(), true,"The Institutional Scholarship Textbox is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.instScholarshipText, ScreenshotName+"3", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"3"));
		
		Assert.assertEquals(pageConfig.consolidateSelfHelpText.isEnabled(), true,"The Consolidated Self Help is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.consolidateSelfHelpText, ScreenshotName+"4", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"4"));
		
		Assert.assertEquals(pageConfig.schoolDefinedFund1Text.isEnabled(), true,"The school defined fund 1 Textbox is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.schoolDefinedFund1Text, ScreenshotName+"5", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"5"));
		
		Assert.assertEquals(pageConfig.schoolDefinedFund2Text.isEnabled(), true,"The School Defined Fund 2 Textbox is not enabled");
		cm.captureElementScreenShot(driver, pageConfig.schoolDefinedFund2Text, ScreenshotName+"6", cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName+"6"));
	}
	//===========================================================================================================================
	
	@Test(priority = 6)
	public void TC_06_Validate_Sections_Availabilty() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String [] expectedList ={"Image Selection", "Percent Grant Aid", "My Net Price", "EFC/Grant Aid Display"};
		ArrayList<String> stringList=cm.boldTextFinder(driver, pageConfig.formName);
		for(int i=0; i<stringList.size();i++)
		{
			WebElement element= driver.findElement(By.xpath("//form[@id='configurationForm']//b[contains(.,'"+stringList.get(i)+"')]")) ;
			
			Reporter.log(cm.ReporterText(stringList.get(i)+" text exists: ")+element.isDisplayed());
			cm.mouseOver(driver, element, stringList.get(i));
			cm.captureElementScreenShot(driver, element, ScreenshotName+i, cm.basepath());
			Reporter.log(cm.ReporterText(stringList.get(i))+ cm.ReporterLink(ScreenshotName+i));
			Assert.assertEquals( element.getText(), expectedList[i], stringList.get(i)+" section is not present");
		}	
		
	}
	
	//===========================================================================================================================
	
	@Test(priority = 7)
	public void TC_07_Validate_SaveChangesButton_Function() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData1="Student C",testData2="Student B";
		String actual=null,expected=null;
		
		cm.captureElementScreenShot(driver, pageConfig.bubbleImageOne, ScreenshotName+"before", cm.basepath());
		Reporter.log(cm.ReporterText("Before : ")+ cm.ReporterLink(ScreenshotName+"before"));
		
		expected=co.selectingPageConfigurationImageSave(driver, testData1, testData2);
		co.click(pageConfig.saveChangesButton, "Clicking On Save Changes Button.");
		co.alertHandler(driver).accept();
		
		pageConfig=new PageConfigurationsPage().pageConfigurationsInit(driver);
		actual=co.getFirstSelectedDropDown(pageConfig.bubbleImageOne);
		
		cm.captureElementScreenShot(driver, pageConfig.bubbleImageOne, ScreenshotName+"after", cm.basepath());
		Reporter.log(cm.ReporterText("After : ")+ cm.ReporterLink(ScreenshotName+"after"));
		Assert.assertEquals(actual, expected);
		
	}
	
	//===========================================================================================================================
	
	@Test(priority = 8)
	public void TC_08_Validate_CancelButton_Function() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		String testData1="Student C",testData2="Student B";
		String actual=null, expected=null;
		
		cm.captureElementScreenShot(driver, pageConfig.bubbleImageOne, ScreenshotName+"Before", cm.basepath());
		Reporter.log(cm.ReporterText("Before : ")+ cm.ReporterLink(ScreenshotName+"Before"));
		
		expected=co.selectingPageConfigurationImageCancel(driver, testData1, testData2);
		co.click(pageConfig.cancelButton, "Clicking On Cancel Button.");
		
		pageConfig=new PageConfigurationsPage().pageConfigurationsInit(driver);
		actual=co.getFirstSelectedDropDown(pageConfig.bubbleImageOne);
		
		cm.captureElementScreenShot(driver, pageConfig.bubbleImageOne, ScreenshotName+"After", cm.basepath());
		Reporter.log(cm.ReporterText("After : ")+ cm.ReporterLink(ScreenshotName+"After"));
		Assert.assertEquals(actual, expected);
	}
	
	//===========================================================================================================================
	
	
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		pageConfig=new PageConfigurationsPage().pageConfigurationsInit(driver);
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.pageConfigurationsLink, "Click Page Configurations Link");
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
