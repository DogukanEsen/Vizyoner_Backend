package com.example.vizyonervizyoner.auth;

import com.example.vizyonervizyoner.User.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {
    @Autowired private authService Authservice;
    @GetMapping("/login/firm")
    public String loginFirm(){
        return Authservice.loginFirm();
    }
    @PostMapping("/login/user")
    public LoginResponseDTO loginUser(@RequestBody LoginDTO body){
        return Authservice.loginUser(body.getEmail(), body.getPassword());
    }
    @GetMapping("/register/firm")
    public String registerFirm(){
        return Authservice.registerFirm();
    }
    @PostMapping("/register/user")
    public Users registerUser(@RequestBody RegisterDTO body){
        return Authservice.registerUser(body.getFirstname(),body.getLastname(),body.getEmail(), body.getPassword());
    }
}