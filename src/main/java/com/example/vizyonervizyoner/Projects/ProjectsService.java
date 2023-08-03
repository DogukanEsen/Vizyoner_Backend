package com.example.vizyonervizyoner.Projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    private final ProjectsRepository repo;

    @Autowired
    public ProjectsService(ProjectsRepository projectsRepository) {
        this.repo = projectsRepository;
    }

    public List<Projects> projeListeleme() {
        return repo.findAll();
    }

    public Optional<Projects> projeBilgileriGetir(int id) {
        return repo.findById(id);
    }

    public Projects projeGuncelle(int id, Projects updatedProject) {
        Optional<Projects> projects = repo.findProjectsbyId(id);
        if (projects.isPresent()) {
            Projects existingProject = projects.get();
            //Proje Bilgilerini Güncelleme
            existingProject.setTitle(updatedProject.getTitle());
            existingProject.setContent(updatedProject.getContent());
            existingProject.setThumbnail(updatedProject.getThumbnail());
            existingProject.setImage(updatedProject.getImage());
            existingProject.setGithubLink(updatedProject.getGithubLink());
            existingProject.setVideoLink(updatedProject.getVideoLink());
            existingProject.setUsers(updatedProject.getUsers());
            //güncellenmiş bilgileri kaydetme
            return repo.save(existingProject);
        }
        return null;
    }
}

