package com.turbo.disease_management.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class DoctorDto {
    @NotEmpty(message = "Email should not be empty")
	@Email
    private String email;
    @NotEmpty(message = "Degree should not be empty")
    private String degree;
    public String getEmail() {
        return email;
    }
    public String getDegree() {
        return degree;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    
}
