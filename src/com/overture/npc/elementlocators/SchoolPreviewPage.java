package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchoolPreviewPage {
	
	 
	 @FindBy(xpath="//input[@id='addTestCase']")
	 @CacheLookup
	 public WebElement addTestCaseButton;
	 
	 
	 public SchoolPreviewPage schoolPreviewPageElementsInit(WebDriver driver){
		System.out.println("Initiating School Preview Page Elements.");
    	return PageFactory.initElements(driver, SchoolPreviewPage.class);
    }
    

}
