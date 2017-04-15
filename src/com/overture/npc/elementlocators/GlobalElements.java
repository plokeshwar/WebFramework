package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalElements {
	
	 @FindBy(xpath="//a[contains(.,'here')]")
	 @CacheLookup
	 public WebElement LoginPageReDirector;
	 
	 @FindBy(xpath="//div[@id='main']")
	 @CacheLookup
	 public WebElement LogoutMessage;
	 
	 public GlobalElements globalElementsInit(WebDriver driver){
		 System.out.println("Initiating Global Elements.");
    	return PageFactory.initElements(driver, GlobalElements.class);
    }
    

}
