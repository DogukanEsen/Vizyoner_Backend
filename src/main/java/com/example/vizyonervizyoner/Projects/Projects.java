package com.example.vizyonervizyoner.Projects;

import com.example.vizyonervizyoner.User.Users;
import jakarta.persistence.*;

@Entity
@Table(name="projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="title",nullable=false)
    private String title;
    @Column(name="content")
    private String content;
    @Column(name = "thumbnail")
    private byte[] thumbnail;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "githublink")
    private String githubLink;

    @Column(name = "videolink")
    private String videoLink;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private Users users;

    // Constructors
    public Projects(){
    }
    public Projects(int id, String title, String content, byte[] thumbnail, byte[] image, String githubLink, String videoLink, Users users) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.image = image;
        this.githubLink = githubLink;
        this.videoLink = videoLink;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}

