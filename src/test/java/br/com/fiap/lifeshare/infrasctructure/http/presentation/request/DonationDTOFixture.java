package br.com.fiap.lifeshare.infrasctructure.http.presentation.request;

public class DonationDTOFixture {
    final static String DONATION_CREATE = 
        "{\"type\": \"organ\", \"organ\": \"figado\", \"location\": \"hospital das madeiras\", \"date\": \"1803-10-10\", \"userEmail\": \"abc_def@gmail.com\" }";

    final static String DONATION_CREATE_WRONG_USER = 
        "{\"type\": \"organ\", \"organ\": \"figado\", \"location\": \"hospital das madeiras\", \"date\": \"1803-10-10\", \"userEmail\": \"abcd@gmail.com\" }";

    final static String DONATION_UPDATE = 
        "{\"id\": 1, \"type\": \"blood\", \"location\": \"hospital das madeiras\", \"date\": \"1803-10-10\", \"userEmail\": \"abc_def@gmail.com\" }";

    final static String DONATION_NON_EXISTANT = 
        "{\"id\": 2, \"type\": \"blood\", \"location\": \"hospital das madeiras\", \"date\": \"1803-10-10\", \"userEmail\": \"abc_def@gmail.com\" }";

    public static String getDonationCreate() {
        return DONATION_CREATE;
    }

    public static String getDonationCreateWrongUser() {
        return DONATION_CREATE_WRONG_USER;
    }

    public static String getDonationUpdate() {
        return DONATION_UPDATE;
    }

    public static String getDonationNonExistant() {
        return DONATION_NON_EXISTANT;
    }
}
