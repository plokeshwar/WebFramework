package com.overture.npc.methods;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.elementlocators.AccountSettingsPage;
import com.overture.npc.elementlocators.Add_N_Edit_TestCasePage;
import com.overture.npc.elementlocators.CostOfAttendancePage;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.NextStepsPage;
import com.overture.npc.elementlocators.PackagingPage;
import com.overture.npc.elementlocators.PageConfigurationsPage;
import com.overture.npc.elementlocators.SchoolPreviewPage;
import com.overture.npc.elementlocators.TestCaseStudentPage;
import com.overture.npc.globalvariables.LoginCredentials;
import com.overture.npc.interfaces.CommonOperationsInterface;

public class CommonOperations implements CommonOperationsInterface {
CommonMethods cm=new CommonMethods();

	
	@Override
	public void click(WebElement element, String message) {
	pause(2500);	
		if(cm.waiters(element)) {
				element.click();
				Reporter.log(cm.ReporterText(message));
				System.out.println(message);
				pause(3500);	
			}
		
	}

	@Override
	public void controlBackToDriver(WebDriver driver) {
		String parentWindowHandler = driver.getWindowHandle(); 
		driver.switchTo().window(parentWindowHandler);
	}
	
	@Override
	public void clear(WebElement element, String message) {
		
		if (cm.waiters(element)) {
			element.clear();
			Reporter.log(cm.ReporterText(message));
			System.out.println(message);
		}
		else {
			Reporter.log(cm.ReporterText("Element Not Located : "+element.toString()));
		}
	}

	@Override
	public void type(WebElement element,String testData, String message){
		if (cm.waiters(element)) {
			try {
				element.clear();
			} catch (Exception e) {}
			
			element.sendKeys(testData);
			Reporter.log(cm.ReporterText(message));
			System.out.println(message);
		}
		else {
			Reporter.log(cm.ReporterText("Element Not Located : "+element.toString()));
		}
	}

	@Override
	public void selectDropDown(WebElement element, String testData, String message) {
		if (cm.waiters(element)) {
				Select menu = new Select(element);
				menu.selectByVisibleText(testData);
				Reporter.log(cm.ReporterText(message));
				System.out.println(message);
		}
	else {
		Reporter.log(cm.ReporterText("Element Not Located : "+element.toString()));
	}
	}

	@Override
	public String getText(WebElement element, String message) {
	String actualTxt=null;
	if (cm.waiters(element)) {
		actualTxt= element.getText();
	}
	else {
		Reporter.log(cm.ReporterText("Element Not Located : "+element.toString()));
	}
	return actualTxt;
	}

	@Override
	public WebDriver browserOpen() {
		HomeServlet homeServlet = new HomeServlet();
		WebDriver driver = BrowserSelection.getDriver(homeServlet.browser(), homeServlet.bwrPath());
			if(!driver.equals(null)){
				System.out.println("Driver Initiated Successfully.");
			}
		
		driver.get(homeServlet.environmentUrl());
		
		if(!driver.getTitle().equalsIgnoreCase("NPC School Admin")){
			Reporter.log(cm.ReporterText("All the test cases in this suite skipped, The NPC Page did not load. See the screen shot below."));
			cm.captureDriverScreenShot(driver, "NPC_Page_Failure", cm.basepath());
			Reporter.log(cm.ReporterLink("NPC_Page_Failure"));
		}
		return driver;
	}
	
	@Override
	public void browserClose(WebDriver driver){
		Reporter.log(cm.ReporterText("Closing the Browser"));
		driver.quit();
		System.out.println("Driver Closed Successfully.");
	}

	@Override
	public void logHeader(String className) {
		Reporter.log(cm.ReporterText("************************************************************"));
		Reporter.log(cm.ReporterText(""));
		Reporter.log(cm.ReporterText(" ===============  "+className+"  ==============="));
		
	}

	@Override
	public void logFooter() {
	Reporter.log(cm.ReporterText("************************************************************"));
	}

	@Override
	public Alert alertHandler(WebDriver driver) {
		
	return driver.switchTo().alert();
	}

	@Override
	public String controlOfSubDriver(WebDriver driver) {
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		return subWindowHandler; 
		
	}

	@Override
	public String controlOfMainDriver(WebDriver driver) {
		String parentWindowHandler = driver.getWindowHandle(); 
		return parentWindowHandler;
	}
	
	@Override
	public void driverSwitch(WebDriver driver, String Controller, String msg){
		Reporter.log(cm.ReporterText(msg));
		driver.switchTo().window(Controller);
	}

