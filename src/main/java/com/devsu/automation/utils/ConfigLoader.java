package com.devsu.automation.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static Logger log = Logger.getLogger(ConfigLoader.class);


    private ConfigLoader()  throws IOException{
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            log.error("Unable to load config properties", e);
            throw new RuntimeException("Failed to load configuration properties.", e);
        }
    }

    public static ConfigLoader load() throws IOException {
        return new ConfigLoader();
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

}
