package net.basuguides.spring.boot.java.springboot_restful_services.mapper;

import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

//    public static UserDto userJPATOUserDto(User user) {
//        return new UserDto(
//                user.getId(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getEmail()
//        );
//    }
//
//    public static User userDTOtoUserJPA(UserDto userDto) {
//        return new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
//    }
//    above is not a good practice to do... if we have lot of classes then will go for lib / dependencies 3rd part
//    ModelMapper and one more is MapStruct


//   Using Model Mapper
//    public static User userDTOtoUserJPA(UserDto userDto) {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(userDto, User.class);
//    }
//    public static UserDto userJPATOUserDto(User user) {
//        ModelMapper modelMapper = new ModelMapper();
//
//        return modelMapper.map(user, UserDto.class);
//    }
    //   Using Model Mapper

//    Using MapStruct
    public static User userDTOtoUserJPA(UserDto userDto) {
        return AutoUserMapper.MAPPER.mapToUser(userDto);
    }
    public static UserDto userJPATOUserDto(User user) {
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }
//    Using MapStruct
}
