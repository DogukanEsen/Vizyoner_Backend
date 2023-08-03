package com.example.vizyonervizyoner.Projects;

import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.User.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
    /* @Modifying
     @Query("UPDATE Projects p SET p.title = :title, p.content = :content, p.thumbnail = :thumbnail, p.image = :image, p.githubLink = :githubLink, p.videoLink = :videoLink, p.users = :users WHERE p.id = :id")
     void updateProject(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("thumbnail") byte[] thumbnail, @Param("image") byte[] image, @Param("githubLink") String githubLink, @Param("videoLink") String videoLink, @Param("users") Users users);
 */
    @Query("SELECT p FROM Projects p WHERE p.id=:id")
    Optional<Projects> findProjectsbyId(int id);
}
