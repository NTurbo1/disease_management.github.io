package com.turbo.disease_management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Record")
public class Record {
    // @Id
    // @GeneratedValue
    // @Column(name = "record_id", nullable = false)
    // private Integer recordId;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "cname", nullable = false)
    private String cname;
    @Id
    @Column(name = "disease_code", nullable = false)
    private String diseaseCode;
    @Column(name = "total_deaths", nullable = false)
    private String total_deaths;
    @Column(name = "total_patients", nullable = false)
    private String total_patients;

    // public Integer getRecordId() {
    //     return recordId;
    // }
    // public void setRecordId(Integer recordId) {
    //     this.recordId = recordId;
    // }
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
