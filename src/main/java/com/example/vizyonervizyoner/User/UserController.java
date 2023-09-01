package com.example.vizyonervizyoner.User;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyService;
import com.example.vizyonervizyoner.auth.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
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
        userService.firmaEkle(userId, company);
    }
    @GetMapping("/get/{id}")
    public RegisterDTO getUserByIdDTO(@PathVariable int id){
        return userService.getUserByIdDTO(id);
    }
    @GetMapping("/getbyjwt/{jwt}")
    public RegisterDTO getUserByIdDTOjwt(@PathVariable String jwt){
        return userService.getUserByIdDTOjwt(jwt);
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
    public ResponseEntity<String> kullaniciGuncelle(@PathVariable int userId, @RequestBody RegisterDTO updatedUser) {
        Optional<Users> optionalUser = userService.findUserById(userId);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            existingUser.setFirstName(updatedUser.getFirstname());
            existingUser.setLastName(updatedUser.getLastname());
            existingUser.setEmail(updatedUser.getEmail());
            userService.saveUser(existingUser);
            return ResponseEntity.ok("Kullanıcı güncellendi.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı.");
        }
    }

    @PutMapping("/kullaniciGuncellejwt/{jwt}")
    public Users kullaniciGuncellejwt(@PathVariable String jwt, @RequestBody RegisterDTO updatedUser) {
        return userService.updateUserByjwt(jwt,updatedUser);
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


