package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.overture.npc.methods.CommonMethods;

public class ChangePasswordPage {

	CommonMethods commonMethods = new CommonMethods();

	@FindBy(className="pageTit")
	@CacheLookup
	public WebElement pageTitle;
	
	public ChangePasswordPage passwordPageInit(WebDriver driver) {
		System.out.println("Initiating Change Password Page Elements.");
		return PageFactory.initElements(driver, ChangePasswordPage.class);
	}

}
