package com.FootballTeam.footballTeam.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LeagueRequestDto {

    @NotBlank(message = "Il nome della lega non può essere vuoto")
    private String name;

    // Costruttore vuoto
    public LeagueRequestDto() {
    }

    // Costruttore con attributi
    public LeagueRequestDto(String name) {
        this.name = name;
    }

    // Getter e Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}