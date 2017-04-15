package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.overture.npc.methods.CommonMethods;

public class LoginPage {

	CommonMethods cm = new CommonMethods();

	@FindBy(id = "username")
	@CacheLookup
	public WebElement UserName;
	
	
	@FindBy(id = "password")
	@CacheLookup
	public WebElement Password;

	@FindBy(xpath = "//input[@type='submit' and @value='Log In']")
	@CacheLookup
	public WebElement LoginButton;

	@FindBy(xpath = "//div[@class='errorMessage']")
	@CacheLookup
	public WebElement errorMessage;

	@FindBy(id="header")
	@CacheLookup
	public WebElement header;
	
	public LoginPage loginPageInit(WebDriver driver){
		System.out.println("Initiating Login Page Elements.");
		return PageFactory.initElements(driver, LoginPage.class);
	
	}

}
