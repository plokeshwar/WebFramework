package com.overture.npc.testcases;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.overture.npc.elementlocators.ChangePasswordPage;
import com.overture.npc.elementlocators.ContentEditorPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_38_Verify_ContentEditorPage_MyNextStepsLink {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	ContentEditorPage contentEditorPage=null;
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_ViewDefault_Links() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		String expectedList = "View Default";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.paragraphFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Navigation_ContentRegion() {
		
		String [] expectedList ={"My Next Steps - Helpful Information"};
		String [] screenshotList={"TC_02_Validate_PopUps_ContentRegion", "TC_02_Validate_PopUps_ContentRegion_1"} ;
		
		ArrayList<String> stringList=cm.linkFinder(driver, contentEditorPage.listPageTable);
		for(int i=0; i<stringList.size();i++)
		{
			WebElement element= driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+stringList.get(i)+"')]")) ;
			co.click(element, "Clicking on "+stringList.get(i));
			String headerText= contentEditorPage.popHeaderPopulationContent.getText();
			cm.captureElementScreenShot(driver, contentEditorPage.popHeaderPopulationContent, screenshotList[i], cm.basepath());
			Reporter.log(cm.ReporterText(stringList.get(i))+ cm.ReporterLink(screenshotList[i]));
			System.out.println("Asserting Test Case");
			Assert.assertEquals( headerText, expectedList[i], "Page Navigation Error");
			homePage = new HomePage().homePageInit(driver);
			contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
			cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
			co.click(homePage.contentEditorLink, "Click Content Editor Link");
			co.click(contentEditorPage.myNextStepsLink, "Click on 'My Next Steps' Link");
		}	

		
	}
	//===========================================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_PopUps_DefaultContent() {
		
		 List<WebElement> paragraphs = contentEditorPage.listPageTable.findElements(By.tagName("p"));
		 Iterator<WebElement> i = paragraphs.iterator(); 
		 while(i.hasNext()) { 
			 WebElement viewDefault = i.next(); 
			 co.click(viewDefault, "Clicking on View Default Link");
			 Reporter.log(cm.ReporterText("View Default Pop Up exists: ")+contentEditorPage.viewDefaultPopUpHeaderCommonAAP.isDisplayed());
			 System.out.println("Asserting Test Case");
			 Assert.assertEquals(contentEditorPage.viewDefaultPopUpHeaderCommonAAP.isDisplayed(), true, "The Pop Up does not appear");
			 co.click(contentEditorPage.viewDefaultPopUpCloseCommonAAP, "Closing View Default Pop Up");
			 contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
		 }
	}
	//===========================================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.myNextStepsLink, "Click on 'My Next Steps' Link");
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
