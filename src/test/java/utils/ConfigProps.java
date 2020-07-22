package utils;

import static java.lang.System.out;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProps {
	private static Properties properties;
	
	public static String getProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return properties.getProperty(key);
        }
    }


    public static void loadRunConfigProps(String configPropertyFileLocation) {
        properties = new Properties();
        configPropertyFileLocation = "./src/test/resources/config.properties";
        try (InputStream inputStream = ConfigProps.class.getResourceAsStream("configPropertyFileLocation")) {
            properties.load(inputStream);
            properties.list(out);
        } catch (IOException e) {
            e.getMessage();
        }
    }


}
