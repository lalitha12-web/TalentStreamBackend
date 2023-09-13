package com.talentstream.repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterwithOTP, Integer> {
    Optional<RegisterwithOTP> findByEmail(String email);

}