package com.turbo.disease_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.DiscoverDto;
import com.turbo.disease_management.Entity.Discover;
import com.turbo.disease_management.Repository.DiscoverRepository;

@Service
public class DiscoverServiceImpl implements DiscoverService {
    private DiscoverRepository discoverRepository;
    
    public DiscoverServiceImpl(DiscoverRepository discoverRepository) {
        this.discoverRepository = discoverRepository;
    }

    @Override
    public void saveDiscovery(DiscoverDto discoverDto) {
        Discover discover = new Discover();
        discover.setCname(discoverDto.getCname());
        discover.setDiseaseCode(discoverDto.getDiseaseCode());
        discover.setFirst_enc_date(discoverDto.getFirst_enc_date());
        
        discoverRepository.save(discover);
    }

    @Override
    public Discover findDiscoveryByDiseaseCode(String diseaseCode) {
        return discoverRepository.findByDiseaseCode(diseaseCode);
    }

    @Override
    public List<DiscoverDto> findAllDiscoveries() {
        List<Discover> discovers = discoverRepository.findAll();
        return discovers.stream()
                .map((discover) -> mapToDiscoverDto(discover))
                .collect(Collectors.toList());
    }

    private DiscoverDto mapToDiscoverDto(Discover discover){
        DiscoverDto discoverDto = new DiscoverDto();
        discoverDto.setCname(discover.getCname());
        discoverDto.setDiseaseCode(discover.getDiseaseCode());
        discoverDto.setFirst_enc_date(discover.getFirst_enc_date());
        return discoverDto;
    }

    @Override
    public void deleteDiscoveryByDiseaseCode(String diseaseCode) {

        discoverRepository.deleteById(diseaseCode);
    }
}
