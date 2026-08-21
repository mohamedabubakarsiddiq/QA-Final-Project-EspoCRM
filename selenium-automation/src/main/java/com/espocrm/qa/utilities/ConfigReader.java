package com.espocrm.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static final Properties properties = new Properties();
	
	static {
		String filePath = "src/test/resources/config.properties";
		
		try (InputStream input = new FileInputStream(filePath)) {
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException("unable to load config.properties from: " + filePath, e);
		}
		
	}
	
	public static String getProperty(String key) {
		String value = properties.getProperty(key);
		
		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException("Configuration property is missing or empty: "+ key);
		}
		
		
		return value .trim();
		
	}
	
	

}
