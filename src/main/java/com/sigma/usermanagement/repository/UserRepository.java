package com.sigma.usermanagement.repository;
import com.sigma.usermanagement.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
