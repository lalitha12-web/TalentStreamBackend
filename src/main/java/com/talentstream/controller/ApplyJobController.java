package com.talentstream.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.entity.ApplyJob;
import com.talentstream.entity.Job;
import com.talentstream.repository.ApplicantProfileRepository;
import com.talentstream.repository.JobRepository;
import com.talentstream.service.ApplyJobService;

@RestController
public class ApplyJobController {
	 @Autowired
	    private ApplyJobService applyJobService;
	 
	 @Autowired
	 private ApplicantProfileRepository applicantProfileRepository;
	 
	 @Autowired
	 private JobRepository jobRepository;

	 @PostMapping("/{applicantId}/applyjob/{jobId}")
	    public ResponseEntity<String> applyForJob(
	            @PathVariable int applicantId,
	            @PathVariable long jobId) {
	        Optional<ApplicantProfile> applicantOptional = applicantProfileRepository.findById(applicantId);
	        Optional<Job> jobOptional = jobRepository.findById(jobId);

	        if (applicantOptional.isEmpty() || jobOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid applicant or job.");
	        }

	        ApplyJob applyJob = applyJobService.applyForJob(applicantOptional.get(), jobOptional.get());
	        return ResponseEntity.ok("Job application submitted with ID: " + applyJob.getId());
	    }
	    
	    
}
