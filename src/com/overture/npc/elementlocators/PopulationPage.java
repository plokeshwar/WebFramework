package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopulationPage {

	@FindBy(xpath="//input[@value='Add Population']")
	@CacheLookup
	public WebElement addPopulationButton;
	
	@FindBy(xpath = "//div[@class='pageTit']")
	@CacheLookup
	public WebElement pageTitle;
	
	@FindBy(id = "cancelButton")
	@CacheLookup
	public WebElement cancelButton;

	public PopulationPage populationPageInit(WebDriver driver){
		System.out.println("Initiating Population Page Elements.");
		return PageFactory.initElements(driver, PopulationPage.class);
	
	}

}
