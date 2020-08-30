package br.com.fiap.lifeshare.dto;

import br.com.fiap.lifeshare.model.User;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank private String email;
    @NotBlank private String senha;

    public UserDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    private UserDTO(){}

    public User convert() {
        return new User(email, senha);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
