package com.overture.npc.elementlocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.overture.npc.methods.CommonMethods;

public class TestCaseStudentPage {

	CommonMethods commonMethods = new CommonMethods();

	@FindBy(xpath="//div[@id='main']//div[@class='title']")
	@CacheLookup
	public WebElement pageTitle;
	
	@FindBy(xpath="//div[@id='navigation']//a[contains(.,'Leave Calculator')]")
	@CacheLookup
	public WebElement leaveCalculator;
	
	@FindBy(xpath="//button[@id='next']")
	@CacheLookup
	public WebElement EnterAsGuestLink;
	
	//====================================================
		//  Student Information
	
	@FindBy(id="student.firstName")
	@CacheLookup
	public WebElement studentFirstName;
	
	@FindBy(id="student.completingCalculator")
	@CacheLookup
	public WebElement studentCompletingCalculator;
	
	@FindBy(id="student.birthYear")
	@CacheLookup
	public WebElement studentBirthYear;
	
	@FindBy(id="student.gradeYearCode")
	@CacheLookup
	public WebElement studentGradeYearCode;
	
	@FindBy(id="student.residencyStateCode")
	@CacheLookup
	public WebElement studentResidencyStateCode;
	
	@FindBy(id="student.maritalStatusCode")
	@CacheLookup
	public WebElement studentMaritalStatusCode;
	
	@FindBy(id="student.housingCode")
	@CacheLookup
	public WebElement studentHousingCode;
	
//====================================================
//  Parent HouseHold Information

	@FindBy(id="parent.maritalStatusCode")
	@CacheLookup
	public WebElement parentMaritalStatusCode;
	
	@FindBy(id="parent.birthYear")
	@CacheLookup
	public WebElement parentBirthYear;
	
	@FindBy(id="parent.residencyStateCode")
	@CacheLookup
	public WebElement parentResidencyStateCode;
	
	@FindBy(id="parent.householdCount")
	@CacheLookup
	public WebElement parentHouseholdCount;
	
	@FindBy(id="parent.householdCollegeCount")
	@CacheLookup
	public WebElement parentHouseholdCollegeCount;
	
	@FindBy(id="parent.taxFormCode")
	@CacheLookup
	public WebElement parentTaxFormCode;
	
	@FindBy(id="parent.agi")
	@CacheLookup
	public WebElement parentAnnualGrossIncome;
	
	@FindBy(id="confirmhousehold")
	@CacheLookup
	public WebElement confirmHouseHoldNextButton;
	
//====================================================
//  Parent Income Information
	
	@FindBy(id="parent.wageIncome")
	@CacheLookup
	public WebElement parentIncome;
	
	@FindBy(id="parent.parent1WorkIncome")
	@CacheLookup
	public WebElement parentOneWorkIncome;
	

	@FindBy(id="parent.parent2WorkIncome")
	@CacheLookup
	public WebElement parentTwoWorkIncome;
	
	@FindBy(id="parent.InterestIncome")
	@CacheLookup
	public WebElement parentInterestIncome;
	
	@FindBy(id="parent.businessIncome")
	@CacheLookup
	public WebElement parentBussinessIncome;
	
	
	@FindBy(id="parent.otherIncome")
	@CacheLookup
	public WebElement parentOtherIncome;
	
	@FindBy(id="parent.adjustmentToIncome")
	@CacheLookup
	public WebElement parentAdjustmentToIncome;
	
	@FindBy(id="parent.educationTaxCreditAmount")
	@CacheLookup
	public WebElement parentEducationTaxCreditAmount;
	
	@FindBy(id="parent.untaxedIncome")
	@CacheLookup
	public WebElement parentUntaxedIncome;
	
	@FindBy(id="parent.taxExemptionCount")
	@CacheLookup
	public WebElement parentTaxExemptionCount;

//====================================================
//  Parent Assets Information
	
	@FindBy(id="parent.cashAmount")
	@CacheLookup
	public WebElement parentAssetCashAmount;

	@FindBy(id="parent.childSupportPaidAmount")
	@CacheLookup
	public WebElement parentAssetChildSupportPaidAmount;

//====================================================
//  Student Finances Information
	
	@FindBy(id="student.workIncome")
	@CacheLookup
	public WebElement studentWorkIncome;

	@FindBy(id="student.untaxedIncome")
	@CacheLookup
	public WebElement studentUntaxedIncome;
	
	@FindBy(id="student.cashAmount")
	@CacheLookup
	public WebElement studentCashAmount;

	
//====================================================
//  Common Elements
	
	@FindBy(xpath="//button[@id='back']")
	@CacheLookup
	public WebElement BackButton;
	
	@FindBy(className="btn-next")
	@CacheLookup
	public WebElement NextButton;
	
	@FindBy(xpath="//div[@class='submit-btns']//button[contains(.,'CALCULATE')]")
	@CacheLookup
	public WebElement CalculateButton;
	
	
	public TestCaseStudentPage studentTestCasePageInit(WebDriver driver) {
		System.out.println("Initiating Student Test Case Page Elements.");
		return PageFactory.initElements(driver, TestCaseStudentPage.class);
	}

}
