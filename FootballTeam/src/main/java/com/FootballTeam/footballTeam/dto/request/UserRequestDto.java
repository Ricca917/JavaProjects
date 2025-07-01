package com.FootballTeam.footballTeam.dto.request;

import com.FootballTeam.footballTeam.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDto {

    @NotBlank(message = "L'username non può essere vuoto")
    @Size(min = 3, max = 50, message = "L'username deve essere compreso fra 3 e 50 caratteri")
    private String username;

    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 8, message = "La password deve avere almeno 8 caratteri")
    private String password;

    @NotNull(message = "Il ruolo non può essere nullo")
    private Role role;

    // Costruttore vuoto
    public UserRequestDto() {
    }

    // Costruttore con Attributi
    public UserRequestDto(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter e Setter

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
