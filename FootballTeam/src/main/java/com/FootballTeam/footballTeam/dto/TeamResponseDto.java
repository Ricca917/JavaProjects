package com.FootballTeam.footballTeam.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class TeamResponseDto {
    private Long id;
    private String teamName;
    private Integer foundingYear;
    private String president;
    private String coach;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PlayerResponseDto> players;

    // Costruttore vuoto
    public TeamResponseDto() {
    }

    // Costruttore con attributi
    public TeamResponseDto(Long id, String teamName, Integer foundingYear, String president, String coach, List<PlayerResponseDto> players) {
        this.id = id;
        this.teamName = teamName;
        this.foundingYear = foundingYear;
        this.president = president;
        this.coach = coach;
        this.players = players;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getFoundingYear() {
        return foundingYear;
    }

    public String getPresident() {
        return president;
    }

    public String getCoach() {
        return coach;
    }

    public List<PlayerResponseDto> getPlayers() {
        return players;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setFoundingYear(Integer foundingYear) {
        this.foundingYear = foundingYear;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void setPlayers(List<PlayerResponseDto> players) {
        this.players = players;
    }
}
