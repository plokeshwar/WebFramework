package com.overture.npc.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.overture.npc.methods.CommonMethods;

public class TS_06_Verify_AccountTab_TrafficSummaryPage_DISABLED {
	CommonMethods cm=new CommonMethods();
	
	@Test
	  public void TC_01_NO_TEST_CASES() {
		  Reporter.log(cm.ReporterTextBold(new Object(){}.getClass().getEnclosingMethod().getName()));
		}
	  
	  @BeforeMethod
	  public void beforeMethod() {
		}

	  @AfterMethod
	  public void afterMethod() {
		}
	
}
