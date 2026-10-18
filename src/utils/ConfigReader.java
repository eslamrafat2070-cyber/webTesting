package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties = new Properties();
    public ConfigReader() {

        try (FileInputStream file =
                     new FileInputStream("src/test/resources/config.properties")) {

            properties.load(file);

        } catch (IOException e) {
            throw new RuntimeException("Could not read config.properties", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
