package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviewPage {
	
	 @FindBy(xpath="//div[@class='subHeader']")
	 @CacheLookup
	 public WebElement headerText;
	 
	 
	 @FindBy(id="addTestCase")
	 @CacheLookup
	 public WebElement addTestCaseButton;
	 
	 @FindBy(xpath = "//table[@id='preview-list']")
	 @CacheLookup
	 public WebElement previewTable;
	
	 @FindBy(xpath = "//form[@id='testFile']//input[@value='Cancel']")
	 @CacheLookup
	 public WebElement previewEditCancelBtn;
	 
	 public PreviewPage previewElementsInit(WebDriver driver){
		System.out.println("Initiating Preview Page Elements.");
    	return PageFactory.initElements(driver, PreviewPage.class);
    }
    

}
