package com.turbo.disease_management.Entity;

import javax.persistence.Table;

@Table(name="Specialize")
public class Specialize {
    private int id;
    private String email;
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
