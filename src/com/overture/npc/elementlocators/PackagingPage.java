package com.overture.npc.elementlocators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackagingPage {
	
	 //======= Packaging Tab Elements
	 
	 @FindBy(xpath="//div[@id='packagingtabs']//a[contains(.,'Packaging')]")
	 @CacheLookup
	 public WebElement packagingTabLink;
	 
	 @FindBy(xpath="//div[@id='menuTabs-11']")
	 @CacheLookup
	 public WebElement packagingTable;
	 
	 @FindBy(xpath="//ul[@id='packageList']//input[@name='activeStatuses']")
	 @CacheLookup
	 public List<WebElement> nonDefaultPackageList;
	 
	 @FindBy(id="unsortableList")
	 @CacheLookup
	 public WebElement defaultPackageList;
	 
	 @FindBy(xpath="//div[@id='menuTabs-11']//input[@value='Save Changes']")
	 @CacheLookup
	 public WebElement packagingTabSaveChangesButton;
	 
	 @FindBy(xpath="//div[@id='menuTabs-11']//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement packagingTabCancelButton;
	 
	 @FindBy(xpath="//ul[@id='unsortableList']/li[contains(.,'Parent Contribution')]/table/tbody/tr/td[4]")
	 @CacheLookup
	 public WebElement parentContributionActiveStatus;
	 
	 @FindBy(xpath="//ul[@id='unsortableList']/li[contains(.,'Student Contribution')]/table/tbody/tr/td[4]")
	 @CacheLookup
	 public WebElement studentContributionActiveStatus;
	 
	 @FindBy(xpath="//ul[@id='unsortableList']/li[contains(.,'Pell Grant')]/table/tbody/tr/td[4]")
	 @CacheLookup
	 public WebElement pellGrantActiveStatus;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Parent Contribution')]")
	 @CacheLookup
	 public WebElement parentContributionLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Contribution')]")
	 @CacheLookup
	 public WebElement studentContributionLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Pell Grant')]")
	 @CacheLookup
	 public WebElement pellGrantLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Work')]")
	 @CacheLookup
	 public WebElement studentWorkLink;
	
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional  Grant - A')]")
	 @CacheLookup
	 public WebElement institutional_Grant_ALink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'State Grant - A')]")
	 @CacheLookup
	 public WebElement state_Grant_ALink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Loan - A')]")
	 @CacheLookup
	 public WebElement student_Loan_ALink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Parent Loan')]")
	 @CacheLookup
	 public WebElement parent_LoanLink;
	 

	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Consolidated Self Help')]")
	 @CacheLookup
	 public WebElement consolidated_Self_HelpLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional Scholarship - B')]")
	 @CacheLookup
	 public WebElement institutional_Scholarship_BLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional Scholarship - A')]")
	 @CacheLookup
	 public WebElement institutional_Scholarship_ALink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional  Grant - B')]")
	 @CacheLookup
	 public WebElement institutional_Grant_BLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'State Grant - B')]")
	 @CacheLookup
	 public WebElement state_Grant_BLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Loan - B')]")
	 @CacheLookup
	 public WebElement student_Loan_BLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional Scholarship - C')]")
	 @CacheLookup
	 public WebElement institutional_Scholarship_CLink;
	
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Institutional  Grant - C')]")
	 @CacheLookup
	 public WebElement institutional_Grant_CLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'State Grant - C')]")
	 @CacheLookup
	 public WebElement stateGrant_CLink;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'Student Loan - C')]")
	 @CacheLookup
	 public WebElement student_Loan_CLink;
	
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'School Defined Fund1')]")
	 @CacheLookup
	 public WebElement school_Defined_Fund1Link;
	 
	 @FindBy(xpath="//table[@class='packageTable']//span[@class='fakeLink' and contains(.,'School Defined Fund2')]")
	 @CacheLookup
	 public WebElement school_Defined_Fund2Link;
	
		
	 @FindBy(xpath="//div[@class='packageCategory']//li")
	 @CacheLookup
	 public List<WebElement> assignmentPackageList;
		
		
		
		
	
		
		
		
	 
	
	 
	 
	
	 
	 //======= Global Settings Tab Elements
	 
	 @FindBy(xpath="//div[@id='jsValidationArea']")
	 @CacheLookup
	 public WebElement validationError;
	 
	 @FindBy(xpath="//div[@id='packagingtabs']//a[contains(.,'Global Settings')]")
	 @CacheLookup
	 public WebElement globalSettingsTabLink;
	 
	 @FindBy(xpath="//div[@id='menuTabs-12']")
	 @CacheLookup
	 public WebElement globalSettingsTable;
	 
	 @FindBy(xpath="//div[@id='menuTabs-12']//input[@value='Save Changes']")
	 @CacheLookup
	 public WebElement globalSettingsSaveChangesButton;
	 
	 @FindBy(xpath="//div[@id='menuTabs-12']//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement globalSettingsCancelButton;
	 
	 @FindBy(xpath="//div[@id='menuTabs-12']//div[@class='pageTit']")
	 @CacheLookup
	 public WebElement globalSettingsPageTitle;
	 
	 @FindBy(name="globalCapStatus")
	 @CacheLookup
	 public List<WebElement> globalSettingsGlobalCapList;
	 
	 @FindBy(name="globalFloorStatus")
	 @CacheLookup
	 public List<WebElement> globalSettingsGlobalFloorList;
	 
	
	
	
	 
	 //Edit Packaging
	 
	 	@FindBy(xpath="//span[@class='packageAdder' and contains(.,'Fixed')]")
		@CacheLookup
		public WebElement fixedLink;

	 	@FindBy(xpath="//span[@class='packageAdder' and contains(.,'Factor of')]")
		@CacheLookup
		public WebElement factorLink;
	 	
	 	@FindBy(xpath="//span[@class='packageAdder' and contains(.,'Value from Table')]")
		@CacheLookup
		public WebElement ValueTableLink;

		@FindBy(xpath="//div[@class='pageTitle' and contains(.,'Edit Packaging')]//span[@id='packageName']")
		@CacheLookup
		public WebElement pageTitle;
		
		
		@FindBy(xpath="//li[@id='list0']//tr//td[2]")
		@CacheLookup
		public WebElement newRow;
		
		@FindBy(xpath="//div[@class='saveButtonDiv']//input[@value='Save Changes']")
		@CacheLookup
		public WebElement editPackageSaveButton;
		
		
		@FindBy(xpath="//div[@class='saveButtonDiv']//input[@value='Cancel']")
		@CacheLookup
		public WebElement editPackageCancelButton;
		
		
		
		
		@FindBy(xpath="//table[@class='packEditTable']//tr//td[3]//input")
		@CacheLookup
		public WebElement editPackageInputField;
		
		
	 
	 public PackagingPage packagingPageElementsInit(WebDriver driver){
		System.out.println("Initiating Packaging Page Elements.");
    	return PageFactory.initElements(driver, PackagingPage.class);
    }
    

}
