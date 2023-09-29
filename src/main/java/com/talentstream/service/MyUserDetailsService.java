package com.talentstream.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.talentstream.entity.ApplicantRegistration;
import com.talentstream.entity.JobRecruiter;
import com.talentstream.repository.JobRecruiterRepository;
import com.talentstream.repository.RegisterRepository;
@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {
	// private PasswordEncoder passwordEncoder;
	    
	   @Autowired
      JobRecruiterRepository recruiterRepository;
	   @Autowired
	   RegisterRepository applicantRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JobRecruiter jobRecruiter=null;
		try{
			  jobRecruiter = recruiterRepository.findByEmail(username);// Check if the email exists in the JobRecruiter repository
		}
	    catch(UsernameNotFoundException e){
	    	System.out.println("loadusername recruiter");
		    System.out.println(jobRecruiter.getEmail());
	    }
		
	    if (jobRecruiter != null) {
	        // Email belongs to a recruiter
	    	return  new User(jobRecruiter.getEmail(), jobRecruiter.getPassword(),Arrays.stream(jobRecruiter.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()));
	    }
	    else {
	        // Email doesn't exist in the recruiter repository, check the Applicant repository
	    	ApplicantRegistration applicant = applicantRepository.findByEmail(username);
	    	System.out.println("loadusername applicant");
	    	System.out.println(applicant.getEmail());
	        if (applicant != null) {
	            // Email belongs to an applicant
	        	return  new User(applicant.getEmail(), applicant.getPassword(),Arrays.stream(applicant.getRoles().split(","))
	    				.map(SimpleGrantedAuthority::new)
	    				.collect(Collectors.toList()));
	        } else {
	            // Neither a recruiter nor an applicant with this email was found
	            throw new UsernameNotFoundException("User not found with email: " + username);
	        }
	    }
	}
}


