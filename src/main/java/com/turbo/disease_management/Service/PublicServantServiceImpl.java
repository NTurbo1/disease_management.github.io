package com.turbo.disease_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.PublicServantDto;
import com.turbo.disease_management.Entity.PublicServant;
import com.turbo.disease_management.Repository.PublicServantRepository;

@Service
public class PublicServantServiceImpl implements PublicServantService {

    private PublicServantRepository publicServantRepository;

    
    public PublicServantServiceImpl(PublicServantRepository publicServantRepository) {
        this.publicServantRepository = publicServantRepository;
    }

    @Override
    public void savePublicServant(PublicServantDto publicServantDto) {
        PublicServant publicServant = new PublicServant();
        publicServant.setEmail(publicServantDto.getEmail());
        publicServant.setDepartment(publicServantDto.getDepartment());
        
        publicServantRepository.save(publicServant);
        
    }

    @Override
    public PublicServant findPublicServantByEmail(String email) {
        return publicServantRepository.findByEmail(email);
    }

    @Override
    public List<PublicServantDto> findAllPublicServants() {
        List<PublicServant> publicServants = publicServantRepository.findAll();
        return publicServants.stream()
                .map((publicServant) -> mapToPublicServantDto(publicServant))
                .collect(Collectors.toList());
    }

    private PublicServantDto mapToPublicServantDto(PublicServant publicServant){
        PublicServantDto publicServantDto = new PublicServantDto();
        publicServantDto.setDepartment(publicServant.getDepartment());
        publicServantDto.setEmail(publicServant.getEmail());
        return publicServantDto;
    }
    
}
