package net.basuguides.spring.boot.java.springboot_restful_services.service.impl;

import lombok.AllArgsConstructor;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import net.basuguides.spring.boot.java.springboot_restful_services.respository.UserRepository;
import net.basuguides.spring.boot.java.springboot_restful_services.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exisitingUser = userRepository.findById(user.getId()).get();
        exisitingUser.setFirstName(user.getFirstName());
        exisitingUser.setLastName(user.getLastName());
        exisitingUser.setEmail(user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
       Optional<User> isUserPresent = userRepository.findById(userId);
       if(isUserPresent.isPresent()){
           userRepository.deleteById(userId);
           return true;
       }
        return false;
    }
}
