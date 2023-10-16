package com.talentstream.TestServices;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.talentstream.entity.ApplicantRegistration;
import com.talentstream.repository.RegisterRepository;
import com.talentstream.service.RegisterService;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
	@InjectMocks
    private RegisterService registerService;

    @Mock
    private RegisterRepository applicantRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        
        // Example: when(applicantRepository.findById(1L)).thenReturn(Optional.of(new ApplicantRegistration()));
    }

    @Test
    public void testLoginSuccessful() {
     
        String email = "example@email.com";
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";
      
        ApplicantRegistration mockApplicant = new ApplicantRegistration();
        mockApplicant.setEmail(email);
        mockApplicant.setPassword(encodedPassword);
        when(applicantRepository.findByEmail(email)).thenReturn(mockApplicant);
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(true);
     
        ApplicantRegistration result = registerService.login(email, rawPassword);
        assertNotNull(result);
    }

    @Test
    public void testLoginFailed() {
           String email = "example@email.com";
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";

        // Mock behavior of the repository and passwordEncoder
        ApplicantRegistration mockApplicant = new ApplicantRegistration();
        mockApplicant.setEmail(email);
        mockApplicant.setPassword(encodedPassword);
        when(applicantRepository.findByEmail(email)).thenReturn(mockApplicant);
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(false);
       
        ApplicantRegistration result = registerService.login(email, rawPassword);
        assertNull(result);
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        ApplicantRegistration mockApplicant = new ApplicantRegistration();
        when(applicantRepository.findById(id)).thenReturn(mockApplicant);
        ApplicantRegistration result = registerService.findById(id);
        assertNotNull(result);
    }

    @Test
    public void testGetAllApplicants() {
        
        List<ApplicantRegistration> applicants = List.of(new ApplicantRegistration(), new ApplicantRegistration());
        when(applicantRepository.findAll()).thenReturn(applicants);
        List<ApplicantRegistration> result = registerService.getAllApplicants();
        assertEquals(applicants, result);
    }

    @Test
    public void testUpdatePassword() {
        // Mock data and behavior
        String userEmail = "example@email.com";
        String newPassword = "newPassword";
        ApplicantRegistration mockApplicant = new ApplicantRegistration();
        when(applicantRepository.findByEmail(userEmail)).thenReturn(mockApplicant);

        // Test the updatePassword method
        assertDoesNotThrow(() -> registerService.updatePassword(userEmail, newPassword));
    }
}