package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConfigurationsPage {
	
	 @FindBy(xpath = "//div[@class='outlineBox']//input[@type='file']")
	 @CacheLookup
	 public WebElement browseButton;
	
	 @FindBy(xpath = "//div[@class='outlineBox']//input[@type='submit']")
	 @CacheLookup
	 public WebElement uploadButton;
	
	 @FindBy(xpath = "//div[@class='outlineBox']//div[@class='errorMessage']")
	 @CacheLookup
	 public WebElement errorMessage;
	 
	 @FindBy(xpath = "//div[@id='main']//img")
	 @CacheLookup
	 public WebElement logo;
	 
	 @FindBy(id="cohortAidPercent")
	 @CacheLookup
	 public WebElement cohortAidText;
	 
	 @FindBy(id="stateGrant")
	 @CacheLookup
	 public WebElement stateGrantText;

	 @FindBy(id="instGrant")
	 @CacheLookup
	 public WebElement institutionalGrantText;
	 
	 @FindBy(id="instScholarship")
	 @CacheLookup
	 public WebElement instScholarshipText;
	 
	 @FindBy(id="consolidatedSelfHelp")
	 @CacheLookup
	 public WebElement consolidateSelfHelpText;
	 
	 @FindBy(id="consolidatedSelfHelp")
	 @CacheLookup
	 public WebElement schoolDefinedFund1Text;
	 
	 
	 @FindBy(id="consolidatedSelfHelp")
	 @CacheLookup
	 public WebElement schoolDefinedFund2Text;
	
	 @FindBy(xpath="//b[contains(.,'School Logo')]")
	 @CacheLookup
	 public WebElement schoolLogoText;
	 
	 @FindBy(xpath="//b[contains(.,'Image Selection')]")
	 @CacheLookup
	 public WebElement imageSelectionText;
	 
	 @FindBy(xpath="//b[contains(.,'Percent Grant Aid')]")
	 @CacheLookup
	 public WebElement percentGrantAidText;
	 
	 @FindBy(xpath="//b[contains(.,'My Net Price')]")
	 @CacheLookup
	 public WebElement myNetPriceText;
	 
	 @FindBy(xpath="//b[contains(.,'My Resources')]")
	 @CacheLookup
	 public WebElement myResourcesText;
	 
	 @FindBy(xpath="//b[contains(.,'EFC/Grant Aid Display')]")
	 @CacheLookup
	 public WebElement grantAidDisplayText;
	 
	 @FindBy(id="configurationForm")
	 @CacheLookup
	 public WebElement formName;
	 

	 @FindBy(id="bubble1")
	 @CacheLookup
	 public WebElement bubbleImageOne;
	 
	 @FindBy(id="img_bubble1")
	 @CacheLookup
	 public WebElement bubbleOneImageID;
	 

	 @FindBy(id="bubble2")
	 @CacheLookup
	 public WebElement bubbleImageTwo;
	 
	 @FindBy(id="img_bubble2")
	 @CacheLookup
	 public WebElement bubbleTwoImageID;
	 
	 
	 @FindBy(xpath="//input[@value='Save Changes']")
	 @CacheLookup
	 public WebElement saveChangesButton;
	 
	 @FindBy(xpath="//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement cancelButton;
	 
	 public PageConfigurationsPage pageConfigurationsInit(WebDriver driver){
		System.out.println("Initiating Page Configuration Page Elements.");
    	return PageFactory.initElements(driver, PageConfigurationsPage.class);
    }
    

}
