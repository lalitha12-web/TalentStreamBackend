package com.talentstream.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.jsonwebtoken.lang.Collections;
@Getter
@Setter
@Entity
public class ApplicantProfile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicantid;

    @Embedded
    private BasicDetails basicDetails;

    @Embedded
    private XClassDetails xClassDetails;

    @Embedded
    private IntermediateDetails intermediateDetails;

    @Embedded
    private GraduationDetails graduationDetails;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<ExperienceDetails> experienceDetails;
    @Column(nullable = false)
    private String roles="ROLE_JOBAPPLICANT";

	public long getApplicantid() {
		return applicantid;
	}

	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}

	public BasicDetails getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(BasicDetails basicDetails) {
		this.basicDetails = basicDetails;
	}

	public XClassDetails getxClassDetails() {
		return xClassDetails;
	}

	public void setxClassDetails(XClassDetails xClassDetails) {
		this.xClassDetails = xClassDetails;
	}

	public IntermediateDetails getIntermediateDetails() {
		return intermediateDetails;
	}

	public void setIntermediateDetails(IntermediateDetails intermediateDetails) {
		this.intermediateDetails = intermediateDetails;
	}

	public GraduationDetails getGraduationDetails() {
		return graduationDetails;
	}

	public void setGraduationDetails(GraduationDetails graduationDetails) {
		this.graduationDetails = graduationDetails;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<ExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(List<ExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}
    
    
  
    


	
}
