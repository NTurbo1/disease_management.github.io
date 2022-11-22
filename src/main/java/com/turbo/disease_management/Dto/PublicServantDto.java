package com.turbo.disease_management.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class PublicServantDto {
    @NotEmpty(message = "Email should not be empty")
	@Email
    private String email;
    @NotEmpty(message = "Department should not be empty")
    private String department;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    
}
