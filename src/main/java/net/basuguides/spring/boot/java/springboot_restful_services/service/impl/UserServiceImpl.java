package net.basuguides.spring.boot.java.springboot_restful_services.service.impl;

import lombok.AllArgsConstructor;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import net.basuguides.spring.boot.java.springboot_restful_services.respository.UserRepository;
import net.basuguides.spring.boot.java.springboot_restful_services.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
