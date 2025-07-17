package com.FootballTeam.footballTeam.controller;

import com.FootballTeam.footballTeam.dto.request.UserRequestDto;
import com.FootballTeam.footballTeam.model.Role;
import com.FootballTeam.footballTeam.model.User;
import com.FootballTeam.footballTeam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto userRequestDto) {
        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            return new ResponseEntity<>("Username already exists!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        try {
            Role assignedRole = Role.USER;
            if (userRequestDto.getRole() != null) {
                assignedRole = Role.valueOf(userRequestDto.getRole().toUpperCase());
            }
            user.setRole(assignedRole);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid role specified!", HttpStatus.BAD_REQUEST);
        }


        userRepository.save(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }
}