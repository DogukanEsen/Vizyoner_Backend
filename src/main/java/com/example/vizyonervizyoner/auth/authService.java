package com.example.vizyonervizyoner.auth;

import com.example.vizyonervizyoner.User.*;
import com.example.vizyonervizyoner.Util.JwtTokenUtil;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class authService {
    @Autowired private UserRepo userRepo;
    @Autowired private RoleRepo roleRepo;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtTokenUtil tokenService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UserService userService;

    public String loginFirm(){
        return "LoginCorp";
    }
    public String registerFirm() {
        return "registerCorp";
    }
    public Users registerUser(String firstname, String lastname, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        System.out.println("Email: " + email + "Password: " + password);
        return userRepo.save(new Users(firstname,lastname,email,encodedPassword,authorities));
    }
    public LoginResponseDTO loginUser(String email, String password){
        try{
            UserDetails userDetails = userService.loadUserByUsername(email);
            if (passwordEncoder.matches(password, userDetails.getPassword())){

                String token = tokenService.generateToken(userDetails);
                return new LoginResponseDTO(userDetails, token);
            }
            throw new ValidationException("Email veya şifre hatalı.");
        }catch (AuthenticationException e){
            e.printStackTrace();
            return new LoginResponseDTO(null,"");
        }
    }
}