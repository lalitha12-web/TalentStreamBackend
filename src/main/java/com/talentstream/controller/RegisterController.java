package com.talentstream.controller;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.talentstream.entity.Login;
import com.talentstream.entity.Register;
import com.talentstream.entity.RegisterwithOTP;
import com.talentstream.service.RegisterService;
public class RegisterController {
	@Autowired
    private RegisterService registerService;

    @PostMapping("/api/applicant-register")
    public ResponseEntity<RegisterwithOTP> register(@RequestBody Register register) throws MessagingException {
        return new ResponseEntity<>(registerService.register(register), HttpStatus.OK);
    }

    @PutMapping("/api/applicant-verifyaccount")
    public ResponseEntity<String> verifyAccount(@RequestBody String email,
                                                @RequestBody String otp) {
        return new ResponseEntity<>(registerService.verifyAccount(email, otp), HttpStatus.OK);
    }

    @PutMapping("/api/applicant-regenerateotp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email) {
        return new ResponseEntity<>(registerService.regenerateOtp(email), HttpStatus.OK);
    }

    @PutMapping("/api/applicant-login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        return new ResponseEntity<>(registerService.login(login), HttpStatus.OK);
    }
    @PutMapping("/api/applicant/passwordforgotoption")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> requestMap) {
        String email = requestMap.get("email");
        return new ResponseEntity<>(registerService.forgotPassword(email), HttpStatus.OK);
    }



   /* @GetMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email) {
        // Implement the logic to handle password reset here
        return new ResponseEntity<>("Password reset link clicked for: " + email, HttpStatus.OK);
    }*/
      @PutMapping("/api/applicant/set-newpassword")
      public ResponseEntity<String> setPassword(@RequestBody Map<String, String> requestMap) {
          String email = requestMap.get("email");
          String password = requestMap.get("password");
          return new ResponseEntity<>(registerService.setPassword(email, password), HttpStatus.OK);
      }
}
