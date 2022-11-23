package com.turbo.disease_management.Dto;

import java.math.BigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {
	@NotEmpty(message = "Email should not be empty")
	@Email
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
	private BigInteger salary;
    @NotEmpty
	private String phone;
    @NotEmpty
	private String cname;
	@NotEmpty(message = "Password should not be empty")
    private String password;
	@NotEmpty
	private String occupation;
    
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigInteger getSalary() {
		return salary;
	}
	public void setSalary(BigInteger salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
    
    
}

