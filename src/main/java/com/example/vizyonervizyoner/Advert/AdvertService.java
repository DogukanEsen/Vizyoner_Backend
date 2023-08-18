package com.example.vizyonervizyoner.Advert;

import com.example.vizyonervizyoner.Company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertService {

    private final AdvertRepository advertRepository;

    @Autowired
    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public Advert createAdvert(Advert advert) {
        return advertRepository.save(advert);
    }

    public List<Advert> getAllAdverts() {
        return advertRepository.findAll();
    }

    public Advert getAdvertById(int id) {

        Optional<Advert> advertOptional = advertRepository.findById(id);
        Advert existingAdvert = new Advert();
        if (advertOptional.isPresent()) {
            existingAdvert = advertOptional.get();
            String imageData = existingAdvert.getImage(); // Assuming this returns a String
            byte[] imageBytes = Base64.getDecoder().decode(imageData);
            existingAdvert.setImage(Arrays.toString(imageBytes));
        }
        return existingAdvert;

    }


    public Advert updateAdvert(Integer id, Advert updatedAdvert) {
        Advert existingAdvert = advertRepository.findById(id).orElse(null);
        if (existingAdvert != null) {
            existingAdvert.setUpdateDate(updatedAdvert.getUpdateDate());
            existingAdvert.setTitle(updatedAdvert.getTitle());
            existingAdvert.setDescription(updatedAdvert.getDescription());
            existingAdvert.setStartDate(updatedAdvert.getStartDate());
            existingAdvert.setEndDate(updatedAdvert.getEndDate());
            existingAdvert.setImage(updatedAdvert.getImage());
            existingAdvert.setLocation(updatedAdvert.getLocation());
            existingAdvert.setCategory(updatedAdvert.getCategory());
            existingAdvert.setCompany(updatedAdvert.getCompany());

            // Resim alanını güncellemeden önce base64'e dönüştürme
            if (updatedAdvert.getImage() != null) {
                String imageData = updatedAdvert.getImage(); // Assuming this returns a String
                byte[] imageBytes = Base64.getDecoder().decode(imageData);
                updatedAdvert.setImage(Arrays.toString(imageBytes));
            }



            return advertRepository.save(existingAdvert);
        } else {
            return null;
        }
    }

    public List<Advert> findAdvertsByCompanyId(Integer companyId) {
        return advertRepository.findAdvertsByCompanyId(companyId);
    }

    public boolean deleteAdvert(Integer id) {
        if (advertRepository.existsById(id)) {
            advertRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
