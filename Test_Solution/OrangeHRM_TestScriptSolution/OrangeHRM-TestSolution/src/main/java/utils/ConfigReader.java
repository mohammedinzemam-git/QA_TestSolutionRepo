package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	static {

		try {

			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir")
					+ "/src/test/java/resources/config.properties");

			properties = new Properties();

			properties.load(fis);

		} catch (IOException e) {

			e.printStackTrace();

			throw new RuntimeException(
					"Failed to load config.properties");
		}
	}

	public static String getProperty(String key) {

		return properties.getProperty(key);
	}

	public static String getUrl() {

		return getProperty("url");
	}

	public static String getUsername() {

		return getProperty("username");
	}

	public static String getPassword() {

		return getProperty("password");
	}

	public static String getBrowser() {

		return getProperty("browser");
	}

}
