package com.example.vizyonervizyoner.auth;

public class LoginDTO {
    private String Email;
    private String Password;

    public LoginDTO() {
        super();
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LoginDTO(String email, String password) {
        Email = email;
        Password = password;
    }
}