package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.overture.npc.methods.CommonMethods;

public class TablesPage {

	CommonMethods cm = new CommonMethods();

	@FindBy(xpath="//input[@value='Add New Table']")
	@CacheLookup
	public WebElement addNewTableButton;

	@FindBy(xpath="//div[@class='subHeader']")
	@CacheLookup
	public WebElement subHeader;

	@FindBy(id="tabName")
	@CacheLookup
	public WebElement tableNameEditBox;

	@FindBy(id="newQuestionBox")
	@CacheLookup
	public WebElement tableInput;

	
	public TablesPage tablePageInit(WebDriver driver){
		System.out.println("Initiating table Page Elements.");
		return PageFactory.initElements(driver, TablesPage.class);
	
	}

}
