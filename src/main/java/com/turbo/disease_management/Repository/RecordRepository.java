package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turbo.disease_management.Entity.Record;

public interface RecordRepository extends JpaRepository<Record, String>{
    //public Record findByRecordId(Integer recordId);
    public Record findByDiseaseCode(String diseaseCode);

    //public void deleteByDiseaseCode(String diseaseCode);
}
