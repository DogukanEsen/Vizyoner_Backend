package com.example.vizyonervizyoner.Advert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {

    // Bir şirkete ait tüm ilanları getir
    @Query("SELECT a FROM Advert a WHERE a.company.id = :companyId")
    List<Advert> findAdvertsByCompanyId(Integer companyId);





}
