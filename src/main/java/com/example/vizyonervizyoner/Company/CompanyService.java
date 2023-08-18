package com.example.vizyonervizyoner.Company;

import com.example.vizyonervizyoner.Advert.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyService {
    @Autowired CompanyRepo repo;

    public Company saveCompany(Company company) {
        return repo.save(company);
    }

    public List<Company> firmaListeleme() {
        return repo.findAll();
    }

    public Optional<Company> firmaBilgileriAl(int id) {

        Optional<Company> companyOptional = repo.findById(id);
        if (companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            String imageData = existingCompany.getImage(); // Assuming this returns a String
            byte[] imageBytes = Base64.getDecoder().decode(imageData);
            existingCompany.setImage(Arrays.toString(imageBytes));
        }
        return companyOptional;
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

}
