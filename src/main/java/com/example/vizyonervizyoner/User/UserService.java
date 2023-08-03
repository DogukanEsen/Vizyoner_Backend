package com.example.vizyonervizyoner.User;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final CompanyRepo companyRepo;

    @Autowired
    public UserService(UserRepo userRepo, CompanyRepo companyRepo) {
        this.userRepo = userRepo;
        this.companyRepo = companyRepo;
    }

    public Users saveUser(Users userEntity) {
        return userRepo.save(userEntity);
    }
    public Optional<Users> getUserById(int userId) {
        return userRepo.findById(userId);
    }

    public Company saveCompany(Company company) {
        return companyRepo.save(company);
    }

    /*public ResponseEntity<?> firmaEkle(int userId, Company company) {
        Optional<Users> optionalUser = userRepo.findById(userId);
        Users user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            return new ResponseEntity<>("Kullanıcı yok!", HttpStatus.BAD_REQUEST);
        }

        if (user.getRole() != 1) { // Kurumsal kullanıcı değilse
            return new ResponseEntity<>("Kurumsal kullanıcı değilsiniz, firma ekleyemezsiniz!", HttpStatus.BAD_REQUEST);
        }

        // Firma eklemek için kullanıcının zaten bir firması var mı kontrol edin
        if (company.findcompbyuserid(user.getId()) != null) {
            return new ResponseEntity<>("Zaten bir firma eklediniz!", HttpStatus.BAD_REQUEST);
        }

        company.setUser(user.getId());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }*/
    //Security..
    @Autowired private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");
        return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User is not valid"));

    }
}

