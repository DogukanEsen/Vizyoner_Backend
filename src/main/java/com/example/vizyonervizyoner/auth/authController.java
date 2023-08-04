package com.example.vizyonervizyoner.auth;

import com.example.vizyonervizyoner.User.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {
    @Autowired private authService Authservice;
    @PostMapping("/login/firm")
    public LoginResponse loginFirm(@RequestBody LoginDTO body){
        return Authservice.loginUser(body.getEmail(), body.getPassword());
    }
    @PostMapping("/login/user")
    public LoginResponse loginUser(@RequestBody LoginDTO body){
        return Authservice.loginUser(body.getEmail(), body.getPassword());
    }
    @PostMapping("/register/firm")
    public Users registerFirm(@RequestBody RegisterDTO body){
        return Authservice.registerFirm(body.getFirstname(),body.getLastname(),body.getEmail(), body.getPassword());
    }
    @PostMapping("/register/user")
    public Users registerUser(@RequestBody RegisterDTO body){
        return Authservice.registerUser(body.getFirstname(),body.getLastname(),body.getEmail(), body.getPassword());
    }
}