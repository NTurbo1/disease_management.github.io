package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.RecordDto;
import com.turbo.disease_management.Entity.Record;

public interface RecordService {
    public void saveRecord(RecordDto recordDto);

	//public Record findRecordByRecordId(Integer recordId);
	
	public List<RecordDto> findAllRecords();

    public void deleteRecordByDiseaseCode(String diseaseCode);

    public Record findRecordByDiseaseCode(String diseaseCode);
}
