package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	/*Account Tab and related links*/
	
	@FindBy(xpath = "//div[@id='menuTabs']//li[1]/a")
	@CacheLookup
	public WebElement accountTab;

	@FindBy(xpath = "//div[@id='menuTabs-1']")
	@CacheLookup
	public WebElement accountTable;
	
	@FindBy(xpath = "//div[@id='menuTabs-1']/a[1]")
	@CacheLookup
	public WebElement accountSettingsLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-1']//a[contains(.,'Calculation Report')]")
	@CacheLookup
	public WebElement calculationReportLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-1']/a[3]")
	@CacheLookup
	public WebElement trafficSummaryLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-1']/a[4]")
	@CacheLookup
	public WebElement previewLink;
	
	/*Net Price Tab and related links*/
	
	@FindBy(xpath = "//div[@id='menuTabs']//li[2]/a")
	@CacheLookup
	public WebElement netPriceTab;

	@FindBy(xpath = "//div[@id='menuTabs-2']")
	@CacheLookup
	public WebElement netPriceTable;
	
	@FindBy(xpath = "//div[@id='menuTabs-2']//a[contains(.,'Questions')]")
	@CacheLookup
	public WebElement questionsLink;

	@FindBy(xpath = "//div[@id='menuTabs-2']//a[contains(.,'Populations')]")
	@CacheLookup
	public WebElement populationsLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-2']//a[contains(.,'Tables')]")
	@CacheLookup
	public WebElement tablesLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-2']//a[contains(.,'COA')]")
	@CacheLookup
	public WebElement COALink;
	
	@FindBy(xpath = "//div[@id='menuTabs-2']//a[contains(.,'Packaging')]")
	@CacheLookup
	public WebElement packagingLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-2']//a[contains(.,'School Computed Values')]")
	@CacheLookup
	public WebElement schoolComputedValuesLink;
	
	/*Content Management Tab and related links*/
	
	@FindBy(xpath = "//div[@id='menuTabs']//li[3]/a")
	@CacheLookup
	public WebElement contentManagmentTab;
	
	@FindBy(xpath = "//div[@id='menuTabs']//ul[@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']//a[@href='#menuTabs-3']")
	@CacheLookup
	public WebElement contentManagmentTabSample;
	

	@FindBy(xpath = "//div[@id='menuTabs-3']")
	@CacheLookup
	public WebElement contentManagmentTabTable;
	
	@FindBy(xpath = "//div[@id='menuTabs-3']//a[contains(.,'Page Configurations')]")
	@CacheLookup
	public WebElement pageConfigurationsLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-3']//a[contains(.,'Content Editor')]")
	@CacheLookup
	public WebElement contentEditorLink;
	
	@FindBy(xpath = "//div[@id='menuTabs-3']//a[contains(.,'Next Steps')]")
	@CacheLookup
	public WebElement nextStepsLink;
	
	@FindBy(xpath = "//div[@id='header']//a[contains(.,'Sign Out')]")
	 @CacheLookup
	public WebElement SignOutLink;
	
	@FindBy(xpath = "//div[@id='header']//a[contains(.,'Change Password')]")
	@CacheLookup
	public WebElement ChangePasswordLink;
	
	@FindBy(xpath="//div[@class='pageTit']")
	@CacheLookup 
	public WebElement pageTitle;
	
	@FindBy(xpath = "//div[@id='packagingtabs']")
	@CacheLookup 
	public WebElement packagingtabs;
	
	public HomePage homePageInit(WebDriver driver) {
		System.out.println("Initiating Home Page Elements.");
		return PageFactory.initElements(driver, HomePage.class);
	}
}
