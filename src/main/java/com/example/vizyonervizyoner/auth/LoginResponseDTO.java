package com.example.vizyonervizyoner.auth;

import com.example.vizyonervizyoner.User.Users;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginResponseDTO {
    private UserDetails user;
    private String jwt;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(UserDetails user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
