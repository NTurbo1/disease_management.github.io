package com.turbo.disease_management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Specialize")
public class Specialize {
    @Column(name = "id", nullable = false)
    private Integer id;
    @Id
    @Column(name = "email", nullable = false)
    private String email;

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
