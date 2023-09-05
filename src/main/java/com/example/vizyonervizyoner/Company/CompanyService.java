package com.example.vizyonervizyoner.Company;

import com.example.vizyonervizyoner.Advert.Advert;
import com.example.vizyonervizyoner.Advert.AdvertRepository;
import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import com.example.vizyonervizyoner.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyService {
    @Autowired CompanyRepo repo;
    @Autowired UserRepo userRepo;
    @Autowired private JwtTokenUtil jwtTokenUtil;
    @Autowired
    AdvertRepository advertRepository;

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

    public Advert ilanAc(int userID, Advert advert) {
        Company company = GetCompanyDetailsWUserId(userID);
        advert.setCompany(company);
        advertRepository.save(advert);
        return advert;
    }
    public Advert ilanAcjwt(String jwt, Advert advert) {
        Company company = GetCompanyDetailsWUserIdjwt(jwt);
        advert.setCompany(company);
        advertRepository.save(advert);
        return advert;
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
    public Company GetCompanyDetailsWUserIdjwt(String jwt){
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
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
    public Company updateCompanyByUserIdjwt(String jwt, Company company) {
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
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
