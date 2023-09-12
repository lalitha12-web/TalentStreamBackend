package com.talentstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.talentstream.service.JwtUtil;
import com.talentstream.response.ResponseHandler;
import com.talentstream.entity.AuthenticationResponse;
import com.talentstream.entity.JobRecruiter;
import com.talentstream.entity.RecruiterLogin;

import com.talentstream.service.JobRecruiterService;

@RestController

public class JobRecruiterController {
	
	@Autowired
     JobRecruiterService recruiterService;
     @Autowired
 	private AuthenticationManager authenticationManager;
     @Autowired
 	private JwtUtil jwtTokenUtil;
    @Autowired
    public JobRecruiterController(JobRecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping("/saveRecruiters")
    public ResponseEntity<String> registerRecruiter(@RequestBody JobRecruiter recruiter) {
        return recruiterService.saveRecruiter(recruiter);
    }
    
    @PostMapping("/authenticate")
    public ResponseEntity<Object> login(@RequestBody RecruiterLogin loginRequest) throws Exception {
        boolean loginResult = recruiterService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (loginResult) {
        	return createAuthenticationToken(loginRequest);
        } else {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }
    
    private ResponseEntity<Object> createAuthenticationToken(@RequestBody RecruiterLogin loginRequest) throws Exception {
		// TODO Auto-generated method stub
    	try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
    	final UserDetails userDetails = recruiterService.loadUserByUsername(loginRequest.getEmail());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

  
		return ResponseHandler.generateResponse("Login successfully"+userDetails.getAuthorities(), HttpStatus.OK, new AuthenticationResponse(jwt));
	}

	@GetMapping("/viewRecruiters")
    public ResponseEntity<List<JobRecruiter>> getAllJobRecruiters() {
        List<JobRecruiter> jobRecruiters = recruiterService.getAllJobRecruiters();
        return ResponseEntity.ok(jobRecruiters);
    }
}
