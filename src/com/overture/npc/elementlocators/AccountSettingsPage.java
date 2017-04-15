package com.overture.npc.elementlocators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage {
	
	 @FindBy(id="aidYear")
	 @CacheLookup
	 public WebElement aidYear;
	 
	 
	 @FindBy(xpath="//input[@value='Save Changes']")
	 @CacheLookup
	 public WebElement saveChanges;
	 
	 @FindBy(xpath="//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement cancel;
	 
	 @FindBy(xpath="//div[@class='errorMessage']")
	 @CacheLookup
	 public WebElement message;
	 
	 @FindBy(name="calcRounding")
	 @CacheLookup
	 public List<WebElement> calcRoundingRadioButton;
	 
	 @FindBy(xpath="//table[@class='widePlainTable']//td[contains(.,'Calculation Rounding')]")
	 @CacheLookup
	 public WebElement calcRoundingRow;
	 
	 @FindBy(name="enableSite")
	 @CacheLookup
	 public List<WebElement> schoolMaintainence;
	 
	 @FindBy(id="enableSite1")
	 @CacheLookup
	 public WebElement enableSite;
	 
	 @FindBy(id="enableSite2")
	 @CacheLookup
	 public WebElement PutSiteOnHold;
	 
	 @FindBy(id="defaultContent")
	 @CacheLookup
	 public WebElement SiteOnHoldPopUP;
	 
	 @FindBy(xpath="//div[@class='submit-btns']//input[@value='No thanks, close the window']")
	 @CacheLookup
	 public WebElement SiteOnHoldPopUP_NoThanks;
	 
	 
	 @FindBy(id="redirect")
	 @CacheLookup
	 public WebElement SiteOnHoldPopUP_ReDirect;
	 
	 @FindBy(xpath="//button[contains(.,'No')]")
	 @CacheLookup
	 public WebElement SaveChangesPopUpNo;
	
	 @FindBy(xpath="//button[contains(.,'Yes')]")
	 @CacheLookup
	 public WebElement SaveChangesPopUpYes;
	 
	 @FindBy(xpath="//div//h6")
	 @CacheLookup
	 public WebElement SaveChangesPopUpText;
	 
	 public AccountSettingsPage accountSettingsElementsInit(WebDriver driver){
		 System.out.println("Initiating Account Settings Page Elements.");
    	return PageFactory.initElements(driver, AccountSettingsPage.class);
    }
    

}
