package com.FootballTeam.footballTeam.service;

import com.FootballTeam.footballTeam.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    User createUser(User user);
    Optional<User> getUserByUsername(String username);
    List<User> getAllUsers();
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
    Optional<User> getUserById(Long id);
}
