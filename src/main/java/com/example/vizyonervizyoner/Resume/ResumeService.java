package com.example.vizyonervizyoner.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Resume getResumeById(int id) {
        return resumeRepository.findById(id).orElse(null);
    }

    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public Resume updateResume(int id, Resume resume) {
        Resume existingResume = resumeRepository.findById(id).orElse(null);
        if (existingResume != null) {
            existingResume.setCategory(resume.getCategory());
            existingResume.setTc(resume.getTc());
            existingResume.setPhone(resume.getPhone());
            existingResume.setImage(resume.getImage());
            existingResume.setCountry(resume.getCountry());
            existingResume.setCity(resume.getCity());
            existingResume.setAddress(resume.getAddress());
            existingResume.setGpa(resume.getGpa());
            existingResume.setGrade(resume.getGrade());
            existingResume.setDepartment(resume.getDepartment());
            existingResume.setResumeFile(resume.getResumeFile());
            existingResume.setDescription(resume.getDescription());
            existingResume.setUsers(resume.getUsers());
            return resumeRepository.save(existingResume);
        } else {
            return null;
        }
    }

    public boolean deleteResume(int id) {
        Resume existingResume = resumeRepository.findById(id).orElse(null);
        if (existingResume != null) {
            resumeRepository.delete(existingResume);
            return true;
        } else {
            return false;
        }
    }
}
