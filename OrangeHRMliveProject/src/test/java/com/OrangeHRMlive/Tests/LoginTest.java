package com.OrangeHRMlive.Tests;

import org.testng.annotations.Test;

import com.OrangeHRMlive.Pages.LogoutPage;
import com.OrangeHRMlive.Utility.BaseClass;
import com.OrangeHRMlive.Utility.Controller;

public class LoginTest extends BaseClass{
	
//	public static Logger logger = Logger.getLogger(LoginTest.class);
	
	@Test(priority = 1)
	public void verifyTitle() throws Exception {
		logger = report.createTest("VERIFY TITLE");
		String actual_title = "OrangeHRM";
		
		String expected_title = driver.getTitle();
		
		if(expected_title.equalsIgnoreCase(actual_title)) 
			logger.pass("SUCCESSFULLY MATCH THE EXPECTED TITLE : " + expected_title + " AND ACTUAL TITLE : " + actual_title);
		else 
			logger.fail("FAILED TO MATCH THE EXPECTED TITLE : " + expected_title + " AND ACUTOAL TITLE : " + actual_title);
	}
	
	@Test(priority = 2)
	public void verifyLogout() {
		logger = report.createTest("VERIFY LOGOUT");
		LogoutPage logoutPage = new LogoutPage(Application);
		logoutPage.clickOnLogout();
		logger.info("END OF THE VERIFY LOGOUT TEST");
	}

}
