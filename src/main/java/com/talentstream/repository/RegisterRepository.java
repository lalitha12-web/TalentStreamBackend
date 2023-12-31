package com.talentstream.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

 

 

import com.talentstream.entity.ApplicantRegistration;

 

@Repository

public interface RegisterRepository extends JpaRepository<ApplicantRegistration, Integer> {
	ApplicantRegistration  findByEmail(String email);
	boolean existsByEmail(String email);
	ApplicantRegistration findById(Long id);

 

	

}