package com.turbo.disease_management.Service;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turbo.disease_management.Dto.UserDto;
import com.turbo.disease_management.Entity.Role;
import com.turbo.disease_management.Entity.User;
import com.turbo.disease_management.Repository.RoleRepository;
import com.turbo.disease_management.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhone(userDto.getPhone());
        user.setCname(userDto.getCname());
        user.setSalary(userDto.getSalary());

        Role role = null;
        if (userDto.getOccupation().equals("doctor")) {
            role = roleRepository.findByName("ROLE_DOCTOR");
            if(role == null){
                role = checkRoleExist("ROLE_DOCTOR");
            }
        } else {
            role = roleRepository.findByName("ROLE_PUBLICSERVANT");
            if(role == null){
                role = checkRoleExist("ROLE_PUBLICSERVANT");
            }
        }

        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setCname(user.getCname());
        userDto.setSalary(user.getSalary());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    private Role checkRoleExist(String roleName){
        Role role = new Role();
        role.setName(roleName);
        return roleRepository.save(role);
    }
	
}

