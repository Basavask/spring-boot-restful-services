package net.basuguides.spring.boot.java.springboot_restful_services.service.impl;

import lombok.AllArgsConstructor;
import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import net.basuguides.spring.boot.java.springboot_restful_services.expections.UserNotFoundException;
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
//        User user = UserMapper.userDTOtoUserJPA(userDto);

//         userRepository.save(user);

//         UserDto newUserDto = new UserDto(
//                 user.getId(),
//                 user.getFirstName(),
//                 user.getLastName(),
//                 user.getEmail()
//         );

        //using mapper fn
//        return UserMapper.userJPATOUserDto(user);

        // or
        return  UserMapper.userJPATOUserDto(userRepository.save(UserMapper.userDTOtoUserJPA(userDto)));
    }

    @Override
    public Optional<UserDto> getUserById(Long userId) {
        // here usermapper acts as this:: where its refers to instance of the class and calling the methods inside
        // them and map operator return user (User) entity to userJPATOUserDto which will return DTO.
        return userRepository.findById(userId).map(UserMapper::userJPATOUserDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::userJPATOUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
//        User exisitingUser = userRepository.findById(user.getId()).get(); this will throw warning as optional.get() might be empty.
        User exisitingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + user.getId()));
        exisitingUser.setFirstName(user.getFirstName());
        exisitingUser.setLastName(user.getLastName());
        exisitingUser.setEmail(user.getEmail());
         userRepository.save(exisitingUser);
        return UserMapper.userJPATOUserDto(exisitingUser);
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

