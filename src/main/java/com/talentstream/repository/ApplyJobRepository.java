package com.talentstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentstream.entity.ApplyJob;
@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJob, Long> {

}