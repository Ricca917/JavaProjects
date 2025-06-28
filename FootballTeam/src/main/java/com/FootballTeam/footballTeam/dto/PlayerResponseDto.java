package com.FootballTeam.footballTeam.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class PlayerResponseDto {
    private Long id;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long teamId;
    private String teamName;

    // Costruttore vuoto
    public PlayerResponseDto() {
    }

    // Costruttore con gli attributi
    public PlayerResponseDto(Long id, String firstName, String lastName, String position, LocalDate dateOfBirth, String nationality, Boolean isFreeAgent, Long teamId, String teamName, int age, int jerseyNumber, int appearances, int goals) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.isFreeAgent = isFreeAgent;
        this.teamId = teamId;
        this.teamName = teamName;
        this.age = age;
        this.jerseyNumber = jerseyNumber;
        this.appearances = appearances;
        this.goals = goals;
    }

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

    public Boolean getFreeAgent() {
        return isFreeAgent;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
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

    public void setFreeAgent(Boolean freeAgent) {
        isFreeAgent = freeAgent;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}