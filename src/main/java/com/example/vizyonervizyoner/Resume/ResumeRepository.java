package com.example.vizyonervizyoner.Resume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    @Query("SELECT r FROM Resume r WHERE r.id=:id")
    Optional<Resume> findResumeById (int id);


}