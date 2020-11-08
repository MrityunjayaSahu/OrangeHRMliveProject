package com.OrangeHRMlive.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Controller {
	
	public static WebDriver driver;
	String WorkingDir;
	public String browser;
	public String url;
	
	public Controller(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver launchBrowser(String browserType, String url) {
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public static void waitUntilElementIsDisplayed(final WebElement element) throws Exception {
		try {
			(new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					try {
						return Boolean.valueOf(element != null && element.isDisplayed());
					} catch (Exception e) {
						return Boolean.valueOf(false);
					}
				}
			});
		} catch (Exception e) {
			throw new Exception("waitUntilElementIsDisplayed is not working.. :: " + element + " " + e);
		}

	}

	public static void waitUntilElementIsNotDisplayed(final WebElement element) throws Exception {
		try {
			(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					try {
						return Boolean.valueOf(element == null || !element.isDisplayed());
					} catch (Exception e) {
						return Boolean.valueOf(true);
					}
				}
			});
		} catch (Exception e) {
			throw new Exception("waitUntilElementIsNotDisplayed is not working.. :: " + element + " " + e);
		}
	}
	
	public static boolean waitUntilElementIsEnabled(final WebElement element) {
		try {
			(new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					try {
						return Boolean.valueOf(element != null && element.isEnabled());
					} catch (Exception e) {
						return Boolean.valueOf(false);
					}
				}
			});
		} catch (TimeoutException te) {
			return false;
		}
		return false;
	}
	
	public static void clear(WebElement ele) throws Exception {
		try {
			ele.clear();
		} catch (Exception e) {
			throw new Exception("clear the textbox is not working for :: " + ele + " " + e);
		}
	}
	
	public static void setText(WebElement ele, String value) throws Exception {
		try {
			clear(ele);
			ele.sendKeys(value);
		} catch (Exception e) {
			throw new Exception("setText is not working for :: " + ele + " " + e);
		}
	}
	
	public static String getText(WebElement ele) throws Exception {
		try {
			return ele.getText();
		} catch (Exception e) {
			throw new Exception("getText is not working" + e);
		}
	}
	
	public static String getElementAttribute(WebElement element,String strAttribute) {
		String eleAttribute;
		try {
			eleAttribute = element.getAttribute(strAttribute);
		} catch (Exception e) {
			eleAttribute = "";
		}
		return eleAttribute;
	}
	
	public static boolean isElementEnabled(WebElement ele) throws Exception {
		try {
			return ele.isEnabled();
		} catch (Exception e) {
			throw new Exception("isElementEnabled is not working" + e);
		}
	}
	
	public static boolean isElementSelected(WebElement ele) throws Exception {
		boolean status;
		try {
			return ele.isSelected();
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	public static boolean isElementDisplayed(WebElement ele) throws Exception {
		boolean status;
		try {
			status = ele.isDisplayed();
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
	
}
