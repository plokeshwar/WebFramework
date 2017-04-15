package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentInformationPage {
	
	 @FindBy(id="categoryTable")
	 @CacheLookup
	 public WebElement questionTable;
	 
	 // Accordion
	 /*WebElements for Header Links */
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'General')]")
	 @CacheLookup
	 public WebElement generalHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Academics')]")
	 @CacheLookup
	 public WebElement academicsHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Activities')]")
	 @CacheLookup
	 public WebElement activitiesHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Faith')]")
	 @CacheLookup
	 public WebElement faithHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Family')]")
	 @CacheLookup
	 public WebElement familyHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Campuses and Schools')]")
	 @CacheLookup
	 public WebElement campusesHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Upperclass and Transfer Students')]")
	 @CacheLookup
	 public WebElement upperClassHeaderLink;
	 
	 @FindBy(xpath="//table[@id='questionTable']//span[contains(.,'Other School Specific')]")
	 @CacheLookup
	 public WebElement otherSchoolSpecificHeaderLink;
	 
	 /*WebElements of Tables in Accordion */
	 
	 @FindBy(xpath="//table[@id='content_default']")
	 @CacheLookup
	 public WebElement generalTable;
	 
	 @FindBy(xpath="//table[@id='content_academics']")
	 @CacheLookup
	 public WebElement academicsTable;
	 
	 @FindBy(xpath="//table[@id='content_activities']")
	 @CacheLookup
	 public WebElement activitiesTable;
	 
	 @FindBy(xpath="//table[@id='content_faith']")
	 @CacheLookup
	 public WebElement faithTable;
	 
	 @FindBy(xpath="//table[@id='content_family']")
	 @CacheLookup
	 public WebElement familyTable;
	 
	 @FindBy(xpath="//table[@id='content_campuses_and_schools']")
	 @CacheLookup
	 public WebElement campusesTable;
	 
	 @FindBy(xpath="//table[@id='content_upperclass_and_transfer_students']")
	 @CacheLookup
	 public WebElement upperClassTable;
	 
	 @FindBy(xpath="//table[@id='content_other_school_specific']")
	 @CacheLookup
	 public WebElement otherSchoolSpecificTable;
	 
	 /* Misc WebElements */
	 
	 @FindBy(xpath="//form[@id='questionData']/p/input[@value='Cancel']")
	 @CacheLookup
	 public WebElement cancelButton;
	 
	 @FindBy(xpath="//form[@id='questionData']/p/input[@value='Save Changes']")
	 @CacheLookup
	 public WebElement saveButton;
	
	 @FindBy(xpath="//form[@id='questionData']/p")
	 @CacheLookup
	 public WebElement formParagraph;
	 
	 
	 
	 public StudentInformationPage studentInfoInit(WebDriver driver){
		System.out.println("Initiating Student Information Page Elements.");
    	return PageFactory.initElements(driver, StudentInformationPage.class);
    }
    

}
