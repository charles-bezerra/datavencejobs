package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.dto.UserDTO;
import com.datavence.datavencejobs.models.User;
import com.datavence.datavencejobs.repositories.UserRepository;
import com.datavence.datavencejobs.responses.ActionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

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

    @PostMapping("/login")
    public @ResponseBody ActionResponse<UserDTO> loginUser(@RequestBody User user){
        if (user.getEmail() == null || user.getPassword() == null)
            return new ActionResponse<>(false, "Credenciais não foram informadas!");

        Optional<User> finduser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (finduser.isEmpty())
            return new ActionResponse<>(false, "Email ou senha estão incorretas!");
        else
            return new ActionResponse<>(true, null, new UserDTO(finduser.get()));
    }

    @PostMapping("/register")
    public @ResponseBody ActionResponse<UserDTO> registerUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getPassword() == null || user.getName() == null)
            return new ActionResponse<>(false, "Credenciais não foram informadas!");

        Optional<User> finduser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (finduser.isPresent())
            return new ActionResponse<>(false, "Email já cadastrado!");
        else {
            UserDTO saveduser = new UserDTO(userRepository.save(user));
            return new ActionResponse<>(true, null, saveduser);
        }
    }
}
