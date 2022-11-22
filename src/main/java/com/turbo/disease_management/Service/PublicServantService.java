package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.PublicServantDto;
import com.turbo.disease_management.Entity.PublicServant;

public interface PublicServantService {
    public void savePublicServant(PublicServantDto publicServantDto);

	public PublicServant findPublicServantByEmail(String email);
	
	public List<PublicServantDto> findAllPublicServants();
}
