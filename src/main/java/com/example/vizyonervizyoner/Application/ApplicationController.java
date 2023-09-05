package com.example.vizyonervizyoner.Application;

import com.example.vizyonervizyoner.Advert.Advert;
import com.example.vizyonervizyoner.Advert.AdvertService;
import com.example.vizyonervizyoner.User.UserService;
import com.example.vizyonervizyoner.User.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final UserService userService;
    private final AdvertService advertService;
    private ApplicationRepository Repo;

    private ApplicationController(ApplicationRepository Repo, ApplicationService applicationService, UserService userService, AdvertService advertService) {
        this.Repo = Repo;
        this.applicationService = applicationService;
        this.userService = userService;
        this.advertService = advertService;
    }

    @GetMapping("/listeleme")
    public List<Application> basvurulistele() {
        return applicationService.basvurulistele();
    }

    //Kullanıcıya göre basvuru listeleme
    @GetMapping("/users/{userId}/applications")
    public ResponseEntity<List<Application>> getUserApplications(@PathVariable int userId) {
        List<Application> applications = applicationService.getApplicationsByUserId(userId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    @GetMapping("/jwtusers/{jwt}/applications")
    public ResponseEntity<List<Application>> getUserApplicationsJwt(@PathVariable String jwt){
        List<Application> applications = applicationService.getApplicationsByUserIdWjwt(jwt);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    // İlan ID'sine göre başvuruları getiren endpoint
    @GetMapping("/advert/{advertId}")
    public ResponseEntity<List<Application>> getApplicationsByAdvertId(@PathVariable Integer advertId) {
        List<Application> applications = applicationService.findApplicationsByAdvertId(advertId);
        if (applications != null && !applications.isEmpty()) {
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*
    @PostMapping("/users/{userId}/applications")
    public ResponseEntity<Application> createApplication(@PathVariable int userId, @RequestBody Application application) {
        // Başvuruyu oluşturuyoruz
        Application newApplication = applicationService.createApplication(userId, application);
        return new ResponseEntity<>(newApplication, HttpStatus.CREATED);
    }
    */
// Yeni bir başvuru eklemek için POST metodunu tanımlıyoruz
    @PostMapping("/users/{userId}/adverts/{advertId}/applications")
    public ResponseEntity<Application> createApplication(
            @PathVariable int userId,
            @PathVariable int advertId,
            @RequestBody Application application
    ) {

        // İlan var mı kontrol et
        Optional<Advert> optionalAdvert = Optional.ofNullable(advertService.getAdvertById(advertId));
        if (!optionalAdvert.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Kullanıcı var mı kontrol et
        Optional<Users> optionalUser = userService.getUserById(userId);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Başvuruyu oluştur
        Advert advert = optionalAdvert.get();
        Users user = optionalUser.get();

        application.setUser(user);
        application.setAdvert(advert);
        application.setDate(new Date());

        Application newApplication = applicationService.createApplication(userId,application);
        return new ResponseEntity<>(newApplication, HttpStatus.CREATED);
    }
    @PostMapping("/usersjwt/{jwt}/adverts/{advertId}/applications")
    public ResponseEntity<Application> createApplicationJwt(
            @PathVariable String jwt,
            @PathVariable int advertId,
            @RequestBody Application application
    ) {

        // İlan var mı kontrol et
        Optional<Advert> optionalAdvert = Optional.ofNullable(advertService.getAdvertById(advertId));
        if (!optionalAdvert.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Başvuruyu oluştur
        Advert advert = optionalAdvert.get();

        application.setAdvert(advert);
        application.setDate(new Date());

        Application newApplication = applicationService.createApplicationJwt(jwt,application);
        return new ResponseEntity<>(newApplication, HttpStatus.CREATED);
    }
}
