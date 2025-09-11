package org.example.utils;

public final class ApplicationConfig {
    private ApplicationConfig() {
    }

    public static final String PROPERTY_FILE_NAME = "application.properties";

    public static final String DB_URL_PROP_KEY = "db.url";
    public static final String DB_USERNAME_PROP_KEY = "db.username";
    public static final String DB_PASSWORD_PROP_KEY = "db.password";
    public static final String LIQUIBASE_CHANGELOG_PROP_KEY = "liquibase.changeLogFile";

}
