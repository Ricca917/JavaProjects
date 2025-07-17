package com.FootballTeam.footballTeam.dto.response;

public class LeagueResponseDto {
    private Long id;
    private String name;

    public LeagueResponseDto() {
    }

    public LeagueResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}