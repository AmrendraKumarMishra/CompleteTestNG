package com.tek.crm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromFileUtility(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./commonData/VtigerPropertiesFile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}
