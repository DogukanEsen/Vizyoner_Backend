package com.example.vizyonervizyoner.Company;

import com.example.vizyonervizyoner.User.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "type", nullable = false)
    private boolean type;
    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private Users userID;

    @Column(name = "image")
    private String image;

    public Company() {
    }

    public Company(int id, String name, String content, String category, boolean type, Users userID,String image) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.category = category;
        this.type = type;
        this.userID = userID;
        this.image=image;
    }

    public Company(String name, String content, String category, boolean type, Users userID,String image) {
        this.name = name;
        this.content = content;
        this.category = category;
        this.type = type;
        this.userID = userID;
        this.image=image;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Users getUser() {
        return userID;
    }

    public void setUser(Users userID) {
        this.userID = userID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}