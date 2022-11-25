package com.turbo.disease_management.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DiseaseDto {
    @NotEmpty(message = "Disease code should not be empty")
    @Size(min=1, max=50)
    private String diseaseCode;
    @NotEmpty(message = "Pathogen should not be empty")
    @Size(min=1, max=20)
    private String pathogen;
    @NotEmpty(message = "Description should not be empty")
    private String description;
    @Min(value = 0)
    @Max(value = 10)
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
