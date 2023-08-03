package com.example.vizyonervizyoner.User;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/corpuser")
public class UserController {
    @Autowired UserService userService;
    @Autowired
    CompanyService companyService;


    @PostMapping("/firmaEkle")
    public void firmaEkle(@RequestBody int userId, @RequestBody Company company){
        //userService.firmaEkle(userId, company);
    }

}


