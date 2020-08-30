package br.com.fiap.lifeshare.infrasctructure.http.presentation.request;

public class UserDTOFixture {
    final static String USER_LOGIN = "{\"email\": \"abc@gmail.com\", \"senha\": \"abc123\" }";

    final static String USER_WITHOUT_PASSWORD = "{\"email\": \"abc@gmail.com\" }";

    final static String USER_WITH_BAD_CREDENTIALS = "{\"email\": \"abc@gmail.com\", \"senha\": \"010101\" }";

    final static String NEW_USER = "{\"email\": \"abc_def@gmail.com\", \"senha\": \"def123 \" }";

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
}
