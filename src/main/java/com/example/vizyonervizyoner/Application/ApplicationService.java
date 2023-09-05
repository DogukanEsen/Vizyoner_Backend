package com.example.vizyonervizyoner.Application;

import com.example.vizyonervizyoner.Advert.Advert;
import com.example.vizyonervizyoner.Advert.AdvertRepository;
import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import com.example.vizyonervizyoner.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ApplicationService {
    private final ApplicationRepository Repo;
    private final UserRepo userRepo;
    @Autowired private JwtTokenUtil jwtTokenUtil;
    @Autowired private AdvertRepository advertRepo;

    @Autowired
    public ApplicationService(ApplicationRepository Repo, UserRepo userRepo) {
        this.Repo = Repo;
        this.userRepo = userRepo;
    }

    public Application saveApplication(Application application) {
        return Repo.save(application);
    }

    //Başvuru listeleme:
    public List<Application> basvurulistele() {
        return Repo.findAll();
    }

    //kullanıcı Id göre başvuruları getiren servis:
    public List<Application> getApplicationsByUserId(int userId) {
        return Repo.findByUserId(userId);
    }

    // İlan ID'sine göre başvuruları getiren servis yöntemi
    public List<Application> findApplicationsByAdvertId(Integer advertId) {
        return Repo.findApplicationsByAdvertId(advertId);
    }


    public Application createApplication(int userId, Application application) {
        Optional<Users> user = userRepo.findById(userId);
        if (!user.isPresent()) {
            throw new NoSuchElementException("User not found");
        }

        // Başvuruya tarih atıyoruz, kullanıcı bilgisini ekliyoruz
        application.setDate(new Date());
        application.setUser(user.get());

        // Başvuruyu kaydediyoruz ve oluşturulan başvuruyu dönüyoruz
        return Repo.save(application);
    }
    public List<Application> getApplicationsByUserIdWjwt(String jwt) {
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        return getApplicationsByUserId(user.getId());
    }
    public Application createApplicationJwt(String jwt,Application application){
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        // Başvuruya tarih atıyoruz, kullanıcı bilgisini ekliyoruz
        application.setDate(new Date());
        application.setUser(user);
        // Başvuruyu kaydediyoruz ve oluşturulan başvuruyu dönüyoruz
        return Repo.save(application);
    }
    public Application createApplicationIds(int userId, int advertId, Application application){
        Users user = userRepo.findById(userId).orElse(null);
        Advert advert = advertRepo.findById(advertId).orElse(null);

        application.setDate(new Date());
        application.setUser(user);
        application.setAdvert(advert);
        return Repo.save(application);

    }
}
