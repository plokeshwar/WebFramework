package com.overture.npc.testcases;

import java.util.ArrayList;

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

import com.overture.npc.elementlocators.ChangePasswordPage;
import com.overture.npc.elementlocators.ContentEditorPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_25_Verify_ContentManagementTab_ContentEditorPage {
	
	String className=this.getClass().getName().substring(27);
	
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	ContentEditorPage contentEditorPage=null;
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	/**
	 * This test case will validate "Common Across All Pages" link
	 * <p>
	 * Steps : Click on the "Common Across All Pages" link in the Content Editor Page. 
	 * <p>
	 * Expected Result : It will display a table with "School Name" and "NPC Exit URL" in "Content Region Name"
	 * */
	
	@Test(priority = 1)
	public void TC_01_Validate_CommonAcrossAllPages_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		
		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.commonAcrossAllPage, "Click on 'Common Across All Pages' Link");
		String expectedList = "School Name, NPC Exit Url";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_MaintainancePage_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.maintainancePageLink, "Click on 'Maintainance Page' Link");
		
		String expectedList = "Title, Content";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.contentTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================
	

	@Test(priority = 3)
	public void TC_03_Validate_MyEstimatedNetPrice_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.estimatedNetPriceLink, "Click on 'My Estimated Net Price' Link");
		
		String expectedList = "Net Price Footer, Transportation Help, Books & Supplies Help, Personal Expenses Help, Pie Chart Explanation, Est. Remaining Cost Help, " +
				"Est. Self Help Quick Help, Tuition Help, Net Price Regulations, Room & Board Help, Est. Grant Aid Help, Estimated COA Help, EFC Explanation, Est. Net Price Help";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.contentTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_MyInformation_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.myInformationLink, "Click on 'My Information' Link");
		String expected = "Helpful Information";
		String actual= contentEditorPage.singleAnchorLink.getText();
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actual,expected , "Assertion Successful");
	}
	//===========================================================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_MyNextSteps_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.myNextStepsLink, "Click on 'My Next Steps' Link");
		String expected = "Helpful Information";
		String actual= contentEditorPage.singleAnchorLink.getText();
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actual,expected , "Assertion Successful");
	}
	//===========================================================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_MyResources_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.myResourcesLink, "Click on 'My Resources' Link");
		
		String expectedList = "Worksheet Help, Helpful Information, Payment Options, Est. Total My Resources Help";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.contentTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================

	@Test(priority = 7)
	public void TC_07_Validate_NeedHelp_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.needHelpLink, "Click on 'Need Help' Link");
		
		// There is no expected value as on 25th Nov. so we have commented the expected and actual for now.
		
		/*String expected = "Helpful Information";
		String actual= contentEditorPage.singleAnchorLink.getText();*/
		
		
		Reporter.log(cm.ReporterText("No Expected Value Currently."));
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		/*System.out.println("Asserting the test case");

		Assert.assertEquals(actual,expected , "Assertion Successful");*/
	}
	//===========================================================================================================================

	@Test(priority = 8)
	public void TC_08_Validate_NPCWelcomePage_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.npcWelcomePage, "Click on 'NPC Welcome Page' Link");
		String expectedList = "Bubble 1, Main Text, NPC Introduction";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, contentEditorPage.listPageTable);
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================

	@Test(priority = 9)
	public void TC_09_Validate_PageNameTable_Links() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		
		String expectedList = "Common Across All Pages, NPC Welcome Page, Student Information Page, Parent Household Information, Parent Income Information, Parent Assets Information, Student Finances (& Household) Information, Need Help, Please Read, Terms & Conditions, My Estimated Net Price, My Information, My Next Steps, My Resources, Maintenance Page";
		
		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, contentEditorPage.pageNameTable);
		cm.captureElementScreenShot(driver, contentEditorPage.contentTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	//===========================================================================================================================
	
	/**
	 * This test case will validate "Parent Assets Information" link
	 * <p>
	 * Steps : Click on the "Parent Assets Information" link in the Content Editor Page. 
	 * <p>
	 * Expected Result : It will display a table with "Helpful Information" link in"Content Region Name"
	 * */
	
	@Test(priority = 10)
	public void TC_10_Validate_ParentAssetsInformation_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.parentAssetsInfo, "Click on 'Parent Assets Information Page' Link");
		String expected = "Helpful Information";
		String actual= contentEditorPage.singleAnchorLink.getText();
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actual,expected , "Assertion Successful");
	}
	
	//===========================================================================================================================	
	
	@Test(priority = 11)
	public void TC_11_Validate_ParentHouseholdInformation_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
		co.click(homePage.contentEditorLink, "Click Content Editor Link");
		co.click(contentEditorPage.parentHouseholdInfo, "Click on 'Parent Household Information Page' Link");
		String expected = "Helpful Information";
		String actual= contentEditorPage.singleAnchorLink.getText();
		cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(actual,expected , "Assertion Successful");
	}
	//===========================================================================================================================

	
			@Test(priority = 12)
			public void TC_12_Validate_ParentIncomeInformation_Link() {
				String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

				cm.ReporterText("TestCase : " + ScreenshotName);

				cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
				co.click(homePage.contentEditorLink, "Click Content Editor Link");
				co.click(contentEditorPage.parentIncomeInfo, "Click on 'Parent Income Information Page' Link");
				String expected = "Helpful Information";
				String actual= contentEditorPage.singleAnchorLink.getText();
				cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
				Reporter.log(cm.ReporterLink(ScreenshotName));
				System.out.println("Asserting the test case");

				Assert.assertEquals(actual,expected , "Assertion Successful");
			}
			//===========================================================================================================================
		
			@Test(priority = 13)
			public void TC_13_Validate_PleaseRead_Link() {
				String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

				cm.ReporterText("TestCase : " + ScreenshotName);

				cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
				co.click(homePage.contentEditorLink, "Click Content Editor Link");
				co.click(contentEditorPage.pleaseReadLink, "Click on 'Please Read' Link");
				
				// There is no expected value as on 25th Nov. so we have commented the expected and actual for now.
				
				/*String expected = "Helpful Information";
				String actual= contentEditorPage.singleAnchorLink.getText();*/
				
				
				Reporter.log(cm.ReporterText("No Expected Value Currently."));
				cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
				Reporter.log(cm.ReporterLink(ScreenshotName));
				/*System.out.println("Asserting the test case");

				Assert.assertEquals(actual,expected , "Assertion Successful");*/
			}
			//===========================================================================================================================
			
			
			
			@Test(priority = 14)
			public void TC_14_Validate_StudentFinancesInfo_Link() {
				String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

				cm.ReporterText("TestCase : " + ScreenshotName);

				cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
				co.click(homePage.contentEditorLink, "Click Content Editor Link");
				co.click(contentEditorPage.studentFinancesInfo, "Click on 'Student Finances (& Household) Information' Link");
				String expected = "Helpful Information";
				String actual= contentEditorPage.singleAnchorLink.getText();
				cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
				Reporter.log(cm.ReporterLink(ScreenshotName));
				System.out.println("Asserting the test case");

				Assert.assertEquals(actual,expected , "Assertion Successful");
			}
			//===========================================================================================================================
			
			
			
			@Test(priority = 15)
			public void TC_15_Validate_StudentInfoPage_Link() {
				String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

				cm.ReporterText("TestCase : " + ScreenshotName);

				cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
				co.click(homePage.contentEditorLink, "Click Content Editor Link");
				co.click(contentEditorPage.studentInfoPage, "Click on 'Student Information Page' Link");
				String expected = "Helpful Information";
				String actual= contentEditorPage.singleAnchorLink.getText();
				cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
				Reporter.log(cm.ReporterLink(ScreenshotName));
				System.out.println("Asserting the test case");

				Assert.assertEquals(actual,expected , "Assertion Not Successful");
			}
		//===========================================================================================================================
			
			
			@Test(priority = 16)
			public void TC_16_Validate_TermsAndConditions_Link() {
				String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

				cm.ReporterText("TestCase : " + ScreenshotName);

				cm.mouseOver(driver, homePage.contentManagmentTab, "ContentManagementTab");
				co.click(homePage.contentEditorLink, "Click Content Editor Link");
				co.click(contentEditorPage.termsLink, "Click on 'Terms & Conditions' Link");
				
				String expected = "School T&C Link";
				String actual= contentEditorPage.singleAnchorLink.getText();
				cm.captureElementScreenShot(driver, contentEditorPage.listPageTable, ScreenshotName, cm.basepath());
				Reporter.log(cm.ReporterLink(ScreenshotName));
				System.out.println("Asserting the test case");

				Assert.assertEquals(actual,expected , "Assertion Successful");
			}
			//===========================================================================================================================
			
			
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		contentEditorPage=new ContentEditorPage().contentEditorInit(driver);
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
