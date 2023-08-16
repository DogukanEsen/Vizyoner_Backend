package com.example.vizyonervizyoner.Resume;

import com.example.vizyonervizyoner.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    @Query("SELECT r FROM Resume r WHERE r.id=:id")
    Optional<Resume> findResumeById (int id);
    @Query("SELECT r FROM Resume r WHERE r.userid = :users")
    Optional<Resume> findResumeByUserId(Users users);
    @Query("SELECT id FROM Resume r WHERE r.userid = :users")
    Optional<Integer> findResumeIdByUserId(Users users);
}