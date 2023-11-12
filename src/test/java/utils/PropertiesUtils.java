package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	public static Properties readDataFromPropertyFile(String pathName) {
		File file = new File(pathName);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();
			return properties;
		} catch (IOException e) {
			throw new RuntimeException("can not find the file");
		}
	}
}
