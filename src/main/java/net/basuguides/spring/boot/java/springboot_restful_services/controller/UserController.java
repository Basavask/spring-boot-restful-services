package net.basuguides.spring.boot.java.springboot_restful_services.controller;

import lombok.AllArgsConstructor;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import net.basuguides.spring.boot.java.springboot_restful_services.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/users/")
public class UserController {

    private UserService userService;

    @PostMapping("save")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

}
