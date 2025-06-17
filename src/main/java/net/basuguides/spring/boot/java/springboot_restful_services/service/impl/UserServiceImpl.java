package net.basuguides.spring.boot.java.springboot_restful_services.service.impl;

import lombok.AllArgsConstructor;
import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import net.basuguides.spring.boot.java.springboot_restful_services.mapper.UserMapper;
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
    public UserDto createUser(UserDto userDto) {

//        User user = new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
//
        // Using Mapper
        User user = UserMapper.userDTOtoUserJPA(userDto);

         userRepository.save(user);

//         UserDto newUserDto = new UserDto(
//                 user.getId(),
//                 user.getFirstName(),
//                 user.getLastName(),
//                 user.getEmail()
//         );

        //using mapper fn
        return UserMapper.userJPATOUserDto(user);
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
