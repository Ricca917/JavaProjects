package com.FootballTeam.footballTeam.controller;

import com.FootballTeam.footballTeam.dto.response.UserResponseDto;
import com.FootballTeam.footballTeam.dto.request.UserRequestDto;
import com.FootballTeam.footballTeam.model.User;
import com.FootballTeam.footballTeam.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint per creare un nuovo utente
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getUsername(), userRequestDto.getPassword(), userRequestDto.getRole());
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(converToUserResponseDto(createdUser), HttpStatus.CREATED);
    }

    // Endpoint per ottenere tutti gli utenti
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDto> userResponseDtos = users.stream()
                .map(this::converToUserResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

    // Endpoint per ottenere un utente tramite ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new java.util.NoSuchElementException("Utente non trovato con ID:" + id));
        return new ResponseEntity<>(converToUserResponseDto(user), HttpStatus.OK);
    }

    // Endpoint per aggiornare un utente esistente
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto userRequestDto) {
        User userDetails = new User(userRequestDto.getUsername(), userRequestDto.getPassword(),userRequestDto.getRole());
        User updatedUser = userService.updateUser(id,userDetails);
        return new ResponseEntity<>(converToUserResponseDto(updatedUser), HttpStatus.OK);
    }

    // Endpoint per eliminare un utente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Metodo per convertire User in UserResponseDto
    private UserResponseDto converToUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getRole());
    }
}
