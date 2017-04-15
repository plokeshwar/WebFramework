package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NextStepsPage {
	
	 @FindBy(xpath = "//ul[@id='taskList']")
	 @CacheLookup
	 public WebElement nextStepTable;
	
	 @FindBy(xpath = "//ul[@id='taskList']//a")
	 @CacheLookup
	 public WebElement singleAnchorLink;
	 
	 @FindBy(xpath = "//div[@id='main']/form/div/input[2]")
	 @CacheLookup
	 public WebElement createNewNextStepBtn;
	
	 @FindBy(xpath = "//form[@id='taskForm']/p[1]")
	 @CacheLookup
	 public WebElement alertText;
	 
	 // Edit Next Step Web Elements
	
	 @FindBy(xpath = "//input[@id='code']")
	 @CacheLookup
	 public WebElement taskNameTxtBox;
	 
	 @FindBy(xpath = "//input[@id='label']")
	 @CacheLookup
	 public WebElement displayTxtBox;
	 
	 @FindBy(xpath = "//select[@id='openNewWindow']")
	 @CacheLookup
	 public WebElement displayOptions;
	
	 @FindBy(xpath = "//form[@id='taskForm']/table/tbody/tr[6]/td[2]/table")
	 @CacheLookup
	 public WebElement assignByPopulationTable;
	 
	 @FindBy(xpath = "//select[@id='box1View']")
	 @CacheLookup
	 public WebElement populationListBox;
	 
	 @FindBy(xpath = "//select[@id='box1View']/option")
	 @CacheLookup
	 public WebElement populationListBoxOptionValue;
	 	
	 @FindBy(xpath = "//select[@id='box1View']/option[contains(.,'Everyone')]")
	 @CacheLookup
	 public WebElement populationListBoxOptionValue_Everyone;
	 
	 @FindBy(xpath = "//button[@id='to2']")
	 @CacheLookup
	 public WebElement transferToAssignedTableButton;
	 
	 @FindBy(xpath = "//button[@id='to1']")
	 @CacheLookup
	 public WebElement transferToPopulationListTBoxButton;
	 
	 @FindBy(xpath = "//select[@id='box2View']")
	 @CacheLookup
	 public WebElement assignedListBox;
	 
	 @FindBy(xpath = "//select[@id='box2View']/option")
	 @CacheLookup
	 public WebElement assignedListBoxOptionValue;
	 
	 @FindBy(xpath = "//select[@id='box2View']/option[contains(.,'Everyone')]")
	 @CacheLookup
	 public WebElement assignedListBoxOptionValue_Everyone;
	 
	 @FindBy(xpath = "//ul[@id='taskList']//a[contains(.,'Complete Your FAFSA')]")
	 @CacheLookup
	 public WebElement completeFAFSALink;
	 
	 @FindBy(xpath = "//p[@class='submit']//input[@value='Save Changes']")
	 @CacheLookup
	 public WebElement saveChangesButton;
	 
	 @FindBy(xpath = "//p[@class='submit']//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement cancelButton;
	 
	 @FindBy(xpath = "//p[@class='submit']//input[@value='Delete']")
	 @CacheLookup
	 public WebElement deleteButton;
	 
	 public NextStepsPage nextStepInit(WebDriver driver){
		 System.out.println("Initiating Next Steps Page Elements.");
    	return PageFactory.initElements(driver, NextStepsPage.class);
    }
    

}
