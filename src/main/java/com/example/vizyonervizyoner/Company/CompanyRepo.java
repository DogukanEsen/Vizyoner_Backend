package com.example.vizyonervizyoner.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    // Özel sorgular veya işlemler gerekiyorsa burada tanımlayabilirsiniz.
    @Query("SELECT c FROM Company c WHERE c.userID = :id")
    Optional<Company> findCompByUserId(int id);

}