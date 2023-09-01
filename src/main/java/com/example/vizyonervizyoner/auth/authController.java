package com.example.vizyonervizyoner.auth;

import com.example.vizyonervizyoner.User.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
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
    @GetMapping("/isuser/{jwt}")
    public boolean isuser(@PathVariable String jwt){
        return Authservice.isUser(jwt);
    }
    @GetMapping("/isadmin/{jwt}")
    public boolean isadmin(@PathVariable String jwt){
        return Authservice.isAdmin(jwt);
    }
    @GetMapping("isauth/{jwt}")
    public boolean isauth(@PathVariable String jwt){
        return Authservice.isAuth(jwt);
    }
}