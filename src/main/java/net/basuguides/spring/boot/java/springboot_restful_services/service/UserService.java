package net.basuguides.spring.boot.java.springboot_restful_services.service;

import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    boolean deleteUser(Long userId);
}
