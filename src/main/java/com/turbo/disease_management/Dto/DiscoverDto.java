package com.turbo.disease_management.Dto;

import javax.validation.constraints.NotEmpty;

public class DiscoverDto {
    @NotEmpty(message = "Disease code should not be empty")
    private String diseaseCode;
    @NotEmpty(message = "Country name should not be empty")
    private String cname;
    @NotEmpty(message = "First encounter date should not be empty")
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
