package com.FootballTeam.footballTeam.dto.response;

import com.FootballTeam.footballTeam.model.Role;


public class UserResponseDto {
    private Long id;
    private String username;
    private Role role;

    // Costruttore vuoto
    public UserResponseDto() {
    }

    // Costruttore con Attributi
    public UserResponseDto(Long id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
