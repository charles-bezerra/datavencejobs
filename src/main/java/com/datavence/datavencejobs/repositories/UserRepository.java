package com.datavence.datavencejobs.repositories;

import com.datavence.datavencejobs.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findByEmailAndPassword(String email, String password);
}
