package com.example.vizyonervizyoner.auth;

import com.example.vizyonervizyoner.Company.CompanyService;
import com.example.vizyonervizyoner.Resume.ResumeService;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Optional;
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
    @Autowired private ResumeService resumeService;
    @Autowired private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService jwtUserDetailsService;
    public Users registerFirm(String firstname, String lastname, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("ROLE_ADMIN").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        System.out.println("Email: " + email + "Password: " + password);
        Users user = userRepo.save(new Users(firstname,lastname,email,encodedPassword,authorities));
        userService.bosFirmaEkle(user.getId());
        return user;
    }
    public Users registerUser(String firstname, String lastname, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("ROLE_USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        System.out.println("Email: " + email + "Password: " + password);
        Users user = userRepo.save(new Users(firstname,lastname,email,encodedPassword,authorities));
        resumeService.createResume(user.getId());
        return user;
    }
    public LoginResponse loginUser(String email, String password){
        try{
            UserDetails userDetails = userService.loadUserByUsername(email);
            if (passwordEncoder.matches(password, userDetails.getPassword())){

                String token = tokenService.generateToken(userDetails);
                System.out.println(tokenService.getUsernameFromToken(token));
                Users user =userService.getOneUserByUserName(email);
                LoginResponse loginResponse = new LoginResponse("Bearer " + token, user.getId());
                return loginResponse;
            }
            throw new ValidationException("Email veya şifre hatalı.");
        }catch (AuthenticationException e){
            e.printStackTrace();
            return new LoginResponse("null" , 0);
        }
    }
    public boolean isUser(String jwt){
        if(!isAuth(jwt))
            return false;
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        Set<Role> roles = (Set<Role>) user.getAuthorities();

        for(Role role : roles){
            if(role.getAuthority().equals("ROLE_USER"))
                return true;
        }
        return false;
    }
    public boolean isAdmin(String jwt){
        if(!isAuth(jwt))
            return false;
        Users user = jwtTokenUtil.getUsersWjwt(jwt);

        Set<Role> roles = (Set<Role>) user.getAuthorities();

        for(Role role : roles){
            if(role.getAuthority().equals("ROLE_ADMIN"))
                return true;
        }
        return false;
    }
    public boolean isAuth(String jwt){
        try {
            jwt = jwt.substring(7);
            String email = jwtTokenUtil.getUsernameFromToken(jwt);
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(email);
            return jwtTokenUtil.validateToken(jwt,userDetails);
        }catch (Exception e){
            return false;
        }
    }
}
