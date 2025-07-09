package com.FootballTeam.footballTeam.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ContractResponseDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal salary;
    private Long playerId;
    private String playerFirstName;
    private String playerLastName;
    private Long teamId;
    private String teamName;

    // Costruttore vuoto
    public ContractResponseDto() {
    }

    // Costruttore con Attributi
    public ContractResponseDto(Long id, LocalDate startDate, LocalDate endDate, BigDecimal salary, Long playerId, String playerFirstName, String playerLastName, Long teamId, String teamName) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.playerId = playerId;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
