package com.example.vizyonervizyoner.auth;

public class RegisterDTO {
    private String Firstname;
    private String Lastname;
    private String Password;
    private String Email;

    public RegisterDTO() {
        super();
    }

    public RegisterDTO(String firstname, String lastname, String password, String email) {
        Firstname = firstname;
        Lastname = lastname;
        Password = password;
        Email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String toString(){
        return "Registration info: Email: " + this.Email + "firstname: " + this.Firstname + "lastname: " + this.Lastname + "password: " + this.Password;
    }
}
