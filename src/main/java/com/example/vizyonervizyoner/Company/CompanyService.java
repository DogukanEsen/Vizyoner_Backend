package com.example.vizyonervizyoner.Company;

import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
@Service
public class CompanyService {
    @Autowired CompanyRepo repo;
    @Autowired UserRepo userRepo;

    public Company saveCompany(Company company) {
        return repo.save(company);
    }

    public List<Company> firmaListeleme() {
        return repo.findAll();
    }

    public Optional<Company> firmaBilgileriAl(int id) {
        return repo.findById(id);
    }

    public Company firmaBilgileriGuncelle(int id, Company updatedCompany) {
        Optional<Company> company = repo.findById(id);
        if (company.isPresent()) {
            Company existingCompany = company.get();
            // Firma bilgilerini güncelleme işlemleri
            existingCompany.setName(updatedCompany.getName());
            existingCompany.setContent(updatedCompany.getContent());
            existingCompany.setCategory(updatedCompany.getCategory());
            existingCompany.setType(updatedCompany.isType());
            // Diğer güncelleme işlemleri
            return repo.save(existingCompany);
        }
        return null;
    }

    public Company ilanAc(Company company) {
        return repo.save(company);
    }

    public boolean ilanSonucla(int companyId, boolean sonuc) {
        // companyId'ye sahip olan ilanın sonucunu güncellemek için burada gerekli işlemleri yapın.
        Optional<Company> optionalCompany = repo.findById(companyId);

        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setType(sonuc); // "type" alanı ilanın sonucunu belirten alandır güncelleniyor.

            return true;
        }

        return false; // İlgili companyId'ye sahip ilan bulunamadı, güncelleme başarısız.
    }

    public List<Company> ilanBasvuruBilgileriAl(int companyId) {
        Optional<Company> company = repo.findById(companyId);
        if (company.isPresent()) {
            Company existingCompany = company.get();
            // Firma ile ilişkilendirilen başvuruların alınması
            List<Company> basvurular = new ArrayList<>();
            basvurular.add(existingCompany);
            return basvurular;
        }
        return new ArrayList<>();
    }
    public Company GetCompanyDetailsWUserId(int userid){
        Users user = userRepo.findById(userid).orElse(null);
        return repo.findCompanyByUserId(user).orElse(null);
    }

    public Company updateCompanyByUserId(int id, Company company) {
        Users user = userRepo.findById(id).orElse(null);
        Company existingCompany = repo.findCompanyByUserId(user).orElse(null);
        if(existingCompany != null){
            existingCompany.setName(company.getName());
            existingCompany.setContent(company.getContent());
            existingCompany.setCategory(company.getCategory());
            existingCompany.setType(company.isType());
            existingCompany.setImage(company.getImage());
            existingCompany.setUser(user);
            return repo.save(existingCompany);
        }else return null;
    }
}
