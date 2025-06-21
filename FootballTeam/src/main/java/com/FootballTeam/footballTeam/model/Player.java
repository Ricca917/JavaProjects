package com.FootballTeam.footballTeam.model;

import jakarta.persistence.*;

@Entity // indica che è una entità gestita da JPA
@Table(name = "players") // Tabella Giocatori nel DB
public class Player {
    @Id // definisco Id come chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id viene generato dal DB stesso
    private Long id; // Campo creato per l'id

    private String firstName; // Campo nome
    private String lastName;  // Campo cognome
    private int age;          // Campo eta
    private String position;  // Campo ruolo
    private int jerseyNumber; // Campo numeroMaglia
    private int appearances;  // Campo presenze
    private int goals;        // Campo gol

    @ManyToOne(fetch = FetchType.LAZY) // Relazione MOLTI Giocatori - UNA Squadra
    @JoinColumn(name = "team_id") // Colonna squadra_id nella tabella "giocatori come FK
    private Team team; // Reference a oggetto Squadra

    public Player() {} // Costruttore vuoto necessario alla JPA

    // Costruttore base (no id)
    public Player(String firstName, String lastName, int age, String position, int jerseyNumber, int appearances, int goals) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.appearances = appearances;
        this.goals = goals;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public Team getTeam() { // Getter per l'oggetto Team
        return team;
    }

    public void setTeam(Team team) { // Setter per l'oggetto Team
        this.team = team;
    }

    // Metodo che Descrive un giocatore secondo i suoi attributi (toString per API REST)
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", appearances=" + appearances +
                ", goals=" + goals +
                '}';
    }
}