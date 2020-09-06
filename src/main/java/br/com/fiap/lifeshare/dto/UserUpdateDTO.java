package br.com.fiap.lifeshare.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserUpdateDTO {
    private @NotBlank @Email String email;
    private @NotBlank String name;
    private @NotBlank String bloodGroup;

    public UserUpdateDTO() {}

    public UserUpdateDTO(String email, String name, String bloodGroup) {
        this.email = email;
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
