package com.turbo.disease_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.DiseaseDto;
import com.turbo.disease_management.Entity.Disease;
import com.turbo.disease_management.Repository.DiseaseRepository;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    private DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public void saveDisease(DiseaseDto diseaseDto) {
        Disease disease = new Disease();
        disease.setDescription(diseaseDto.getDescription());
        disease.setDiseaseCode(diseaseDto.getDiseaseCode());
        disease.setId(diseaseDto.getId());
        disease.setPathogen(diseaseDto.getPathogen());

        diseaseRepository.save(disease);
        
    }

    @Override
    public Disease findDiseaseByDiseaseCode(String diseaseCode) {
        return diseaseRepository.findByDiseaseCode(diseaseCode);
    }

    @Override
    public List<DiseaseDto> findAllDiseases() {
        List<Disease> diseases = diseaseRepository.findAll();
        return diseases.stream()
                .map((disease) -> mapToDiseaseDto(disease))
                .collect(Collectors.toList());
    }

    private DiseaseDto mapToDiseaseDto(Disease disease){
        DiseaseDto diseaseDto = new DiseaseDto();
        diseaseDto.setDescription(disease.getDescription());
        diseaseDto.setDiseaseCode(disease.getDiseaseCode());
        diseaseDto.setId(disease.getId());
        diseaseDto.setPathogen(disease.getPathogen());
        return diseaseDto;
    }

    @Override
    public void deleteDiseaseByDiseaseCode(String diseaseCode) {
        diseaseRepository.deleteById(diseaseCode);
    }
}
