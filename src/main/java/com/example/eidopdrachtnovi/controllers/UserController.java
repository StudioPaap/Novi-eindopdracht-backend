package com.example.eidopdrachtnovi.controllers;


import com.example.eidopdrachtnovi.dtos.UserDto;
import com.example.eidopdrachtnovi.models.Role;
import com.example.eidopdrachtnovi.models.User;
import com.example.eidopdrachtnovi.repositories.RoleRepository;
import com.example.eidopdrachtnovi.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.username);
        newUser.setPassword(passwordEncoder.encode(userDto.password));

        List<Role> userRoles = new ArrayList<>();
        for (String roleName : userDto.roles) {
            Optional<Role> optionalRole = roleRepository.findById(roleName);

            userRoles.add(optionalRole.get());
        }
        newUser.setRoles(userRoles);

       userRepository.save(newUser);









        return ResponseEntity.created(null).body(newUser);
    }
}