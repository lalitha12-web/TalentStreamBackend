package com.talentstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentstream.entity.ApplicantProfile;
@Repository
public interface ApplicantProfileRepository extends JpaRepository<ApplicantProfile, Integer> {


}