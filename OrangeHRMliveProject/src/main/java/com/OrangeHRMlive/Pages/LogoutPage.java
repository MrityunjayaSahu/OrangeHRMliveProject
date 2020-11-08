package com.OrangeHRMlive.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRMlive.Utility.Controller;

public class LogoutPage extends Controller{

	@FindBy(xpath = "//div[@id='branding']//a[@id='welcome']")
	private WebElement link_Welcome;
	
	@FindBy(xpath = "//div[@id='welcome-menu']//ul//a[contains(text(),'Logout')]")
	private WebElement link_Logout;
	
	@FindBy(xpath = "//div[@id='welcome-menu']")
	private WebElement menu_Welcome;
	
	@FindBy(xpath = "//div[@id='divLogo']/img")
	private WebElement logo_OrangeHRM;
	
	WebDriver driver;
	
	public LogoutPage(Controller controller) {
		super(controller);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogout() {
		try {
			link_Welcome.click();
			Controller.waitUntilElementIsDisplayed(menu_Welcome);
			link_Logout.click();
			Controller.waitUntilElementIsDisplayed(logo_OrangeHRM);
		} catch (Exception e) {
			System.out.println("Unable to click on Logout link");
		}
	}
	
}
