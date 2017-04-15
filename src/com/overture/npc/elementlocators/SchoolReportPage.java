package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchoolReportPage {
	
	 
	 @FindBy(xpath="//span[@class='ui-datepicker-year']")
	 @CacheLookup
	 public WebElement datePickerYear;
	
	 @FindBy(xpath="//input[@id='fromDate']")
	 @CacheLookup
	 public WebElement fromDateField;
	 
	 @FindBy(xpath="//input[@id='toDate']")
	 @CacheLookup
	 public WebElement toDateField;
	
	 @FindBy(xpath="//div[@id='messageArea']")
	 @CacheLookup
	 public WebElement messageArea;
	
	 @FindBy(xpath="//input[@value='Run Report']")
	 @CacheLookup
	 public WebElement runReportButton;
	
	 @FindBy(xpath="//div[@id='ui-datepicker-div']//a[contains(.,'2')]")
	 @CacheLookup
	 public WebElement calendarDate2;
	 
	 @FindBy(xpath="//div[@id='ui-datepicker-div']//a[contains(.,'5')]")
	 @CacheLookup
	 public WebElement calendarDate5;
	 
	 public SchoolReportPage schoolReportPageElementsInit(WebDriver driver){
		System.out.println("Initiating School Report Page Elements.");
    	return PageFactory.initElements(driver, SchoolReportPage.class);
    }
    

}
