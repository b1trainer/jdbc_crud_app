package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final Connection connection = createConnection();

    private ConnectionManager() {
    }

    private static Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    PropertyUtils.getProperty(ApplicationConfig.DB_URL_PROP_KEY),
                    PropertyUtils.getProperty(ApplicationConfig.DB_USERNAME_PROP_KEY),
                    PropertyUtils.getProperty(ApplicationConfig.DB_PASSWORD_PROP_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error creating connection with database:" + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error database connection close: " + e.getMessage());
            }
        }
    }
}