	@Override
	public boolean findCheckboxEnabled(WebDriver driver, List<WebElement> element) {
		boolean flag=false;
		int counter=0, trueFlagCounter=0;
		
		Iterator<WebElement> i = element.iterator(); 
		 while(i.hasNext()) { 
			WebElement anchor = i.next(); 
			if(anchor.isDisplayed()){
				counter=counter+1;
				String name=anchor.getAttribute("name");
				String value=anchor.getAttribute("value");
				Reporter.log(cm.ReporterText(counter+" : "+name+value+" CheckBox Enabled : "+anchor.isEnabled()));
				System.out.println(counter+" : "+name+value+" CheckBox Enabled : "+anchor.isEnabled());
				anchor.click();
				WebElement el=driver.findElement(By.name(name));
				cm.captureElementScreenShot(driver, el, name+value, cm.basepath());
				Reporter.log(cm.ReporterLink(name+value));
				anchor.click();
				if(anchor.isEnabled()==true){
					trueFlagCounter=trueFlagCounter+1;
			 	}
			 }	 
		 } 
		 if(counter==trueFlagCounter){
			 flag=true;
		 }
		 
		return flag;
}

	public void globalSettingsTextBoxValidator_Invalid(WebDriver driver, List<WebElement> element, String txt) {
		String expected=null;
		PackagingPage packagingPage=new PackagingPage().packagingPageElementsInit(driver);
		Iterator<WebElement> i = element.iterator(); 
		 while(i.hasNext()) { 
			WebElement anchor = i.next(); 
			if(anchor.isDisplayed()){
				
				String name=anchor.getAttribute("name");
				String value=anchor.getAttribute("value");
					if(!anchor.isSelected())
					{
					anchor.click();
					}
				WebElement el=driver.findElement(By.name(name.substring(0,name.indexOf("Status"))+"Value["+value+"]"));
				type(el, txt, "Entering Text");
				click(packagingPage.globalSettingsSaveChangesButton, "Clicking on Global Save Changes Button");
					
				
				if(name.contains("Cap")){
					expected="Cap field should be a number.";
				}
				else{
					expected="Floor field should be a number.";
				}
				cm.captureElementScreenShot(driver, packagingPage.validationError, name+value, cm.basepath());
				Reporter.log(cm.ReporterLink(name+value));
				Assert.assertEquals(packagingPage.validationError.getText(), expected);
				el.clear();
				anchor.click();
			 }	 
		 } 
			
}

	
	public void globalSettingsTextBoxValidator_Valid(WebDriver driver, List<WebElement> element, String txt) {
		String expected="Are you sure you want to save?";
		String actual=null;
		PackagingPage packagingPage=new PackagingPage().packagingPageElementsInit(driver);
		Iterator<WebElement> i = element.iterator(); 
		 while(i.hasNext()) { 
			WebElement anchor = i.next(); 
			if(anchor.isDisplayed()){
				
				String name=anchor.getAttribute("name");
				String value=anchor.getAttribute("value");
					if(!anchor.isSelected())
					{
					anchor.click();
					}
				WebElement el=driver.findElement(By.name(name.substring(0,name.indexOf("Status"))+"Value["+value+"]"));
				type(el, txt, "Entering Text");
				click(packagingPage.globalSettingsSaveChangesButton, "Clicking on Global Save Changes Button");
				actual=alertHandler(driver).getText();
				alertHandler(driver).dismiss();
				Reporter.log(cm.ReporterTextBold("ScreenShot Not Taken as Validating PopUP Existence"));
				Assert.assertEquals(actual, expected);
				el.clear();
				anchor.click();
			 }	 
		 } 
			
}
	
	
	@Override
	public void login(WebDriver driver, HomeServlet homeServlet) {
		LoginCredentials loginCred=new LoginCredentials();
		LoginPage loginPage = new LoginPage().loginPageInit(driver);
		AccountSettingsPage accountSettingPage= new AccountSettingsPage().accountSettingsElementsInit(driver);
		
		if(homeServlet.environmentName().equalsIgnoreCase("dev")){
			new CommonOperations().type(loginPage.UserName, loginCred.getNPC_DEV_USERNAME(), "Entering Valid Username.");
			new CommonOperations().type(loginPage.Password, loginCred.getNPC_DEV_PASSWORD(), "Entering Valid Password.");
			new CommonOperations().click(loginPage.LoginButton, "Clicking Login Button");
		} else if(homeServlet.environmentName().equalsIgnoreCase("UAT")){
			new CommonOperations().type(loginPage.UserName, loginCred.getNPC_UAT_USERNAME(), "Entering Valid Username.");
			new CommonOperations().type(loginPage.Password, loginCred.getNPC_UAT_PASSWORD(), "Entering Valid Password.");
			new CommonOperations().click(loginPage.LoginButton, "Clicking Login Button");
		} else if(homeServlet.environmentName().equalsIgnoreCase("Prod")){
			new CommonOperations().type(loginPage.UserName, loginCred.getNPC_PROD_USERNAME(), "Entering Valid Username.");
			new CommonOperations().type(loginPage.Password, loginCred.getNPC_PROD_PASSWORD(), "Entering Valid Password.");
			new CommonOperations().click(loginPage.LoginButton, "Clicking Login Button");
		}
		
		
		
		for (WebElement s1 : accountSettingPage.schoolMaintainence) {
			if(s1.getAttribute("checked")==null && s1.getAttribute("id").equalsIgnoreCase("enableSite2")){
				Reporter.log(cm.ReporterTextBold("Site Not On Hold.  Putting the Site on hold before starting the test case execution."));
				new CommonOperations().click(s1,"Clicking Put Site On Hold Radio Button.");
				new CommonOperations().click(accountSettingPage.SiteOnHoldPopUP_NoThanks,"Clicking on No Thanks Button in the popUP");
				break;
				}
		}
		
	}
	
