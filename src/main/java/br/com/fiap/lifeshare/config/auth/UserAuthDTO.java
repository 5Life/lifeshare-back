package br.com.fiap.lifeshare.config.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthDTO {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }
}
