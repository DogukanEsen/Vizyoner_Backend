package com.example.vizyonervizyoner.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    // Özel sorgular veya işlemler gerekiyorsa burada tanımlayabilirsiniz.
}