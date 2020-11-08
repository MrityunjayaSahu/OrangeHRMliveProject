package com.OrangeHRMlive.Utility;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.OrangeHRMlive.Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
//	public static Logger logger = Logger.getLogger(BaseClass.class);
	
	public static Controller Application;
	public WebDriver driver;
	public static ConfigDataProvider config;
	public static ExtentHtmlReporter extent;
	public static volatile ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setUpDataProviders() {
		config = new ConfigDataProvider();
		extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/OrangeHRMlive.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setUpBrowser() throws Exception {
		driver = Controller.launchBrowser(config.getBrowser(), config.getUrl());
		LoginPage loginPage = new LoginPage(Application);
		loginPage.loginIntoApp(config.getUserName(), config.getPassWord());
		Controller.waitUntilElementIsDisplayed(driver.findElement(By.xpath("//div[@id='content']//h1")));
	}
	
	@AfterClass
	public void tearDownBrowser() {
		Controller.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			TestUtil.captureScreenshot(driver);
		}
		report.flush();
	}

}
