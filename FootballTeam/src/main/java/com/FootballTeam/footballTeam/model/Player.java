package com.FootballTeam.footballTeam.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // indica che è una entità gestita da JPA
@Table(name = "players") // Tabella Giocatori nel DB
public class Player {
    @Id // definisco Id come chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id viene generato dal DB stesso
    private Long id; // Campo creato per l'id

    private String firstName;
    private String lastName;
    private String nationality;
    private int age;
    private LocalDate dateOfBirth;
    private String position;
    private int jerseyNumber;
    private int appearances;
    private int goals;
    private Boolean isFreeAgent;

    @ManyToOne(fetch = FetchType.LAZY) // Relazione MOLTI Giocatori - UNA Squadra
    @JoinColumn(name = "team_id") // Colonna squadra_id nella tabella "giocatori come FK
    private Team team; // Reference a oggetto Squadra

    public Player() {} // Costruttore vuoto necessario alla JPA

    // Costruttore base (no id)
    public Player(String firstName, String lastName, String nationality, int age, LocalDate dateOfBirth, String position, int jerseyNumber, int appearances, int goals, Boolean isFreeAgent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.appearances = appearances;
        this.goals = goals;
        this.isFreeAgent = isFreeAgent;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public int getAppearances() {
        return appearances;
    }

    public int getGoals() {
        return goals;
    }

    public Boolean getIsFreeAgent() {
        return isFreeAgent;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setIsFreeAgent(Boolean freeAgent) {
        isFreeAgent = freeAgent;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    // ToString per le informazioni del player
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", position='" + position + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", appearances=" + appearances +
                ", goals=" + goals +
                ", isFreeAgent=" + isFreeAgent +
                ", team=" + (team != null ? team.getTeamName() : "N/A") +
                '}';
    }
}
