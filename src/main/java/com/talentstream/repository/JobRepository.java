package com.talentstream.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.talentstream.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	@Query("SELECT DISTINCT j FROM Job j JOIN j.skillsRequired s WHERE s.skillName = :skillName")
    Page<Job> findJobsBySkillName(String skillName, Pageable pageable);
		List<Job> findByJobTitleContainingIgnoreCase(String jobTitle);
	List<Job> findByLocationContainingIgnoreCase(String location);
	List<Job> findByIndustryTypeContainingIgnoreCase(String industryType);
	List<Job> findByEmployeeTypeContainingIgnoreCase(String employeeType);
	List<Job> findByMinimumQualificationContainingIgnoreCase(String minimumQualification);
	List<Job> findBySpecializationContainingIgnoreCase(String specialization);
	List<Job> findBySkillsRequiredSkillName(String skillName);
	List<Job> findBySkillsRequiredSkillNameAndSkillsRequiredMinimumExperience(String skillName, int minimumExperience);


}
