package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.overture.npc.methods.CommonMethods;

public class TestCaseDetailsPage {

	CommonMethods commonMethods = new CommonMethods();

	@FindBy(xpath="//div[@id='npc-tabs']//a[contains(.,'TEST RESULTS')]")
	@CacheLookup
	public WebElement testResultsLink;
	
	@FindBy(xpath="//div[@id='npc-tabs']//a[contains(.,'INAS Outputs')]")
	@CacheLookup
	public WebElement inasOutputLink;
	
	@FindBy(xpath="//div[@id='npc-tabs']//a[contains(.,'PACKAGING BREAKDOWN')]")
	@CacheLookup
	public WebElement packagingBreakdownLink;
	
	@FindBy(xpath="//div[@id='npc-tabs']//a[contains(.,'TEST LOGS')]")
	@CacheLookup
	public WebElement testLogsLink;
	
	@FindBy(xpath="//div[@id='npc-tabs']//a[contains(.,'INAS REQUEST')]")
	@CacheLookup
	public WebElement inasRequestLink;
	
	@FindBy(xpath="//div[@id='npc-tabs']//a[contains(.,'INAS RESPONSE')]")
	@CacheLookup
	public WebElement inasResponseLink;
	
	
	public TestCaseDetailsPage testCaseDetailsPageInit(WebDriver driver) {
		System.out.println("Initiating Test Case Details Page Elements.");
		return PageFactory.initElements(driver, TestCaseDetailsPage.class);
	}

}
