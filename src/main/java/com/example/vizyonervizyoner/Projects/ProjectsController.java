package com.example.vizyonervizyoner.Projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/projects")
public class ProjectsController {

    private ProjectsRepository Repo;

    @Autowired
    public ProjectsController(ProjectsRepository Repo, ProjectsService projectsService) {
        this.Repo = Repo;
        this.projectsService = projectsService;
    }
    private final ProjectsService projectsService;
    @GetMapping("/listeleme")
    public List<Projects> projeListeleme() {
        return projectsService.projeListeleme();
    }

    @GetMapping("/bilgilerigetir/{id}")
    public ResponseEntity<Projects> projeBilgileriGetir(@PathVariable int id) {

        Optional<Projects> projects =Repo.findById(id); // findById yöntemini kullanıyoruz
        if (projects.isPresent()) {
            return new ResponseEntity<>(projects.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping ("/guncelleme/{id}")
    public ResponseEntity<Projects> projeGuncelle(@PathVariable int id, @RequestBody Projects updatedProjects) {
        Projects projects = projectsService.projeGuncelle(id, updatedProjects);
        if (projects != null) {
            return new ResponseEntity<>(projects, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
