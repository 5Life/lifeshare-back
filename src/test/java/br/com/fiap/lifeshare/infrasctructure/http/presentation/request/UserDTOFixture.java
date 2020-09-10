package br.com.fiap.lifeshare.infrasctructure.http.presentation.request;

public class UserDTOFixture {
    final static String USER_LOGIN = "{\"email\": \"abc@gmail.com\", \"password\": \"abc123\" }";

    final static String USER_WITHOUT_PASSWORD = "{\"email\": \"abc@gmail.com\" }";

    final static String USER_WITH_BAD_CREDENTIALS = "{\"email\": \"abc@gmail.com\", \"password\": \"010101\" }";

    final static String NEW_USER = "{\"email\": \"abc_def@gmail.com\", \"password\": \"def123 \", \"name\": \"Floid\", \"bloodGroup\": \"A+\" }";

    final static String CREATED_USER = "{\"email\": \"abc_def@gmail.com\", \"password\": \"def123 \", \"name\": \"Floid\", \"bloodGroup\": \"A+\" }";

    final static String UPDATED_USER = "{\"email\": \"abc@gmail.com\", \"name\": \"Floyd\", \"bloodGroup\": \"O-\" }";

    final static String UPDATED_USER_NOT_EXISTENT = "{\"email\": \"abcd@gmail.com\", \"name\": \"Floyd\", \"bloodGroup\": \"O-\" }";

    public static String getUserLogin() {
        return USER_LOGIN;
    }

    public static String getUserWithoutPassword() {
        return USER_WITHOUT_PASSWORD;
    }

    public static String getUserWithBadCredentials() {
        return USER_WITH_BAD_CREDENTIALS;
    }

    public static String getNewUser() {
        return NEW_USER;
    }

    public static String getCreatedUser() {
        return CREATED_USER;
    }

    public static String getUpdatedUser() {
        return UPDATED_USER;
    }

    public static String getUpdatedUserNotExistent() {
        return UPDATED_USER_NOT_EXISTENT;
    }
}
