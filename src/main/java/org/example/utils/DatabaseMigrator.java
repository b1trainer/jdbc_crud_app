package org.example.utils;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;

public class DatabaseMigrator {
    public void runMigrations() throws Exception {
        String changeLogFile = PropertyUtils.getProperty(ApplicationConfig.LIQUIBASE_CHANGELOG_PROP_KEY);

        try  {
            Connection connection = ConnectionManager.getConnection();

            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));

            Liquibase liquibase = new Liquibase(
                    changeLogFile,
                    new ClassLoaderResourceAccessor(),
                    database
            );

            liquibase.update();
            System.out.println("Migrations complete");
        } catch (Exception e) {
            System.err.println("Migration error: " + e.getMessage());
            throw e;
        }
    }
}
