package com.overture.npc.methods;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class BrowserSelection {
	
	public static WebDriver driver;
	
	public enum selectDriver {
		CHROME, FIREFOX, IE
	}

	public static WebDriver getDriver(String driverType, String basepath){
		
	selectDriver driverName = selectDriver.valueOf(driverType.toUpperCase());

	switch (driverName) {
	

	case CHROME:
		System.out.println("Chrome Driver Initiated");
		Reporter.log(new CommonMethods().ReporterText("Chrome Browser Started"));
		driver = BrowserSelection.getChromeDriver(basepath);
		
		break;
		
	case FIREFOX:
		System.out.println("Firefox Driver Initiated");
		Reporter.log(new CommonMethods().ReporterText("FireFox Browser Started"));
		driver = BrowserSelection.getFirefoxDriver();
		break;

	case IE:
		System.out.println("IE Driver Initiated");
		Reporter.log(new CommonMethods().ReporterText("Internet Explorer Browser Started"));
		driver = BrowserSelection.getIE(basepath);
		break;	
	
	}
	driver.manage().window().maximize();
	return driver;
	}
	
	public static WebDriver getChromeDriver(String basepath){
		if(MacPlatform()){
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		}else{
		System.setProperty("webdriver.chrome.driver",basepath+"/browsers/chromedriver_win32_2.1/chromedriver.exe");
		}
		driver = new ChromeDriver(); 
		System.out.println(" HELLO CHROME DRIVER");
		
		return driver;
	}
	
	public static WebDriver getIE(String basepath){
	
	DesiredCapabilities capab = DesiredCapabilities.internetExplorer();

    capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	
    System.setProperty("webdriver.ie.driver",basepath+"/browsers/IEDriverServer_Win32_2.38.0/IEDriverServer.exe");
    
    driver=new InternetExplorerDriver(capab);
	
	System.out.println(" HELLO INTERNET EXPLORER DRIVER");
	return driver;
	}
	
	public static WebDriver getFirefoxDriver(){
		driver = new FirefoxDriver();
		System.out.println(" HELLO FIREFOX DRIVER");
		return driver;
	}
	
	public static boolean MacPlatform() {
		Platform current = Platform.getCurrent();
	    return Platform.MAC.is(current);
	}
}
