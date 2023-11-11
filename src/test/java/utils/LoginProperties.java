package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginProperties {
	public static Properties readData() {
		File file = new File("src/test/java/config/login.properties");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
