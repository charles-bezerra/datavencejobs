package com.datavence.datavencejobs.repositories;

import com.datavence.datavencejobs.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
