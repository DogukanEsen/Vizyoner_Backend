package com.example.vizyonervizyoner.auth;

public class LoginResponse {
    private String Token;
    private int UserId;

    public LoginResponse(String token, int userId) {
        Token = token;
        UserId = userId;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
