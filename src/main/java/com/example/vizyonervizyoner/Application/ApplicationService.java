package com.example.vizyonervizyoner.Application;

import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import org.apache.catalina.User;
import org.flywaydb.core.internal.parser.PlaceholderReplacingReader;
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

}
