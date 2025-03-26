package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	static {
		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("failed to load Data");
			// TODO Auto-generated catch block
		}

	}

	public static String getWebsite(String key) {
		return properties.getProperty(key);
	}

	public static String getCredentials(String key) {
		// TODO Auto-generated method stub
		return properties.getProperty(key);
	}


}
