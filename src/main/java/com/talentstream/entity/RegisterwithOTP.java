package com.talentstream.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

public class RegisterwithOTP {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private String email;
	    private String mobilenumber;
	    private String password;
	    private String otp;
	    private LocalDateTime otpGeneratedTime;

}
