package com.example.vizyonervizyoner.Company;

import com.example.vizyonervizyoner.User.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private Users user;

    public Company() {
    }

    public Company(Long id, String name, String content, String category, boolean type, Users user) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.category = category;
        this.type = type;
        this.user = user;
    }

    public Company(String name, String content, String category, boolean type, Users user) {
        this.name = name;
        this.content = content;
        this.category = category;
        this.type = type;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


}
