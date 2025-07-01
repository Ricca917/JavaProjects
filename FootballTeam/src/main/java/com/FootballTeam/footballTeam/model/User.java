package com.FootballTeam.footballTeam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users") // Tabella DB relativa agli Utenti
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L' Username non può essere vuoto")
    @Size(min = 3, max = 30, message = "Username deve essere compreso fra 3 e 30 caratteri")
    @Column(unique = true, nullable = false) // Unicità dell'username!
    private String username;

    @NotBlank(message = " La Password non può essere vuota")
    @Size(min = 8, message = "La Password deve avere almeno 8 caratteri")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) // Salvo nel DB l'enum come Stringa
    @Column(nullable = false)
    private Role role;

    // Costruttore vuoto (per JPA)
    public User() {
    }

    // Costruttore con Attributi
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
