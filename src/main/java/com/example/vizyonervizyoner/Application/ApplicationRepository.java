package com.example.vizyonervizyoner.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query("SELECT a FROM Application a WHERE a.user.id = :userId")
    List<Application> findByUserId(int userId);
    @Query("SELECT a FROM Application a WHERE a.advert.id = :advertId")
    List<Application> findApplicationsByAdvertId(Integer advertId);


    // List<Application> findByUserId(int userId);
    //List<Application> findApplicationsByAdvertId(Integer advertId);


}
