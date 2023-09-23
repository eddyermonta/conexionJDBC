package com.platzi.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    private static BasicDataSource pool;

    private Conexion() {
        // Constructor privado para evitar la creación de instancias
    }

    public static BasicDataSource getInstance() {
        if (pool == null) {
            pool = createPool();
            configuratePool();
        }
        return pool;
    }

    private static void configuratePool() {
        pool.setInitialSize(3);
        pool.setMinIdle(3);
        pool.setMaxIdle(10);
        pool.setMaxTotal(10);
    }

    public static Connection getConection() throws SQLException {
        return getInstance().getConnection();
    }

    private static BasicDataSource createPool() {
        ReadPropertiesFile propertiesFile = new ReadPropertiesFile(ConfigurationConstants.PROPERTIES_FILE_NAME);
        pool = new BasicDataSource();
        pool.setUrl(propertiesFile.getValue("URL"));
        pool.setUsername(propertiesFile.getValue("USER"));
        pool.setPassword(propertiesFile.getValue("PASSWORD"));
        return pool;
    }
}