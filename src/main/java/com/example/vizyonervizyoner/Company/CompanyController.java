package com.example.vizyonervizyoner.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private CompanyRepo Repo;
    public CompanyController(CompanyRepo Repo){
        this.Repo= Repo;
    }
}
