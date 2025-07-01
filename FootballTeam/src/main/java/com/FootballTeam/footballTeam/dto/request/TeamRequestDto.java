package com.FootballTeam.footballTeam.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;


public class TeamRequestDto {

    @NotBlank(message = "Il nome della squadra non può essere vuoto")
    @Size(min = 2, max = 100, message = "Il nome della squadra deve essere tra 2 e 100 caratteri")
    private String teamName;

    @Min(value = 1850, message = "L'anno di fondazione deve essere almeno il 1850")
    @NotNull(message = "L'anno di fondazione non può essere nullo")
    private Integer foundingYear;

    @NotBlank(message = "Il nome completo del presidente non può essere vuoto")
    @Size(min = 2, max = 50, message = "Il nome del presidente deve essere tra 2 e 50 caratteri")
    private String president;

    @NotBlank(message = "Il nome dell' allenatore non può essere vuoto")
    @Size(min = 2, max = 50, message = "Il nome dell'allenatore deve essere tra 2 e 50 caratteri")
    private String coach;

    // Costruttore base
    public TeamRequestDto() {

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
}
