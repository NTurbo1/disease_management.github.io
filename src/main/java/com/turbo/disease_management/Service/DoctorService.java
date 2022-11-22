package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.DoctorDto;
import com.turbo.disease_management.Entity.Doctor;

public interface DoctorService {
    public void saveDoctor(DoctorDto doctorDto);

	public Doctor findDoctorByEmail(String email);
	
	public List<DoctorDto> findAllDoctors();
}
