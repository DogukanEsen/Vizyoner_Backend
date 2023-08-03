package com.example.vizyonervizyoner.User;
import com.example.vizyonervizyoner.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    static void setCompany(Company company) {
    }
    // Özel sorguları eklemek için gerekli metotları buraya yazabilirsiniz.
    Optional<Users> findByEmail(String email);

}
