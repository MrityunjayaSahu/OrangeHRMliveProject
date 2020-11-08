package com.OrangeHRMlive.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRMlive.Utility.Controller;

public class LoginPage extends Controller {
	
	@FindBy(xpath = "//div[@id='divUsername']/input")
	private WebElement txtBox_userName;
	
	@FindBy(xpath = "//div[@id='divPassword']/input")
	private WebElement txtbox_passWord;
	
	@FindBy(xpath = "//div[@id='divLoginButton']/input")
	private WebElement button_Login;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver)
		this.driver = driver;
	}

	public void loginIntoApp(String userName, String passWord) {
		txtBox_userName.sendKeys(userName);
		txtbox_passWord.sendKeys(passWord);
		button_Login.click();
	}
	
}
