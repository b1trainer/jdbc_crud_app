package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private ConnectionManager() {
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertyUtils.getProperty(ApplicationConfig.DB_URL_PROP_KEY),
                    PropertyUtils.getProperty(ApplicationConfig.DB_USERNAME_PROP_KEY),
                    PropertyUtils.getProperty(ApplicationConfig.DB_PASSWORD_PROP_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
