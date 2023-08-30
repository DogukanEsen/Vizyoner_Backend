package com.example.vizyonervizyoner.Advert;

import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import com.example.vizyonervizyoner.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

@Service
public class AdvertService {

    private final AdvertRepository advertRepository;
    @Autowired private JwtTokenUtil jwtTokenUtil;
    @Autowired private UserRepo userRepo;

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

    public Advert getAdvertById(Integer id) {
        return advertRepository.findById(id).orElse(null);
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

           /* // Resim alanını güncellemeden önce base64'e dönüştürme
            if (updatedAdvert.getImage() != null) {
                byte[] imageData = updatedAdvert.getImage();
                String base64Image = Base64.getEncoder().encodeToString(imageData);
                existingAdvert.setImage(Base64.getDecoder().decode(base64Image));
            }*/


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

    public List<Advert> aiOneri(String jwt){
        String email = jwtTokenUtil.getUsernameFromToken(jwt);
        Users user = userRepo.findByEmail(email).orElse(null);

        String apiUrl = "http://localhost:8000/api/oneri/"+user.getId();
        RestTemplate restTemplate = new RestTemplate();
        List<Advert> result = restTemplate.getForObject(apiUrl, List.class);
        return result;
    }
}