package com.turbo.disease_management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Public_servant")
public class PublicServant {
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "department", nullable = false)
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
