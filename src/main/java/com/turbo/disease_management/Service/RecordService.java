package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.RecordDto;

public interface RecordService {
    public void saveRecord(RecordDto recordDto);

	public com.turbo.disease_management.Entity.Record findRecordByRecordId(Integer recordId);
	
	public List<RecordDto> findAllRecords();
}
