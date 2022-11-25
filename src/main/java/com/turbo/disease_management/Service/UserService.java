package com.turbo.disease_management.Service;

import java.util.List;

import com.turbo.disease_management.Dto.UserDto;
import com.turbo.disease_management.Entity.User;

public interface UserService {
    public void saveUser(UserDto userDto);

	public User findUserByEmail(String email);
	
	public List<UserDto> findAllUsers();

	public void deleteUserByEmail(String email);
}
