package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.DiseaseDto;
import com.turbo.disease_management.Entity.Disease;

public interface DiseaseService {
    public void saveDisease(DiseaseDto diseaseDto);

	public Disease findDiseaseByDiseaseCode(String diseaseCode);
	
	public List<DiseaseDto> findAllDiseases();

	public void deleteDiseaseByDiseaseCode(String diseaseCode);
}
