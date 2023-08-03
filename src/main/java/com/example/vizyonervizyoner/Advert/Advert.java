package com.example.vizyonervizyoner.Advert;

import com.example.vizyonervizyoner.Company.Company;
import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "updatedate")
    private LocalDate updateDate;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "location")
    private String location;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;


    public Advert() {
    }

    public Advert(LocalDate updateDate, String title, String description, LocalDate startDate, LocalDate endDate, byte[] image, String location, String category, Company company) {
        this.updateDate = updateDate;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.location = location;
        this.category = category;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public Advert(int id, LocalDate updateDate, String title, String description, LocalDate startDate, LocalDate endDate, byte[] image, String location, String category, Company company) {
        this.id = id;
        this.updateDate = updateDate;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = image;
        this.location = location;
        this.category = category;
        this.company = company;
    }


}

