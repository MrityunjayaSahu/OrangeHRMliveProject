package com.OrangeHRMlive.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.OrangeHRMlive.Utility.Controller;

public class PersonalDetailsPage extends Controller{

	@FindBy(xpath = "//div[@id='pdMainContainer']//h1")
	private WebElement label_PersonalDetails;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//input[@id='btnSave']")
	private WebElement button_EditAndSave;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//input[@id='personal_txtEmpFirstName']")
	private WebElement textBox_FirstName;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//input[@id='personal_txtEmpLastName']")
	private WebElement textBox_LastName;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//label[contains(text(),'Male')]/preceding-sibling::input")
	private WebElement radioButton_Male;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//select[@id='personal_cmbMarital']")
	private WebElement dropDown_MaritalStatus;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//select[@id='personal_cmbNation']")
	private WebElement dropDown_Nationality;
	
	@FindBy(xpath = "//form[@id='frmEmpPersonalDetails']//input[@id='personal_DOB']")
	private WebElement datePicker_DOB;
	
	WebDriver driver;
	
	public PersonalDetailsPage(Controller controller) {
		super(controller);
		PageFactory.initElements(driver, this);
	}
	
	public String getTextPersonalDetails() {
		try {
			return label_PersonalDetails.getText();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void savePersonalDetails(String firstName, String lastName, String maritalStatusType, String NationalityType) {
		this.clickOnButtonEdit();
		this.setTextFirstName(firstName);
		this.setTextLastName(lastName);
		this.selectGendreMale();
		this.selectMaritalStatus(maritalStatusType);
		this.selectNationality(NationalityType);
		this.clickOnButtonEdit();
	}
	
	public void clickOnButtonEdit() {
		try {
			button_EditAndSave.click();
		} catch (Exception e) {
			System.out.println("Unable to click on Button Edit - " + e);
		}
	}
	
	public void setTextFirstName(String fName) {
		try {
			textBox_FirstName.clear();
			textBox_FirstName.sendKeys(fName);
		} catch (Exception e) {
			System.out.println("Unable to Set First Name - " + e);
		}
	}
	
	public void setTextLastName(String lName) {
		try {
			textBox_LastName.clear();
			textBox_LastName.sendKeys(lName);
		} catch (Exception e) {
			System.out.println("Unable to Set Last Name - " + e);
		}
	}
	
	public void selectGendreMale() {
		try {
			boolean status = radioButton_Male.isSelected();
			if(!status) {
				radioButton_Male.click();
			}else {
				System.out.println("Male Radio Button already Selected ");
			}
		} catch (Exception e) {
			System.out.println("Unable to Select Gender Type - " + e);
		}
	}
	
	public void selectMaritalStatus(String option) {
		try {
			Select dropDownMaritalStatus = new Select(dropDown_MaritalStatus);
			dropDownMaritalStatus.selectByValue(option);
		} catch (Exception e) {
			System.out.println("Unable to Select MaritalStatus Dropdown - " + e);
		}
	}
	
	public void selectNationality(String text) {
		try {
			Select dropDownNationality = new Select(dropDown_Nationality);
			dropDownNationality.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println("Unable to Select Nationality Dropdown - " + e);
		}
	}
	
}
