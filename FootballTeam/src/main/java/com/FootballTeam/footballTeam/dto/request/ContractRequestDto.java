package com.FootballTeam.footballTeam.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractRequestDto {

    @NotNull(message = "La data di inizio contratto non può essere nulla")
    private LocalDate startDate;

    @NotNull(message = "La data di fine contratto non può essere nulla")
    private LocalDate endDate;

    @NotNull(message = "Lo Stipendio non può essere nullo")
    @DecimalMin(value = "0.0", inclusive = false, message = "Lo stipendio minimo deve essere un valore positivo")
    private BigDecimal salary;

    @NotNull(message = "L'ID del giocatore non può essere  nullo")
    private Long playerId;

    @NotNull(message = "L'ID della squadra non può essere nullo")
    private Long teamId;

    // Costruttore vuoto
    public ContractRequestDto() {
    }

    // Costruttore con Attributi
    public ContractRequestDto(LocalDate startDate, LocalDate endDate, BigDecimal salary, Long playerId, Long teamId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.playerId = playerId;
        this.teamId = teamId;
    }

    // Getter e Setter

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

    public Long getTeamId() {
        return teamId;
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

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}

