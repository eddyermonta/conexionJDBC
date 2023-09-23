package com.platzi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
    private final Properties properties;

    public ReadPropertiesFile(String propertiesFilePath) {
        this.properties = loadProperties(propertiesFilePath);
    }

    private Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();
        try (InputStream inputStream = ReadPropertiesFile.class.getClassLoader().getResourceAsStream(propertiesFilePath)) {
            if (inputStream == null) {
                throw new IOException("Archivo no encontrado: " + propertiesFilePath);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}



