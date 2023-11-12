package utils;

import java.util.Properties;

public class ConfigPropUtils {
	private Properties properties;
	public ConfigPropUtils() {
		properties = PropertiesUtils.readDataFromPropertyFile("src/test/java/config/login.properties");
	}

	public String getProperties(String propertyName) {
		return properties.getProperty(propertyName);
	}
}
