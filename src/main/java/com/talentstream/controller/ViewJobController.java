package com.talentstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.Job;
import com.talentstream.service.ViewJobService;
@RestController
public class ViewJobController {
	@Autowired
    private ViewJobService viewJobService;

    @GetMapping("/applicant/{jobId}/{applicantId}")
    public ResponseEntity<?> getJobDetailsForApplicant(
            @PathVariable Integer applicantId,
            @PathVariable Long jobId) {
        try {
            
            if (!applicantExists(applicantId)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Applicant with ID " + applicantId + " not found.");
            }

            // Attempt to retrieve the job details
            Job jobDetails = viewJobService.getJobDetails(jobId);

            // Check if the job exists
            if (jobDetails == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Job with ID " + jobId + " not found.");
            }

            return ResponseEntity.ok(jobDetails);
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching job details.");
        }
    }

    
    private boolean applicantExists(Integer applicantId) {
      
        return true;
    }
}
