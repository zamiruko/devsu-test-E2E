package com.devsu.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;

    private ConfigLoader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load config properties", e);
        }
    }

    public static ConfigLoader load() {
        return new ConfigLoader();
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

}
