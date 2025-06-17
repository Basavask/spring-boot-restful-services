package net.basuguides.spring.boot.java.springboot_restful_services.mapper;

import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;

public class UserMapper {

    public static UserDto userJPATOUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User userDTOtoUserJPA(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
