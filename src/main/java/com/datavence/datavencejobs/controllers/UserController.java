package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.responses.ActionResponse;
import com.datavence.datavencejobs.models.User;
import com.datavence.datavencejobs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<User> getUser(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @PostMapping("")
    public @ResponseBody ActionResponse createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ActionResponse(true, null);
    }
}
