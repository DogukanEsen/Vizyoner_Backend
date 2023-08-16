package com.example.vizyonervizyoner.Resume;

import com.example.vizyonervizyoner.User.Users;
import jakarta.persistence.Entity;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "phone")
    private String phone;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "grade")
    private String grade;

    @Column(name = "department")
    private String department;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private Users userid;

    public Resume() {
    }

    public Resume(int id, String category, String phone, byte[] image, String country, String city,
                  String address, Double gpa, String grade, String department,
                  String description, Users users) {
        this.id = id;
        this.category = category;
        this.phone = phone;
        this.image = image;
        this.country = country;
        this.city = city;
        this.address = address;
        this.gpa = gpa;
        this.grade = grade;
        this.department = department;
        this.description = description;
        this.userid=users;
    }

    public Users getUsers() {
        return userid;
    }

    public void setUsers(Users users) {
        this.userid = users;
    }

    public Resume(String category, String phone, byte[] image, String country, String city, String address, Double gpa, String grade, String department, String description, Users users) {
        this.category = category;
        this.phone = phone;
        this.image = image;
        this.country = country;
        this.city = city;
        this.address = address;
        this.gpa = gpa;
        this.grade = grade;
        this.department = department;
        this.description = description;
        this.userid = users;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {

        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

