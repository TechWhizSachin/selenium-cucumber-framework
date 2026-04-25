package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties properties;
	
	public ConfigReader() {
		try (InputStream fis = getClass().getClassLoader()
		        .getResourceAsStream("config.properties")) {

		    if (fis == null) {
		        throw new RuntimeException("config.properties not found");
		    }

		    properties = new Properties();
		    properties.load(fis);

		} catch (IOException e) {
		    throw new RuntimeException("Failed to load config.properties file", e);
		}
	}
	
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getUsername() {
		return properties.getProperty("username");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}

}