	public void login(WebDriver driver) {
		HomeServlet homeServlet = new HomeServlet();
		LoginCredentials loginCred=new LoginCredentials();
		LoginPage loginPage = new LoginPage().loginPageInit(driver);
		AccountSettingsPage accountSettingPage= new AccountSettingsPage().accountSettingsElementsInit(driver);
		
		if(homeServlet.environmentName().equalsIgnoreCase("dev")){
			new CommonOperations().type(loginPage.UserName, loginCred.getNPC_DEV_USERNAME(), "Entering Valid Username.");
			new CommonOperations().type(loginPage.Password, loginCred.getNPC_DEV_PASSWORD(), "Entering Valid Password.");
			new CommonOperations().click(loginPage.LoginButton, "Clicking Login Button");
		} else if(homeServlet.environmentName().equalsIgnoreCase("UAT")){
			new CommonOperations().type(loginPage.UserName, loginCred.getNPC_UAT_USERNAME(), "Entering Valid Username.");
			new CommonOperations().type(loginPage.Password, loginCred.getNPC_UAT_PASSWORD(), "Entering Valid Password.");
			new CommonOperations().click(loginPage.LoginButton, "Clicking Login Button");
		} else if(homeServlet.environmentName().equalsIgnoreCase("Prod")){
			new CommonOperations().type(loginPage.UserName, loginCred.getNPC_PROD_USERNAME(), "Entering Valid Username.");
			new CommonOperations().type(loginPage.Password, loginCred.getNPC_PROD_PASSWORD(), "Entering Valid Password.");
			new CommonOperations().click(loginPage.LoginButton, "Clicking Login Button");
		}
		
		
		
		for (WebElement s1 : accountSettingPage.schoolMaintainence) {
			if(s1.getAttribute("checked")==null && s1.getAttribute("id").equalsIgnoreCase("enableSite2")){
				Reporter.log(cm.ReporterTextBold("Site Not On Hold.  Putting the Site on hold before starting the test case execution."));
				new CommonOperations().click(s1,"Clicking Put Site On Hold Radio Button.");
				new CommonOperations().click(accountSettingPage.SiteOnHoldPopUP_NoThanks,"Clicking on No Thanks Button in the popUP");
				break;
				}
		}
		
	}

	@Override
	public String getFirstSelectedDropDown(WebElement element) {
		String txt=null;
		if(cm.waiters(element)){
		Select select=new Select(element);
		txt=select.getFirstSelectedOption().getText();
		}
		return txt;
	}

	@Override
	public String switchingAidYear(WebDriver driver) {
		String testData=null;
		AccountSettingsPage accountSettingPage=new AccountSettingsPage().accountSettingsElementsInit(driver);
		String aidYearText =new CommonOperations().getFirstSelectedDropDown(accountSettingPage.aidYear);
		if(aidYearText.equalsIgnoreCase("2015-16")){
			testData="2016-17";
			new CommonOperations().selectDropDown(accountSettingPage.aidYear,"2016-17", "Selecting 2016-17 as Aid Year");
		}
		else if (aidYearText.equalsIgnoreCase("2016-17")){
			testData="2015-16";
			new CommonOperations().selectDropDown(accountSettingPage.aidYear, "2015-16", "Selecting 2015-16 as Aid Year");
		}

		return testData;
	}

