package com.example.vizyonervizyoner.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired CompanyRepo repo;

    public Company saveCompany(Company company) {
        return repo.save(company);
    }

}
