package com.OrangeHRMlive.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRMlive.Utility.Controller;

public class HomePage extends Controller{
	
	@FindBy(xpath = "//div[@id='mainMenu']//a[@id='menu_pim_viewMyDetails']")
	private WebElement tab_MyInfo;
	
	@FindBy(xpath = "//div[@id='content']//h1")
	private WebElement label_DashBoard;
	
	public HomePage(Controller controller) {
		super(controller);
		PageFactory.initElements(driver, this);
	}
	
	public String getText_DashBoard() {
		try {
			return label_DashBoard.getText();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void clickOnTabMyInfo() {
		try {
			boolean status = Controller.isElementSelected(tab_MyInfo);
			if(!status)
				tab_MyInfo.click();
			else
				Logger.getLogger("Already Selected");
		} catch (Exception e) {
			System.out.println("Unable to click on MyInfo Tab - " + e);
		}
	}
	
	
}
