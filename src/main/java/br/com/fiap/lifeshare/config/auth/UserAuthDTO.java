package br.com.fiap.lifeshare.config.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthDTO {
    private String email;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}
