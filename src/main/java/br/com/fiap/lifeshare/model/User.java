package br.com.fiap.lifeshare.model;

import br.com.fiap.lifeshare.config.auth.Profile;
import br.com.fiap.lifeshare.dto.UserDTO;
import br.com.fiap.lifeshare.dto.UserUpdateDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_USER")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String bloodGroup;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Profile> profiles = new ArrayList<>();

    public User(Long id, String email, String password, String name, String bloodGroup) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    public User(String email, String password, String name, String bloodGroup) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {}

    public UserDTO convert() {
        return new UserDTO(this.email, this.password, this.name, this.bloodGroup);
    }

    public UserUpdateDTO convertToUserUpdate() {
        return new UserUpdateDTO(this.email, this.name, this.bloodGroup);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
