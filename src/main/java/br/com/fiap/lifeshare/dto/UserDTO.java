package br.com.fiap.lifeshare.dto;

import br.com.fiap.lifeshare.model.User;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank private String email;
    @NotBlank private String password;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private UserDTO(){}

    public User convert() {
        return new User(email, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
