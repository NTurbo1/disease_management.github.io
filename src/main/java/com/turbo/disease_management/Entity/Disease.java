package com.turbo.disease_management.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Disease")
public class Disease {
    @Id
    private String diseaseCode;
    private String pathogen;
    private String description;
    private Integer id;

    public String getPathogen() {
        return pathogen;
    }
    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDiseaseCode() {
        return diseaseCode;
    }
    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }
    
    
}
