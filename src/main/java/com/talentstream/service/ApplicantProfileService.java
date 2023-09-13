package com.talentstream.service;
import com.jobapplicant.example.Frontendversion.Entity.ApplicantProfile;
import com.jobapplicant.example.Frontendversion.Repository.ApplicantProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantProfileService {
	 private final ApplicantProfileRepository applicantProfileRepository;

	    @Autowired
	    public ApplicantProfileService(ApplicantProfileRepository applicantProfileRepository) {
	        this.applicantProfileRepository = applicantProfileRepository;
	    }

	    public ApplicantProfile createOrUpdateApplicantProfile(ApplicantProfile applicantProfile) {
	        return applicantProfileRepository.save(applicantProfile);
	    }

	    public ApplicantProfile getApplicantProfileById(int applicantId) {
	        return applicantProfileRepository.findById(applicantId).orElse(null);
	    }

	    public void deleteApplicantProfile(int applicantId) {
	        applicantProfileRepository.deleteById(applicantId);
	    }

}
