package com.OrangeHRMlive.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;

	public ConfigDataProvider() {
		File path = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getUserName() {
		return prop.getProperty("userName");
	}
	
	public String getPassWord() {
		return prop.getProperty("passWord");
	}
}
