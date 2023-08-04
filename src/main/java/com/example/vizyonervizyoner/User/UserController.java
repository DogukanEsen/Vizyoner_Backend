package com.example.vizyonervizyoner.User;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;
    @Autowired
    CompanyService companyService;

    @GetMapping("/a")
    public String a(){
        return "a";
    }
    @PostMapping("/firmaEkle")
    public void firmaEkle(@RequestBody int userId, @RequestBody Company company){
        //userService.firmaEkle(userId, company);
    }
    @PostMapping("/kullaniciEkle")
    public ResponseEntity<String> kullaniciEkle(@RequestBody Users user) {
        Users savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Kullanıcı oluşturuldu. ID: " + savedUser.getId());
    }
    @GetMapping("/kullanicilariListele")
    public List<Users> kullanicilariListele() {
        return userService.userListeleme();
    }
    @PutMapping("/kullaniciGuncelle/{userId}")
    public ResponseEntity<String> kullaniciGuncelle(@PathVariable int userId, @RequestBody Users updatedUser) {
        Optional<Users> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            // Diğer güncelleme işlemleri...
            userService.saveUser(existingUser);
            return ResponseEntity.ok("Kullanıcı güncellendi.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı.");
        }
    }

    @DeleteMapping("/kullaniciSil/{userId}")
    public ResponseEntity<String> kullaniciSil(@PathVariable int userId) {
        Optional<Users> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("Kullanıcı silindi.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı.");
        }
    }

}


