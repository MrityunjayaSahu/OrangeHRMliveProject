package com.OrangeHRMlive.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.OrangeHRMlive.Pages.HomePage;
import com.OrangeHRMlive.Pages.LogoutPage;
import com.OrangeHRMlive.Pages.PersonalDetailsPage;
import com.OrangeHRMlive.Utility.BaseClass;
import com.OrangeHRMlive.Utility.Controller;

public class MyInfoTest extends BaseClass{
	
//	public static Logger logger = Logger.getLogger(MyInfoTest.class);
	
	@Test(priority = 2)
	public void verifyPersonalDetails(Controller Application) {
		logger = report.createTest("VERIFY PERSONAL DETAILS");
		String actualLabel_PersonalDetails = "Personal Details";
		PersonalDetailsPage myInfo = new PersonalDetailsPage(Application);
		String expectedLabel_PersonalDetails = myInfo.getTextPersonalDetails();
		if(actualLabel_PersonalDetails.equalsIgnoreCase(expectedLabel_PersonalDetails))
			logger.pass("SUCCESSFULLY OPENED WITH PERSONAL DETAILS PAGE");
		else
			logger.fail("FAILED TO OPENED PERSONAL DETAILS PAGE");
		
		logger.info("END OF THE VERIFYPERSONALDETAILS TEST");
	}
	
	@Test(priority = 1)
	public void verifyAddPersonalDetailsAndClickOnSave(Controller Application) {
		logger = report.createTest("VERIFY ADD PERSONAL DETAILS AND CLICK ON SAVE BUTTON");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickOnTabMyInfo();
		
		PersonalDetailsPage myInfo = new PersonalDetailsPage(Application);
		myInfo.savePersonalDetails("John", "Smith", "Married", "Indian");
		
		logger.info("END OF THE VERIFYADDPERSONALDETAILSANDCLICKONSAVE TEST");
	}
	
	@Test(priority = 3)
	public void verifyLogout(Controller Application) {
		logger = report.createTest("VERIFY LOGOUT");
		LogoutPage logoutPage = new LogoutPage(Application);
		logoutPage.clickOnLogout();
		logger.info("END OF THE VERIFYLOGOUT TEST");
	}
	
}
