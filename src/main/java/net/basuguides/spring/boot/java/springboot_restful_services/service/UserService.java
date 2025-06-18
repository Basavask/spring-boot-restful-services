package net.basuguides.spring.boot.java.springboot_restful_services.service;

import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService {
    UserDto createUser(UserDto user);
    Optional<UserDto> getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    boolean deleteUser(Long userId);
}
