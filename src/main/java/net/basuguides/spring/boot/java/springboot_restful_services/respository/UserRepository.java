package net.basuguides.spring.boot.java.springboot_restful_services.respository;

import net.basuguides.spring.boot.java.springboot_restful_services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
