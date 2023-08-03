package com.example.vizyonervizyoner.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // GET endpoint to retrieve all resumes
    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }

    // GET endpoint to retrieve a single resume by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        Resume resume = resumeService.getResumeById(id);
        if (resume != null) {
            return new ResponseEntity<>(resume, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST endpoint to create a new resume
    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        Resume createdResume = resumeService.createResume(resume);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    // PUT endpoint to update an existing resume
    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody Resume resume) {
        Resume updatedResume = resumeService.updateResume(id, resume);
        if (updatedResume != null) {
            return new ResponseEntity<>(updatedResume, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE endpoint to delete a resume by its ID
    //deneme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        boolean deleted = resumeService.deleteResume(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

