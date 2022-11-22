package com.turbo.disease_management.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SpecializeDto {
    @NotEmpty(message = "Id should not be empty")
    private Integer id;
    @NotEmpty(message = "Email should not be empty")
	@Email
    private String email;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
