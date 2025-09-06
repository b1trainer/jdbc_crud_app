package org.example.utils;

public final class ApplicationConfig {
    private ApplicationConfig() {
    }

    public static final String PROPERTY_FILE_NAME = "application.properties";

    public static final String DB_URL_PROP_KEY = "db.url";
    public static final String DB_USERNAME_PROP_KEY = "db.username";
    public static final String DB_PASSWORD_PROP_KEY = "db.password";

    public static final int EXIT_APPLICATION_OPERATION_ID = 0;

    public static final int CREATE_ENTITY_OPERATION_ID = 1;
    public static final int READ_ENTITY_OPERATION_ID = 2;
    public static final int UPDATE_ENTITY_OPERATION_ID = 3;
    public static final int DELETE_ENTITY_OPERATION_ID = 4;

    public static final String SELECT_ENTITY_OPERATION_MESSAGE = String.format("""
                    Выберите операцию над сущностью:
                    %d. CREATE
                    %d. READ BY ID
                    %d. UPDATE
                    %d. DELETE
                    """,
            CREATE_ENTITY_OPERATION_ID,
            READ_ENTITY_OPERATION_ID,
            UPDATE_ENTITY_OPERATION_ID,
            DELETE_ENTITY_OPERATION_ID);

    public static final int LABEL_ENTITY_ID = 1;
    public static final int WRITER_ENTITY_ID = 2;
    public static final int POST_ENTITY_ID = 3;
    public static final int POST_STATUS_ID = 4;

    public static final String SELECT_ENTITY_MESSAGE = String.format("""
                    Выберите имя сущности для внесения изменений:
                    %d. Label
                    %d. Writer
                    %d. Post
                    %d. Post status
                    """,
            LABEL_ENTITY_ID,
            WRITER_ENTITY_ID,
            POST_ENTITY_ID,
            POST_STATUS_ID);
}
