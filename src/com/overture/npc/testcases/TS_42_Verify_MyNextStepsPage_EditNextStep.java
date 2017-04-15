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

import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.NextStepsPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_42_Verify_MyNextStepsPage_EditNextStep {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	WebElement element=null;
	String testData=null;
	boolean flag=false;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	NextStepsPage nextStepPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_Assigned_SelectBox() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + testCaseName);
		cm.captureElementScreenShot(driver, nextStepPage.assignedListBox, testCaseName, cm.basepath());
		Assert.assertEquals(nextStepPage.assignedListBox.isEnabled(), true, "The 'Assigned' is not enabled");
		Reporter.log(cm.ReporterText("Checked if 'Assigned' Listbox is enabled"));
		Reporter.log(cm.ReporterLink(testCaseName));
	}
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Display_Textbox() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + testCaseName);
		co.type(nextStepPage.displayTxtBox, "Tester", "Editing the Textbox");
		cm.captureElementScreenShot(driver, nextStepPage.displayTxtBox, testCaseName, cm.basepath());
		Assert.assertEquals(nextStepPage.displayTxtBox.isEnabled(), true, "The Display Text Box is not enabled");
		Reporter.log(cm.ReporterText("Checked if 'Display' Textbox is Enabled "));
		Reporter.log(cm.ReporterLink(testCaseName));
	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_DisplayOptions_Dropdown() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + testCaseName);
		/*Select select=new Select(nextStepPage.displayOptions);*/
		co.click(nextStepPage.displayOptions, "Clicking on Dropdown box");
		
		cm.captureDriverScreenShot(driver, testCaseName, cm.basepath());
		
		String expectedList = "Please Select, Display as URL, Display as PopUp";
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.dropdownValueFinder(driver, nextStepPage.displayOptions);
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual, "Options did not match");
		Reporter.log(cm.ReporterText("Checked if 'Display Options' dropdown has 'Display as URL' and 'Display as PopUp' options"));
		Reporter.log(cm.ReporterLink(testCaseName));
	}
	//===========================================================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_PopulationList_SelectBox() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + testCaseName);
		cm.captureElementScreenShot(driver, nextStepPage.populationListBox, testCaseName, cm.basepath());
		Assert.assertEquals(nextStepPage.populationListBox.isEnabled(), true, "The 'Population List' is not enabled");
		Reporter.log(cm.ReporterText("Checked if 'Population List' is enabled"));
		Reporter.log(cm.ReporterLink(testCaseName));
	}
	//===========================================================================================================================
	
	
	@Test(priority = 5)
	public void TC_05_Validate_PushingValuesFromAssignedListToPopulationList_Button() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + testCaseName);
		String testCaseName1 = testCaseName+"_Button";
		cm.ReporterText("TestCase : " + testCaseName1);
		
		int  everyoneValuePresent= driver.findElements( By.xpath("//select[@id='box2View']/option[contains(.,'Everyone')]") ).size();
		
		if(everyoneValuePresent!=0)
		{
			cm.captureElementScreenShot(driver, nextStepPage.assignedListBox, testCaseName, cm.basepath());
			Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(testCaseName)));
			co.click(nextStepPage.assignedListBoxOptionValue_Everyone, "Selecting 'Everyone' value in Assigned List");
			co.click(nextStepPage.transferToPopulationListTBoxButton,"Click '<' button  to push 'Everyone' to 'Population List'");
		}
		else if(everyoneValuePresent==0)
		{
			co.click(nextStepPage.populationListBoxOptionValue_Everyone, "Selecting 'Everyone' value in Population List");
			co.click(nextStepPage.transferToAssignedTableButton,"Click '>' button  to push 'Everyone' to 'Assigned List'");
			cm.captureElementScreenShot(driver, nextStepPage.assignedListBox, testCaseName, cm.basepath());
			Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(testCaseName)));
			co.click(nextStepPage.assignedListBoxOptionValue_Everyone, "Selecting 'Everyone' value in Assigned List");
			co.click(nextStepPage.transferToPopulationListTBoxButton,"Click '<' button  to push 'Everyone' to 'Population List'");
		}
		else{
			Reporter.log(cm.ReporterText("'Everyone Value not present'"));
		}
		Assert.assertEquals(nextStepPage.populationListBoxOptionValue_Everyone.getText(), "Everyone", "'Population List' SelectBox does not have 'Everyone' as an option");
		cm.captureElementScreenShot(driver, nextStepPage.assignedListBox, testCaseName1, cm.basepath());
		Reporter.log(cm.ReporterText("After : "+cm.ReporterLink(testCaseName1)));
	}
	//===========================================================================================================================
	
	@Test(priority = 6)
	public void TC_06_Validate_PushingValuesFromPopulationToAssignedList_Button() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + testCaseName);
		String testCaseName1 = testCaseName+"_Button";
		cm.ReporterText("TestCase : " + testCaseName1);
		
		if(nextStepPage.populationListBoxOptionValue_Everyone.isDisplayed())
		{
			cm.captureElementScreenShot(driver, nextStepPage.assignByPopulationTable, testCaseName, cm.basepath());
			Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(testCaseName)));
			co.click(nextStepPage.populationListBoxOptionValue_Everyone, "Selecting 'Everyone' value in Population List");
			co.click(nextStepPage.transferToAssignedTableButton,"Click '>' button  to push 'Everyone' to 'Assigned List'");
		}
		else if(nextStepPage.assignedListBoxOptionValue_Everyone.isDisplayed())
		{
			co.click(nextStepPage.assignedListBoxOptionValue_Everyone, "Selecting 'Everyone' value in Assigned List");
			co.click(nextStepPage.transferToPopulationListTBoxButton,"Click '<' button  to push 'Everyone' to 'Population List'");
			cm.captureElementScreenShot(driver, nextStepPage.assignByPopulationTable, testCaseName, cm.basepath());
			Reporter.log(cm.ReporterText("Before : "+cm.ReporterLink(testCaseName)));
			co.click(nextStepPage.populationListBoxOptionValue_Everyone, "Selecting 'Everyone' value in Population List");
			co.click(nextStepPage.transferToAssignedTableButton,"Click '>' button  to push 'Everyone' to 'Assigned List'");
		}
		else{
			Reporter.log(cm.ReporterText("'Everyone Value not present'"));
		}
		Assert.assertEquals(nextStepPage.assignedListBoxOptionValue_Everyone.getText(), "Everyone", "'Assigned' SelectBox does not have 'Everyone' as an option");
		cm.captureElementScreenShot(driver, nextStepPage.assignByPopulationTable, testCaseName1, cm.basepath());
		Reporter.log(cm.ReporterText("After : "+cm.ReporterLink(testCaseName1)));
	}
	//===========================================================================================================================
	

	
	@Test(priority = 7)
	public void TC_07_Validate_TaskName_Textbox() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + testCaseName);
		co.type(nextStepPage.taskNameTxtBox, "Test", "Editing the Textbox");
		cm.captureElementScreenShot(driver, nextStepPage.taskNameTxtBox, testCaseName, cm.basepath());
		
		Assert.assertEquals(nextStepPage.taskNameTxtBox.isEnabled(), true, "The Task Name Text Box is not enabled");
		Reporter.log(cm.ReporterText("Checked if 'Task Name' Textbox is Enabled "));
		Reporter.log(cm.ReporterLink(testCaseName));
	}
	//===========================================================================================================================
	
	
	@Test(priority = 8)
	public void TC_08_Validate_SaveChanges_Button() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		testData="NewNextStep_"+cm.randomNumberGenerator();
		cm.ReporterText("TestCase : " + testCaseName);
		
		//co.click(nextStepPage.createNewNextStepBtn,"Clicking on Create New Next Step Button.");
		flag=co.createNewNextStep(driver, testData);
		co.click(nextStepPage.saveChangesButton, "Clicking on Save Changes Button in Edit Next Step page.");
		co.alertHandler(driver).accept();
		element =driver.findElement(By.xpath("//ul[@id='taskList']//li//a[contains(.,'"+testData+"')]"));
		
		cm.captureElementScreenShot(driver, element, testCaseName, cm.basepath());
		Reporter.log(cm.ReporterLink(testCaseName));
		Assert.assertEquals(element.isDisplayed(), true, "The New Next Step "+testData+" is Not Displayed");
	}
	//===========================================================================================================================
	
	@Test(priority = 9)
	public void TC_09_Validate_Cancel_Button() {
		String testCaseName = new Object(){}.getClass().getEnclosingMethod().getName();
		String expected="My Next Steps";
		cm.ReporterText("TestCase : " + testCaseName);
	
		homePage = new HomePage().homePageInit(driver);
		nextStepPage=new NextStepsPage().nextStepInit(driver);
		
		
			co.click(nextStepPage.createNewNextStepBtn,"Clicking on Create New Next Step Button.");
			co.click(nextStepPage.cancelButton, "Clicking on Cancel Button in Edit Next Step page.");
			
			String actual=co.getText(homePage.pageTitle, "Extracting Page Title");
			cm.captureElementScreenShot(driver, homePage.pageTitle, testCaseName, cm.basepath());
			Reporter.log(cm.ReporterLink(testCaseName));
			Assert.assertEquals(actual,expected, "The Page did not navigate back to My Next Steps page.");
		
	}
	//===========================================================================================================================
	
	
	
	@BeforeMethod
	public void BeforeMethod(){
		
	}

	@AfterMethod
	public void AfterMethod(){
		if(flag){
			co.click(element, "Clicking on "+testData);
			flag=co.deleteNextStep(driver, testData);
		}
	}

	@BeforeClass
	public void BeforeClass() {
		co.login(driver);
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		nextStepPage=new NextStepsPage().nextStepInit(driver);
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.nextStepsLink, "Click Next Steps Link");
		co.click(nextStepPage.createNewNextStepBtn, "Click on 'Create New Next Step' button");
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
