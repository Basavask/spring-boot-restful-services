package net.basuguides.spring.boot.java.springboot_restful_services.mapper;

import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

//    to access the interface and to call the mapping class use the factory class to call and complie it.

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

//    @Mapping(source = "email", target = "emailAddress") // to map if we have diff field names..
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

}
