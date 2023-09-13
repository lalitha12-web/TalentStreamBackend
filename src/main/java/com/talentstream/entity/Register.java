package com.talentstream.entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Register {
	@NotBlank
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]{3,19}$", message = "invalid name")
    private String name;

    @NotBlank
    @Email(message = "invalid email address")
    private String email;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobilenumber;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;
    

}
