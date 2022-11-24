package com.turbo.disease_management.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class RecordDto {
    @NotEmpty(message = "Id should not be empty")
    private Integer recordId;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Country name should not be empty")
    private String cname;
    @NotEmpty(message = "Disease code should not be empty")
    private String diseaseCode;
    private String total_deaths;
    private String total_patients;
    
    public Integer getRecordId() {
        return recordId;
    }
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getDiseaseCode() {
        return diseaseCode;
    }
    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }
    public String getTotal_deaths() {
        return total_deaths;
    }
    public void setTotal_deaths(String total_deaths) {
        this.total_deaths = total_deaths;
    }
    public String getTotal_patients() {
        return total_patients;
    }
    public void setTotal_patients(String total_patients) {
        this.total_patients = total_patients;
    }

    
}
