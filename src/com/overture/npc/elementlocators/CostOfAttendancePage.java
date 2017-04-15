package com.overture.npc.elementlocators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CostOfAttendancePage {

	@FindBy(id="coaTable")
	@CacheLookup
	public WebElement coaTable;
	
	@FindBy(xpath="//table[@id='coaTable']//a[contains(.,'Tuition & Fees')]")
	@CacheLookup
	public WebElement tuitionFeeLink;
	
	@FindBy(xpath="//table[@id='coaTable']//a[contains(.,'Room & Board')]")
	@CacheLookup
	public WebElement roomBoardLink;
	
	@FindBy(xpath="//table[@id='coaTable']//a[contains(.,'Books & Supplies')]")
	@CacheLookup
	public WebElement booksSuppliesLink;
	
	@FindBy(xpath="//table[@id='coaTable']//a[contains(.,'Transportation')]")
	@CacheLookup
	public WebElement transportationLink;
	
	@FindBy(xpath="//table[@id='coaTable']//a[contains(.,'Personal Expenses')]")
	@CacheLookup
	public WebElement personalExpensesLink;
	
	@FindBy(xpath = "//div[@class='pageTit']")
	@CacheLookup
	public WebElement pageTitle;
	
	@FindBy(name="addFixedRow")
	@CacheLookup
	public WebElement fixedLink;
	
	@FindBy(id="rowId1")
	@CacheLookup
	public WebElement rowOne;
	
	@FindBy(id="fixedValue1")
	@CacheLookup
	public WebElement fixedValueOne;
	
	@FindBy(xpath="//table[@id='myRuleTable']//tr[3]//td[5]")
	@CacheLookup
	public WebElement deleteRowOne;
	
	@FindBy(xpath="//form[@id='expenseRuleForm']//input[@value='Cancel']")
	@CacheLookup
	public WebElement cancelButton;
	
	@FindBy(xpath="//form[@id='expenseRuleForm']//input[@value='Save Changes']")
	@CacheLookup
	public WebElement saveChangesButton;
	
	@FindBy(xpath="//table[@id='myRuleTable']//tr")
	@CacheLookup
	public List<WebElement> coaFixedRows;

	public CostOfAttendancePage COAPageInit(WebDriver driver){
		System.out.println("Initiating COA Page Elements.");
		return PageFactory.initElements(driver, CostOfAttendancePage.class);
	
	}

}
