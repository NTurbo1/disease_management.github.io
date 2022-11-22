package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.SpecializeDto;
import com.turbo.disease_management.Entity.Specialize;

public interface SpecializeService {
    public void saveSpecialization(SpecializeDto specializeDto);

	public Specialize findSpecializationByEmail(String email);
	
	public List<SpecializeDto> findAllSpecializations();
}
