package com.turbo.disease_management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Discover")
public class Discover {
    @Id
    @Column(name="disease_code", nullable = false)
    private String diseaseCode;
    @Column(name="cname", nullable = false)
    private String cname;
    @Column(name="first_enc_date", nullable = false)
    private String first_enc_date;

    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getFirst_enc_date() {
        return first_enc_date;
    }
    public void setFirst_enc_date(String first_enc_date) {
        this.first_enc_date = first_enc_date;
    }
    public String getDiseaseCode() {
        return diseaseCode;
    }
    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    
}
