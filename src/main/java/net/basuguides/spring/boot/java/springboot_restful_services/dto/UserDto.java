package net.basuguides.spring.boot.java.springboot_restful_services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
}
