package com.example.vizyonervizyoner.Company;
import com.example.vizyonervizyoner.Resume.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyRepo Repo;

    public CompanyController(CompanyRepo Repo, CompanyService companyService){

        this.Repo= Repo;
        this.companyService = companyService;
    }
    private final CompanyService companyService;

    @GetMapping("/listeleme")
    public List<Company> firmaListeleme() {
        return companyService.firmaListeleme();
    }

    @GetMapping("/bilgileriAl/{id}")
    public ResponseEntity<Company> firmaBilgileriAl(@PathVariable int id) {
        Optional<Company> company = companyService.firmaBilgileriAl(id);
        if (company.isPresent()) {
            return new ResponseEntity<>(company.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/guncelleme/{id}")
    public ResponseEntity<Company> firmaBilgileriGuncelle(@PathVariable int id, @RequestBody Company updatedCompany) {
        Company company = companyService.firmaBilgileriGuncelle(id, updatedCompany);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/ilanAc")
    public ResponseEntity<Company> ilanAc(@RequestBody Company company) {
        Company savedCompany = companyService.ilanAc(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @PostMapping("/ilanSonucla")
    public ResponseEntity<?> ilanSonucla(@RequestParam int companyId, @RequestParam boolean sonuc) {
        companyService.ilanSonucla(companyId, sonuc);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ilanBasvuruBilgileriAl")
    public ResponseEntity<List<Company>> ilanBasvuruBilgileriAl(@RequestParam int companyId) {
        List<Company> basvurular = companyService.ilanBasvuruBilgileriAl(companyId);
        return new ResponseEntity<>(basvurular, HttpStatus.OK);
    }
    @GetMapping("/get/user/{userid}")
    public ResponseEntity<Company> getCompanyByUserId(@PathVariable("userid") int id) {
        Company company = companyService.GetCompanyDetailsWUserId(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/user/{userid}")
    public ResponseEntity<Company> updateCompanyByUserId(@PathVariable("userid") int id, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompanyByUserId(id, company);
        if (updatedCompany != null) {
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
