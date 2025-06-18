package net.basuguides.spring.boot.java.springboot_restful_services.expections;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
