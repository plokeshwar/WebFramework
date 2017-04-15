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

public class TS_27_Verify_ContentEditorPage_NPCWelcomeLink {
	
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
	public void TC_01_Validate_ViewDefault_Link_Availabilty() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		String expectedList = "View Default, View Default, View Default";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.paragraphFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_PopUps_ContentRegion() {
		
		String [] expectedList ={"NPC Welcome Page - Bubble 1", "NPC Welcome Page - Main Text", "NPC Welcome Page - NPC Introduction"};
		String [] screenshotList={"TC_02_Validate_PopUps_ContentRegion", "TC_02_Validate_PopUps_ContentRegion_1", "TC_02_Validate_PopUps_ContentRegion_2"} ;
		
		ArrayList<String> stringList=cm.linkFinder(driver, contentEditorPage.listPageTable);
		for(int i=0; i<stringList.size();i++)
		{
			WebElement element= driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+stringList.get(i)+"')]")) ;
			co.click(element, "Clicking on "+stringList.get(i));
			Reporter.log(cm.ReporterText("Pop Up exists: ")+contentEditorPage.popUpHeaderCommonAAP.isDisplayed());
			System.out.println(contentEditorPage.popUpHeaderCommonAAP.getText());
			cm.captureElementScreenShot(driver, contentEditorPage.popUpHeaderCommonAAP, screenshotList[i], cm.basepath());
			Reporter.log(cm.ReporterText(stringList.get(i))+ cm.ReporterLink(screenshotList[i]));
			Assert.assertEquals( contentEditorPage.popUpHeaderCommonAAP.getText(), expectedList[i], "The Pop Up is not displayed");
			co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
			contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
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
			 Assert.assertEquals(contentEditorPage.viewDefaultPopUpHeaderCommonAAP.isDisplayed(), true, "The Pop Up does not appear");
			 co.click(contentEditorPage.viewDefaultPopUpCloseCommonAAP, "Closing View Default Pop Up");
			 contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
		 }
	}
	//===========================================================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_PopUpBody_ContentRegion() {
		
		ArrayList<String> stringList=cm.linkFinder(driver, contentEditorPage.listPageTable);
		for(int i=0; i<stringList.size();i++)
		{
			WebElement element= driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+stringList.get(i)+"')]")) ;
			co.click(element, "Clicking on "+stringList.get(i));
			driver.switchTo().frame(driver.findElement(By.id("text_ifr")));
			co.click(contentEditorPage.contentRegionNamePopUpBody, "Clicking on the Body");
			co.type(contentEditorPage.contentRegionNamePopUpBody, "Pravin University Selenium Testing", "Typing inside the body");
			Reporter.log(cm.ReporterText("Pop Up Body is Enabled: ")+contentEditorPage.contentRegionNamePopUpBody.isEnabled());
			Assert.assertEquals(contentEditorPage.contentRegionNamePopUpBody.isEnabled(), true, "The body of Pop Up is not enabled");
			
			co.controlBackToDriver(driver);
			co.click(contentEditorPage.contentRegionNamePopUpButton, "Clicking on Save Changes Button");
			co.alertHandler(driver).accept();
			co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
			contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
		}		
	}
	//===========================================================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_PopUps_ContentRegion_CloseFunction() {
		
		ArrayList<String> stringList=cm.linkFinder(driver, contentEditorPage.listPageTable);
		for(int i=0; i<stringList.size();i++)
		{
			WebElement element= driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+stringList.get(i)+"')]")) ;
			co.click(element, "Clicking on "+stringList.get(i));
			Reporter.log(cm.ReporterText("Pop Up Close Button is Enabled: ")+contentEditorPage.popUpCloseCommonAAP.isEnabled());
			Assert.assertEquals(contentEditorPage.popUpCloseCommonAAP.isEnabled(), true, "The Close Button of Pop Up is not enabled");
			
			co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
			contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
		}	
		
	}
	//===========================================================================================================================
	
	@Test(priority = 6)
	public void TC_06_Validate_PopUps_DefaultContent_CloseFunction() {
		
		List<WebElement> paragraphs = contentEditorPage.listPageTable.findElements(By.tagName("p"));
		 Iterator<WebElement> i = paragraphs.iterator(); 
		 while(i.hasNext()) { 
			 WebElement viewDefault = i.next(); 
			 co.click(viewDefault, "Clicking on View Default Link");
			 Reporter.log(cm.ReporterText("View Default Pop Up Close Button is Enabled: ")+contentEditorPage.viewDefaultPopUpCloseCommonAAP.isEnabled());
			 Assert.assertEquals(contentEditorPage.viewDefaultPopUpCloseCommonAAP.isEnabled(), true, "The Close Button of Pop up is not Enabled");
			 co.click(contentEditorPage.viewDefaultPopUpCloseCommonAAP, "Closing View Default Pop Up");
			 contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
		 }
	}
	//===========================================================================================================================
	
	
	@Test(priority = 7)
	public void TC_07_Validate_PopUps_DefaultContent_SaveChangesFunction() {
		
		String expected="Selecting to save will overwrite any previous information saved. Please select OK to continue";
		
		ArrayList<String> stringList=cm.linkFinder(driver, contentEditorPage.listPageTable);
		for(int i=0; i<stringList.size();i++)
		{
			WebElement element= driver.findElement(By.xpath("//td[@class='listPage']//a[contains(.,'"+stringList.get(i)+"')]")) ;
			co.click(element, "Clicking on "+stringList.get(i));
			co.click(contentEditorPage.contentRegionNamePopUpButton, "Clicking on Save Changes Button");
			String actual=co.alertHandler(driver).getText();
			co.alertHandler(driver).dismiss();
			
			Reporter.log(cm.ReporterText("Screen Shot Not Taken, as Validating Pop-up."));
			System.out.println("Asserting the test case");
			Assert.assertEquals(actual, expected);
			
			co.click(contentEditorPage.popUpCloseCommonAAP, "Closing Pop Up");
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
		co.click(contentEditorPage.npcWelcomePage, "Click on 'NPC Welcome Page' Link");
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
