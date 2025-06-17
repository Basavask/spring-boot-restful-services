package net.basuguides.spring.boot.java.springboot_restful_services.controller;

import lombok.AllArgsConstructor;
import net.basuguides.spring.boot.java.springboot_restful_services.dto.UserDto;
import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import net.basuguides.spring.boot.java.springboot_restful_services.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/users/")
public class UserController {

    private UserService userService;

    @PostMapping("save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long userId){
       return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        if(userService.deleteUser(userId)){
            return new ResponseEntity<>("User Deleted SuccessFully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Not Found...!!!", HttpStatus.OK);
        }
    }
}
