package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionsPage {
	
	 @FindBy(xpath="//table[@id='categoryTable']")
	 @CacheLookup
	 public WebElement questionTable;
	 
	 @FindBy(xpath="//table[@id='categoryTable']//a[contains(.,'Student Information')]")
	 @CacheLookup
	 public WebElement studentInformationLink;
	 
	 @FindBy(xpath="//table[@id='categoryTable']//a[contains(.,'Parent Household')]")
	 @CacheLookup
	 public WebElement parentHouseholdLink;
	 
	 @FindBy(xpath="//table[@id='categoryTable']//a[contains(.,'Parent Income')]")
	 @CacheLookup
	 public WebElement parentIncomeLink;
	 
	 @FindBy(xpath="//table[@id='categoryTable']//a[contains(.,'Parent Assets')]")
	 @CacheLookup
	 public WebElement parentAssetLink;
	 
	 @FindBy(xpath="//table[@id='categoryTable']//a[contains(.,'Student Finances')]")
	 @CacheLookup
	 public WebElement studentFinancesLink;
	 
	 @FindBy(xpath="//a[contains(.,'Manage Custom Lists')]")
	 @CacheLookup
	 public WebElement manageCustomButton;
	 
	 
	 public QuestionsPage globalElementsInit(WebDriver driver){
		System.out.println("Initiating Questions Page Elements.");
    	return PageFactory.initElements(driver, QuestionsPage.class);
    }
    

}
