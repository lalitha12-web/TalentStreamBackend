package com.talentstream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.Job;

import com.talentstream.repository.JobRepository;
import com.talentstream.repository.RecuriterSkillsRepository;

@Service
public class JobService {
	JobRepository jobRepository;	   
	    private RecuriterSkillsRepository skillsRepository;
	    
    @Autowired
    public JobService(JobRepository jobRepository, RecuriterSkillsRepository skillsRepository) {
        this.jobRepository = jobRepository;
        this.skillsRepository = skillsRepository;
    }

 

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }
    public List<Job> searchByJobTitle(String jobTitle) {
        return jobRepository.findByJobTitleContainingIgnoreCase(jobTitle);
    }

    public List<Job> searchByLocation(String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Job> searchByIndustryType(String industryType) {
        return jobRepository.findByIndustryTypeContainingIgnoreCase(industryType);
    }
    public List<Job> searchByEmployeeType(String employeeType) {
        return jobRepository.findByEmployeeTypeContainingIgnoreCase(employeeType);
    }
    public List<Job> searchByMinimumQualification(String minimumQualification) {
        return jobRepository.findByMinimumQualificationContainingIgnoreCase(minimumQualification);
    }
    public List<Job> searchBySpecialization(String specialization) {
        return jobRepository.findBySpecializationContainingIgnoreCase(specialization);
    }
    public List<Job> searchBySkillNameAndExperience(String skillName, int minimumExperience) {
        return jobRepository.findBySkillsRequiredSkillNameAndSkillsRequiredMinimumExperience(skillName, minimumExperience);
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}