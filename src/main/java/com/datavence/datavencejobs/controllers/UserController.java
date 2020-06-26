package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.dto.UserDTO;
import com.datavence.datavencejobs.models.User;
import com.datavence.datavencejobs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public @ResponseBody List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") Long id){
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(new UserDTO(user.get()));
    }

    @PutMapping("")
    public @ResponseBody User putUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("")
    public @ResponseBody void deleteUser(@RequestBody User user){
        userRepository.delete(user);
    }

    @PostMapping("")
    public @ResponseBody User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
