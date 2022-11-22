package com.turbo.disease_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.SpecializeDto;
import com.turbo.disease_management.Entity.Specialize;
import com.turbo.disease_management.Repository.SpecializeRepository;

@Service
public class SpecializeServiceImpl implements SpecializeService {

    private SpecializeRepository specializeRepository;

    public SpecializeServiceImpl(SpecializeRepository specializeRepository) {
        this.specializeRepository = specializeRepository;
    }

    @Override
    public void saveSpecialization(SpecializeDto specializeDto) {
        Specialize specialize = new Specialize();
        specialize.setEmail(specializeDto.getEmail());
        specialize.setId(specializeDto.getId());
        
        specializeRepository.save(specialize);
        
    }

    @Override
    public Specialize findSpecializationByEmail(String email) {
        return specializeRepository.findByEmail(email);
    }

    @Override
    public List<SpecializeDto> findAllSpecializations() {
        List<Specialize> specializations = specializeRepository.findAll();
        return specializations.stream()
                .map((publicServant) -> mapToSpecializeDto(publicServant))
                .collect(Collectors.toList());
    }

    private SpecializeDto mapToSpecializeDto(Specialize specialize){
        SpecializeDto specializeDto = new SpecializeDto();
        specializeDto.setId(specialize.getId());
        specializeDto.setEmail(specialize.getEmail());
        return specializeDto;
    }
}
