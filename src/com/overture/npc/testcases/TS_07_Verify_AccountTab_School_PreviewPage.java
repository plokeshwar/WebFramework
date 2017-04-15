package com.overture.npc.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import com.overture.npc.elementlocators.Add_N_Edit_TestCasePage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.PreviewPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

@Test(priority=4)
public class TS_07_Verify_AccountTab_School_PreviewPage {

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	PreviewPage previewPage= null;
	Add_N_Edit_TestCasePage add_N_Edit_testCasePage=null;
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	static boolean flag=false;
	WebElement element=null;
	
	@Test(priority = 1)
	public void TC_01_Validate_AddTestCase_Button_Navigation() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		cm.ReporterText("TestCase : " + ScreenshotName);
		String expected="Add Test Case";
		co.click(previewPage.addTestCaseButton, "Clicking on Add Test Case Button in Preview Page.");
		System.out.println("Asserting the test case");
		cm.captureElementScreenShot(driver, previewPage.headerText, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(previewPage.headerText.getText(), expected, "The header Text did not match.");
	}
	
	//============================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_TestCaseTable_Columns() {
		String [] screenshotList={"TC_02_Validate_PopUps_ContentRegion", "TC_02_Validate_PopUps_ContentRegion_1"} ;
		String expectedList ="Name, Last Updated, Results, Student Experience";
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> stringList=cm.linkFinderByTableColumn(driver, previewPage.previewTable);
		Assert.assertEquals(stringList, expect);
		cm.captureElementScreenShot(driver, previewPage.previewTable, screenshotList[1], cm.basepath());
		Reporter.log(cm.ReporterLink(screenshotList[1]));
	}
	//============================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_TestCaseTable_NameLink_Navigation() {
		String Screenshot=new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		co.click(previewPage.addTestCaseButton, "Clicking on Add Test Case Button in Preview Page.");
		co.type(add_N_Edit_testCasePage.nameEditBox, testData, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		System.out.println("Asserting the test case");
		Assert.assertEquals(element.isDisplayed(),true,"The Test Case is not created.");
		element.click();
			
		String headerText= co.getText(previewPage.headerText,"Getting Text");
		cm.captureElementScreenShot(driver, previewPage.headerText,Screenshot, cm.basepath());
		Reporter.log(cm.ReporterText(testData +":")+ cm.ReporterLink(Screenshot));
		System.out.println("Asserting Test Case");
		Assert.assertEquals( headerText, "Edit Test Case: "+testData, "Page Navigation Error");
		flag=true;
		
	}
	//============================================================================================
	
	
	@Test(priority = 4)
	public void TC_04_Validate_TestCaseTable_LastUpdateDate() {
		String Screenshot=new Object(){}.getClass().getEnclosingMethod().getName();
		String testData="TestName"+cm.randomNumberGenerator();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String textDate=dateFormat.format(date);
		
		co.click(previewPage.addTestCaseButton, "Clicking on Add Test Case Button in Preview Page.");
		co.type(add_N_Edit_testCasePage.nameEditBox, testData, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		co.click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		System.out.println("Asserting the test case");
		Assert.assertEquals(element.isDisplayed(),true,"The Test Case is not created.");
		
		WebElement newElement=driver.findElement(By.xpath("//table[@id='preview-list']//tr[contains(.,'"+testData+"')]//td[2]"));
		cm.captureElementScreenShot(driver, newElement,Screenshot, cm.basepath());
		Reporter.log(cm.ReporterText(testData +":")+ cm.ReporterLink(Screenshot));
		
		String actualTextDate=newElement.getText();
		Assert.assertEquals(actualTextDate, textDate,"The date does not match");
		flag=true;
		
		
	}
	
	//=====================================================================================================================
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		previewPage=new PreviewPage().previewElementsInit(driver);
		add_N_Edit_testCasePage= new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		co.click(homePage.previewLink, "Clicking the Preview Link under Accounts Tab.");
	}

	@AfterMethod
	public void AfterMethod() {
		if(flag){
			Reporter.log(cm.ReporterText("Deleting the Test Case Created"));
			try{
				element.click();
			}catch (Exception e) {
				
			}
			add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
			co.click(add_N_Edit_testCasePage.deleteButton,"Clicking on Delete Button in Edit Test Case page.");
			co.alertHandler(driver).accept();
			flag=false;
			Reporter.log(cm.ReporterText("-----------------------------------------------"));
			Reporter.log(cm.ReporterText(""));
		}
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
