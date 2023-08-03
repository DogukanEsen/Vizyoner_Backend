package com.example.vizyonervizyoner.User;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}


