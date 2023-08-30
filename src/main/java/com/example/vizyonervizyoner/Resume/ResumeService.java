package com.example.vizyonervizyoner.Resume;

import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.User.Users;
import com.example.vizyonervizyoner.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepo userRepo;
    @Autowired private JwtTokenUtil jwtTokenUtil;
    @Autowired
    public ResumeService(ResumeRepository resumeRepository, UserRepo userRepo) {
        this.resumeRepository = resumeRepository;
        this.userRepo = userRepo;
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Resume getResumeById(int id) {
        return resumeRepository.findById(id).orElse(null);
    }

    public Resume createResume(int id) {
        Resume resume = new Resume();
        Users user = userRepo.findById(id).orElse(null);
        resume.setUsers(user);
        return resumeRepository.save(resume);
    }

    public Resume updateResume(int id, Resume resume) {
        Resume existingResume = resumeRepository.findById(id).orElse(null);
        if (existingResume != null) {
            existingResume.setCategory(resume.getCategory());
            existingResume.setPhone(resume.getPhone());
            existingResume.setImage(resume.getImage());
            existingResume.setCountry(resume.getCountry());
            existingResume.setCity(resume.getCity());
            existingResume.setAddress(resume.getAddress());
            existingResume.setGpa(resume.getGpa());
            existingResume.setGrade(resume.getGrade());
            existingResume.setDepartment(resume.getDepartment());
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
    public Resume getResumeByUserId(int id) {
        Users user = userRepo.findById(id).orElse(null);
        return resumeRepository.findResumeByUserId(user).orElse(null);
    }
    public Resume getResumeByUserIdjwt(String jwt) {
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        return resumeRepository.findResumeByUserId(user).orElse(null);
    }
    public Resume updateResumeByUserId(int id, Resume resume){
        Users user = userRepo.findById(id).orElse(null);
        Resume existingResume = resumeRepository.findResumeByUserId(user).orElse(null);
        if (existingResume != null) {
            existingResume.setCategory(resume.getCategory());
            existingResume.setPhone(resume.getPhone());
            existingResume.setImage(resume.getImage());
            existingResume.setCountry(resume.getCountry());
            existingResume.setCity(resume.getCity());
            existingResume.setAddress(resume.getAddress());
            existingResume.setGpa(resume.getGpa());
            existingResume.setGrade(resume.getGrade());
            existingResume.setDepartment(resume.getDepartment());
            existingResume.setDescription(resume.getDescription());
            existingResume.setUsers(user);
            return resumeRepository.save(existingResume);
        } else {
            return null;
        }
    }
    public Resume updateResumeByUserIdjwt(String jwt, Resume resume){
        Users user = jwtTokenUtil.getUsersWjwt(jwt);
        Resume existingResume = resumeRepository.findResumeByUserId(user).orElse(null);
        if (existingResume != null) {
            existingResume.setCategory(resume.getCategory());
            existingResume.setPhone(resume.getPhone());
            existingResume.setImage(resume.getImage());
            existingResume.setCountry(resume.getCountry());
            existingResume.setCity(resume.getCity());
            existingResume.setAddress(resume.getAddress());
            existingResume.setGpa(resume.getGpa());
            existingResume.setGrade(resume.getGrade());
            existingResume.setDepartment(resume.getDepartment());
            existingResume.setDescription(resume.getDescription());
            existingResume.setUsers(user);
            return resumeRepository.save(existingResume);
        } else {
            return null;
        }
    }
}
