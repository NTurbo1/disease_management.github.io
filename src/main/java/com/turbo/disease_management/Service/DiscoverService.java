package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.DiscoverDto;
import com.turbo.disease_management.Entity.Discover;

public interface DiscoverService {
    public void saveDiscovery(DiscoverDto discoverDto);

	public Discover findDiscoveryByDiseaseCode(String diseaseCode);
	
	public List<DiscoverDto> findAllDiscoveries();

	public void deleteDiscoveryByDiseaseCode(String diseaseCode);
}
