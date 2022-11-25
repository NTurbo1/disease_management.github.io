package com.turbo.disease_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.RecordDto;
import com.turbo.disease_management.Repository.RecordRepository;
import com.turbo.disease_management.Entity.Record;

@Service
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;
    
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public void saveRecord(RecordDto recordDto) {
        Record record = new Record();
        record.setCname(recordDto.getCname());
        record.setDiseaseCode(recordDto.getDiseaseCode());
        record.setEmail(recordDto.getEmail());
        record.setRecordId(recordDto.getRecordId());
        record.setTotal_deaths(recordDto.getTotal_deaths());
        record.setTotal_patients(recordDto.getTotal_patients());

        recordRepository.save(record);
    }

    @Override
    public Record findRecordByRecordId(Integer recordId) {
        return recordRepository.findByRecordId(recordId);
    }

    @Override
    public List<RecordDto> findAllRecords() {
        List<Record> records = recordRepository.findAll();
        return records.stream()
                .map((record) -> mapToRecordDto(record))
                .collect(Collectors.toList());
    }

    private RecordDto mapToRecordDto(Record record){
        RecordDto recordDto = new RecordDto();
        recordDto.setCname(record.getCname());
        recordDto.setDiseaseCode(record.getCname());
        recordDto.setEmail(record.getEmail());
        recordDto.setRecordId(record.getRecordId());
        recordDto.setTotal_deaths(record.getTotal_deaths());
        recordDto.setTotal_patients(record.getTotal_patients());
        return recordDto;
    }

    @Override
    public void deleteRecordById(Integer recordId) {

        recordRepository.deleteById(recordId);
    }
    
}
