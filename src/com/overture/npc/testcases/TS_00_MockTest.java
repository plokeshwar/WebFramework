package com.overture.npc.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_00_MockTest {

String className = this.getClass().getName().substring(27);
String actual, expected;
String mainDriver, subDriver;
WebDriver driver = null;
PhantomJSDriver phantomJSdriver=null;
DesiredCapabilities dCaps;
String browserName=null;

CommonMethods cm = new CommonMethods();
CommonOperations co = new CommonOperations();


//Test Case 1
@Test(priority = 1)
public void TC_01_Validate_HowItWorksLink() {
System.out.println("Test 1");
}

//Test Case 2
@Test(priority = 2)
public void TC_02_Validate_TermsOfUseLink() {
	System.out.println("TEST2");
}


@BeforeMethod
public void beforeMethod() {
System.out.println(className+" Before Method");


}

@AfterMethod
public void afterMethod() {
System.out.println(className+" After Method");

}

@Parameters("browser")
@BeforeClass
public void beforeClass(String browser) {
browserName =  browser;
System.out.println(className+" Before Class");

driver = cm.getBrowser(browser);
driver.get("http://www.overturecorp.com");
//driver.get(new HomeServlet().environmentUrl());
driver.manage().window().maximize();

}

@AfterClass
public void afterClass() {
System.out.println(className+" After Class");
co.browserClose(driver);
}

}