	@Override
	public void signOut(WebDriver driver) {
		HomePage homePage = new HomePage().homePageInit(driver);
		if(cm.waiters(homePage.SignOutLink)){
		new CommonOperations().click(homePage.SignOutLink, "Clicking on Signout Link");
		}
	}
	
	@Override
	public void deletePreviewTestCase(WebDriver driver, WebElement element, boolean flag){
		Reporter.log(cm.ReporterText("Deleting the Test Case Created"));
		try{
			element.click();
		}catch (Exception e) {
			
		}
		
		Add_N_Edit_TestCasePage add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);;
		new CommonOperations().click(add_N_Edit_testCasePage.deleteButton,"Clicking on Delete Button in Edit Test Case page.");
		new CommonOperations().alertHandler(driver).accept();
		flag=false;
		Reporter.log(cm.ReporterText("-----------------------------------------------"));
		Reporter.log(cm.ReporterText(""));
	}
	
	
	public void deleteCOAExpense(WebDriver driver){
		CostOfAttendancePage coaPage= new CostOfAttendancePage().COAPageInit(driver);
			for(int i=2;i<coaPage.coaFixedRows.size();i++){
					WebElement el=driver.findElement(By.xpath("//table[@id='myRuleTable']//tr["+i+"]//td[5]"));
					new CommonOperations().click(el, "Clicking On Delete Image in Edit Expense Page.");
			}
		
		new CommonOperations().click(coaPage.saveChangesButton, "Clicking on Save Changes button in Edit Expense page.");
		new CommonOperations().alertHandler(driver).accept();
	}
	
	public int elementSize(List<WebElement> element){
		return element.size();
	}
	
	
	
	public void deleteAssignmentPackages(WebDriver driver){
		WebElement el=null;
		PackagingPage packagingPage=new PackagingPage().packagingPageElementsInit(driver);
		int size=packagingPage.assignmentPackageList.size();
		for(int i=0;i<size;i++){	
			el=driver.findElement(By.xpath("//li[@id='list"+i+"']//table//tr//td[2]"));
			if(el.getText().contains("Factor")){
				el=driver.findElement(By.xpath("//li[@id='list"+i+"']//table//tr//td[5]"));
				}
			else{
				el=driver.findElement(By.xpath("//li[@id='list"+i+"']//table//tr//td[4]"));
				}
			click(el,"Deleting the existing list");
		}
	}
	
	
	public void fillingStudentInformationPage(WebDriver driver){
		String subDriver=controlOfSubDriver(driver);
		driverSwitch(driver, subDriver, "Giving the Driver Control to the SubDriver.");
		
		TestCaseStudentPage tCStudentPage=new TestCaseStudentPage().studentTestCasePageInit(driver);
		click(tCStudentPage.EnterAsGuestLink, "Clicking Enter as Guest Link.");
		type(tCStudentPage.studentFirstName, "SeleniumTesting", "Entering Student Name.");
		selectDropDown(tCStudentPage.studentCompletingCalculator, "Student", "Selecting Student as Completing the Calculator.");
		selectDropDown(tCStudentPage.studentBirthYear, "1995", "Selecting 1995 as Student Birth Year.");
		selectDropDown(tCStudentPage.studentGradeYearCode, "2nd yr college", "Selecting 2nd yr college as Student Grade Year.");
		selectDropDown(tCStudentPage.studentResidencyStateCode, "Alabama", "Selecting Alabama as Student Residency State Code.");
		selectDropDown(tCStudentPage.studentMaritalStatusCode, "Single", "Selecting Single as Student Marital Status.");
		selectDropDown(tCStudentPage.studentHousingCode, "On campus", "Selecting On Campus as Student Housing Code.");
		click(tCStudentPage.NextButton, "Clicking Next Button");
		
		tCStudentPage=new TestCaseStudentPage().studentTestCasePageInit(driver);
		
		selectDropDown(tCStudentPage.parentMaritalStatusCode, "Remarried", "Selecting Remarried as Parental Marital Status Code.");
		selectDropDown(tCStudentPage.parentBirthYear, "1980", "Selecting 1980 as Parental Birth Year.");
		selectDropDown(tCStudentPage.parentResidencyStateCode, "Alaska", "Selecting Alaska as Parental Residency State Code.");
		selectDropDown(tCStudentPage.parentHouseholdCount, "4", "Selecting 4 as Parental Household Count.");
		selectDropDown(tCStudentPage.parentHouseholdCollegeCount, "2", "Selecting 2 as Parental Household College Count.");
		selectDropDown(tCStudentPage.parentTaxFormCode, "1040A", "Selecting 1040A as Parental Tax Form Code.");
		type(tCStudentPage.parentAnnualGrossIncome, "15000", "Entering Parent Annual Gross Income.");
		click(tCStudentPage.NextButton, "Clicking Next Button");
		
		String subSubDriver=controlOfSubDriver(driver);
		driverSwitch(driver, subSubDriver, "Giving the Driver Control to the Sub SubDriver.");
		
		click(tCStudentPage.confirmHouseHoldNextButton, "Clicking on Next Button in Household Page.");
		driverSwitch(driver, subDriver, "Giving the Driver Control to the SubDriver.");
		driver.close();
		
	}
	
	public boolean deleteTestCase(WebDriver driver, String testData){
		boolean flag;
		WebElement element;
		HomePage homePage = new HomePage().homePageInit(driver);
		Add_N_Edit_TestCasePage add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
			
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		click(homePage.previewLink, "Clicking on the Preview link.");
		element=driver.findElement(By.xpath("//table[@id='preview-list']//a[contains(.,'"+testData+"')]"));
		element.click();
		Reporter.log(cm.ReporterText("Deleting the Test Case Created"));
		click(add_N_Edit_testCasePage.deleteButton,"Clicking on Delete Button in Edit Test Case page.");
		alertHandler(driver).accept();
		flag=false;
		Reporter.log(cm.ReporterText("-----------------------------------------------"));
		Reporter.log(cm.ReporterText(""));
		return flag;
	}
	
	public boolean addTestCase(WebDriver driver, String testData){
		boolean flag;
		HomePage homePage = new HomePage().homePageInit(driver);
		SchoolPreviewPage schoolPreviewPage=new SchoolPreviewPage().schoolPreviewPageElementsInit(driver);
		Add_N_Edit_TestCasePage add_N_Edit_testCasePage=new Add_N_Edit_TestCasePage().globalElementsInit(driver);
		
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		click(homePage.previewLink, "Clicking on the Preview link.");
		click(schoolPreviewPage.addTestCaseButton, "Clicking add test case Button in the School Preview page.");
		
		type(add_N_Edit_testCasePage.nameEditBox, testData, "Entering Test Data in the Name Edit Box in the Add Test Case Page.");
		click(add_N_Edit_testCasePage.saveButton, "Clicking Save button in the Add Test Case Page.");
		flag=true;
		
		return flag;
	}
	
	
	public String selectingPageConfigurationImageCancel(WebDriver driver,String testData1, String testData2){
		String expected=null;
		PageConfigurationsPage pageConfig=new PageConfigurationsPage().pageConfigurationsInit(driver);
	
		if(getFirstSelectedDropDown(pageConfig.bubbleImageOne).contains(testData1)){
			expected=testData1;
			selectDropDown(pageConfig.bubbleImageOne, testData2, "Selecting Image "+testData2+" as Bubble One Image.");
			}
		else{
			expected=testData2;
			selectDropDown(pageConfig.bubbleImageOne, testData1, "Selecting Image "+testData1+" as Bubble One Image.");
			}
		return expected;
	}
	
	public String selectingPageConfigurationImageSave(WebDriver driver,String testData1, String testData2){
		String expected=null;
		PageConfigurationsPage pageConfig=new PageConfigurationsPage().pageConfigurationsInit(driver);
	
		if(getFirstSelectedDropDown(pageConfig.bubbleImageOne).contains(testData1)){
			expected=testData2;
			selectDropDown(pageConfig.bubbleImageOne, testData2, "Selecting Image "+testData2+" as Bubble One Image.");
			}
		else{
			expected=testData1;
			selectDropDown(pageConfig.bubbleImageOne, testData1, "Selecting Image "+testData1+" as Bubble One Image.");
			}
		return expected;
	}
	
	public boolean createNewNextStep(WebDriver driver, String testData){
		boolean flag=false;
		NextStepsPage nextStepPage=new NextStepsPage().nextStepInit(driver);
		type(nextStepPage.taskNameTxtBox, testData, "Typing Task Name.");
		type(nextStepPage.displayTxtBox, testData, "Typing Display Name.");
		selectDropDown(nextStepPage.displayOptions, "Display as PopUp", "Selecting Display as PopUp.");
		flag=true;
		return flag;
	}
	
	public boolean deleteNextStep(WebDriver driver, String testData){
		boolean flag=false;
		NextStepsPage nextStepPage=new NextStepsPage().nextStepInit(driver);
		click(nextStepPage.deleteButton, "Clicking on Delete Button.");
		alertHandler(driver).accept();
		return flag;
	}
	
	public void pause(int msTimer){
		try {
			Thread.sleep(msTimer);
		} catch (Exception e) {
		}
	}
	
}