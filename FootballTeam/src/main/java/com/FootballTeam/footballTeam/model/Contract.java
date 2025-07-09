package com.FootballTeam.footballTeam.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity // Definisco Contract come una entità
@Table(name = "contracts") // Nome della tabella nel DB!
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date", nullable = false) // Colonna del DB con la data di inizio dei contratti
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false) // Colonna del DB con la data di fine dei contratti
    private LocalDate endDate;

    @Column(name = "salary") // Colonna del DB con il salario
    private Double salary;

    @Column(name = "provisions", columnDefinition = "TEXT") // Colonna del DB con le clausole del contratto
    private String provisions;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Player player;

    // Costruttore vuoto
    public Contract() {
    }

    // Costruttore con Attributi
    public Contract(LocalDate startDate, LocalDate endDate, Double salary, String provisions, Player player) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.provisions = provisions;
    }

    // Getter e Setter

    public long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Double getSalary() {
        return salary;
    }

    public String getProvisions() {
        return provisions;
    }

    public Player getPlayer() {
        return player;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setProvisions(String provisions) {
        this.provisions = provisions;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // Metodo ToString per le Info sul Contratto
    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", salary=" + salary +
                ", provisions='" + provisions + '\'' +
                '}';
    }
}