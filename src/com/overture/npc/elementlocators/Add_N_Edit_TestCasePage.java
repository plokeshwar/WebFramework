package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_N_Edit_TestCasePage {
	
	
	 
	 @FindBy(xpath="//form[@id='testFile']//input[@id='name']")
	 @CacheLookup
	 public WebElement nameEditBox;
	 
	 @FindBy(xpath="//form[@id='testFile']//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement cancelButton;
	 
	 @FindBy(xpath="//form[@id='testFile']//input[@value='Save']")
	 @CacheLookup
	 public WebElement saveButton;
	 
	 @FindBy(xpath="//form[@id='testFile']//span[@id='name.errors']")
	 @CacheLookup
	 public WebElement errorMessage;
	 
	 @FindBy(xpath="//div[@class='subHeader']")
	 @CacheLookup
	 public WebElement subHeader;
	 
	 @FindBy(xpath="//input[@value='Delete']")
	 @CacheLookup
	 public WebElement deleteButton;
	 
	 
	 
	 
	 public Add_N_Edit_TestCasePage globalElementsInit(WebDriver driver){
		System.out.println("Initiating Test Case ADD and EDIT Page Elements.");
    	return PageFactory.initElements(driver, Add_N_Edit_TestCasePage.class);
    }
    

}
