package com.example.vizyonervizyoner.User;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyRepo;
import com.example.vizyonervizyoner.Company.CompanyService;
import com.example.vizyonervizyoner.Util.JwtTokenUtil;
import com.example.vizyonervizyoner.auth.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final CompanyRepo companyRepo;
    @Autowired private JwtTokenUtil jwtTokenUtil;

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
    public RegisterDTO getUserByIdDTO(int userId) {
        Users user = userRepo.findById(userId).orElse(null);
        RegisterDTO registerDTO = new RegisterDTO();
        if(user != null){
            registerDTO.setEmail(user.getEmail());
            registerDTO.setFirstname(user.getFirstName());
            registerDTO.setLastname(user.getLastName());
        }
        return registerDTO;
    }
    public RegisterDTO getUserByIdDTOjwt(String jwt) {
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        RegisterDTO registerDTO = new RegisterDTO();
        if(user != null){
            registerDTO.setEmail(user.getEmail());
            registerDTO.setFirstname(user.getFirstName());
            registerDTO.setLastname(user.getLastName());
        }
        return registerDTO;
    }
    public Users updateUserByjwt(String jwt, RegisterDTO data){
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        user.setFirstName(data.getFirstname());
        user.setLastName(data.getLastname());
        user.setEmail(data.getEmail());
        saveUser(user);
        return user;
    }
    public List<Users> userListeleme() {
        return userRepo.findAll();
    }

    public Users savedUser(Users user) {
        return userRepo.save(user);
    }

    public Optional<Users> findUserById(int userId) {
        return userRepo.findById(userId);
    }

    public Users getOneUserByUserName(String email) {
        Optional<Users> optionalUser = userRepo.findByEmail(email);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            return existingUser;
        }
        return null;
    }

    public void deleteUserById(int userId) {
        userRepo.deleteById(userId);
    }

    public Company saveCompany(Company company) {
        return companyRepo.save(company);
    }

    public ResponseEntity<?> firmaEkle(int userId, Company company) {
        Optional<Users> optionalUser = userRepo.findById(userId);
        Users user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            return new ResponseEntity<>("Kullanıcı yok!", HttpStatus.BAD_REQUEST);
        }
        CompanyService companyService = new CompanyService();

        // Firma eklemek için kullanıcının zaten bir firması var mı kontrol edin
        if (companyService.firmaBilgileriAl(user.getId()) != null) {
            return new ResponseEntity<>("Zaten bir firma eklediniz!", HttpStatus.BAD_REQUEST);
        }

        company.setUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    public ResponseEntity<?> bosFirmaEkle(int userId) {
        Users user = userRepo.findById(userId).orElse(null);
        Company company = new Company();
        company.setUser(user);
        companyRepo.save(company);

        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    //Security..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");
        return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User is not valid"));

    }
}

