package com.example.vizyonervizyoner.Application;

import com.example.vizyonervizyoner.Advert.Advert;
import com.example.vizyonervizyoner.User.Users;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "content")
    private String content;

    @Column(name = "file")
    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "advertID", referencedColumnName = "id")
    private Advert advert;
    public Application() {
    }
    public Application(int id, Date date, String content, byte[] file, Users user, Advert advert) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.file = file;
        this.user = user;
        this.advert = advert;
    }

    public Application(Date date, String content, byte[] file, Users user, Advert advert) {
        this.date = date;
        this.content = content;
        this.file = file;
        this.user = user;
        this.advert = advert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}
