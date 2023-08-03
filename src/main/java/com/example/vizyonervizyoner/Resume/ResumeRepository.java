package com.example.vizyonervizyoner.Resume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    // Özel sorguları buraya ekleyebilirsiniz (eğer gerekiyorsa)
}
