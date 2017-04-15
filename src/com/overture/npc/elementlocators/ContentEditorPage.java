package com.overture.npc.elementlocators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContentEditorPage {
	
	 @FindBy(xpath = "//table[@id='categoryTable']")
	 @CacheLookup
	 public WebElement contentTable;
	
	 @FindBy(xpath = "//td[@class='listPage col1']")
	 @CacheLookup
	 public WebElement pageNameTable;
	 
	 @FindBy(xpath = "//table[@id='categoryTable']//td[@class='listPage']")
	 @CacheLookup
	 public WebElement listPageTable;
	 
	 @FindBy(xpath = "//table[@id='categoryTable']//td[@class='listPage']//a")
	 @CacheLookup
	 public List<WebElement> linkListPageTable;
	 
	 @FindBy(id="text_ifr")
	 @CacheLookup
	 public WebElement frameID;
	 
	 @FindBy(xpath="//td[@class='listPage']//p[@class='newWindow']")
	 @CacheLookup
	 public List<WebElement> viewDefaultList;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Common Across All Pages')]")
	 @CacheLookup
	 public WebElement commonAcrossAllPage;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'NPC Welcome Page')]")
	 @CacheLookup
	 public WebElement npcWelcomePage;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Student Information Page')]")
	 @CacheLookup
	 public WebElement studentInfoPage;
	 
	
	 @FindBy(xpath = "//td[@class='listPage']//a")
	 @CacheLookup
	 public WebElement singleAnchorLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Parent Household Information')]")
	 @CacheLookup
	 public WebElement parentHouseholdInfo;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Parent Income Information')]")
	 @CacheLookup
	 public WebElement parentIncomeInfo;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Parent Assets Information')]")
	 @CacheLookup
	 public WebElement parentAssetsInfo;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Student Finances (& Household) Information')]")
	 @CacheLookup
	 public WebElement studentFinancesInfo;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Need Help')]")
	 @CacheLookup
	 public WebElement needHelpLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Please Read')]")
	 @CacheLookup
	 public WebElement pleaseReadLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Terms & Conditions')]")
	 @CacheLookup
	 public WebElement termsLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'My Estimated Net Price')]")
	 @CacheLookup
	 public WebElement estimatedNetPriceLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'My Information')]")
	 @CacheLookup
	 public WebElement myInformationLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'My Next Steps')]")
	 @CacheLookup
	 public WebElement myNextStepsLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'My Resources')]")
	 @CacheLookup
	 public WebElement myResourcesLink;
	 
	 @FindBy(xpath = "//td[@class='listPage col1']//a[contains(.,'Maintenance Page')]")
	 @CacheLookup
	 public WebElement maintainancePageLink;
	 
	 /* Common Across All Pages link */
	 
	 @FindBy(xpath = "//span[@id='ui-dialog-title-popUpArea']")
	 @CacheLookup
	 public WebElement popUpHeaderCommonAAP;
	
	 @FindBy(xpath = "//span[@class='ui-icon ui-icon-closethick']")
	 @CacheLookup
	 public WebElement popUpCloseCommonAAP;
	 
	/* @FindBy(xpath = "//p[@id='subscriber_common_header']")
	 @CacheLookup
	 public WebElement viewDefaultLinkCommonAAP;*/
	 
	 @FindBy(xpath = "//span[@id='ui-dialog-title-dialog']")
	 @CacheLookup
	 public WebElement viewDefaultPopUpHeaderCommonAAP;
	 
	 @FindBy(xpath = "//span[@class='ui-icon ui-icon-closethick']")
	 @CacheLookup
	 public WebElement viewDefaultPopUpCloseCommonAAP;
	 
	 @FindBy(xpath = "//body[@id='tinymce']")
	 @CacheLookup
	 public WebElement contentRegionNamePopUpBody;
	
	 @FindBy(xpath = "//body[@id='tinymce']/p")
	 @CacheLookup
	 public WebElement contentRegionNamePopUpParagraph;
	 
	 @FindBy(xpath = "//form[@id='subscriberContent']/div/input")
	 @CacheLookup
	 public WebElement contentRegionNamePopUpButton;
	
	 @FindBy(xpath = "//td[@class='listPage']/table/tbody/tr[2]/td[1]/a")
	 @CacheLookup
	 public WebElement schoolNameCommonAAP;
	 	 
	 @FindBy(xpath = "//td[@class='listPage']/table/tbody/tr[3]/td[1]/a")
	 @CacheLookup
	 public WebElement npcUrlCommonAAP;
	 
	 /* My Estimated Net Price Links and Associated Web Elements */
	 
	 @FindBy(xpath = "//div[@id='categoryTable']/div[@class='popHeader']")
	 @CacheLookup
	 public WebElement popHeaderPopulationContent;
	 
	 @FindBy(id = "ui-dialog-title-popUpArea")
	 @CacheLookup
	 public List<WebElement> popUpHeaderCount;
	 
	 public ContentEditorPage contentEditorInit(WebDriver driver){
		 System.out.println("Initiating Content Editor Page Elements.");
    	return PageFactory.initElements(driver, ContentEditorPage.class);
    }
    

}
