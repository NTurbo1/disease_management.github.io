package com.turbo.disease_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.DoctorDto;
import com.turbo.disease_management.Entity.Doctor;
import com.turbo.disease_management.Repository.DoctorRepository;
import com.turbo.disease_management.Repository.RoleRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, RoleRepository roleRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setEmail(doctorDto.getEmail());
        doctor.setDegree(doctorDto.getDegree());
        
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    @Override
    public List<DoctorDto> findAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map((doctor) -> mapToDoctorDto(doctor))
                .collect(Collectors.toList());
    }

    private DoctorDto mapToDoctorDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDegree(doctor.getDegree());
        doctorDto.setEmail(doctor.getEmail());
        return doctorDto;
    }
    
}
