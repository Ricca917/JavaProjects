package com.FootballTeam.footballTeam.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity // Definisco Team come entità persistente
@Table(name = "teams") // Creo tabella Teams nel DB

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anche questo Id viene gestito dal DB
    private Long id; // Campo creato per l'id

    private String teamName;     // Campo nomeSquadra
    private int foundingYear;    // Campo annoFondazione
    private String president;    // Campo presidente
    private String coach;        // Campo allenatore

    @OneToMany(mappedBy = "team", // "team" è il nome del campo della classe Player che gestisce la relazione
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Player> rosterPlayers = new ArrayList<>(); // Lista inizializzata


    // Costruttore vuoto per la JPA
    public Team() {}

    //Costruttore base (no id, rosa inizializzata vuota)
    public Team(String teamName, int foundingYear, String president, String coach) {
        this.teamName = teamName;
        this.foundingYear = foundingYear;
        this.president = president;
        this.coach = coach;
        // La lista rosterPlayers è già inizializzata nella dichiarazione del campo.
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public List<Player> getRosterPlayers() {
        return rosterPlayers;
    }

    public void setRosterPlayers(List<Player> rosterPlayers) {
        this.rosterPlayers = rosterPlayers;
    }

    // Metodo per aggiungere un giocatore alla squadra (helper per la coerenza bidirezionale)
    public void addPlayer(Player player) {
        if (player != null && !this.rosterPlayers.contains(player)) {
            this.rosterPlayers.add(player);
            player.setTeam(this); // Mantiene la coerenza bidirezionale
        }
    }

    // Metodo per la rimozione di un giocatore dalla squadra
    public void removePlayer(Player player) {
        if (player != null && this.rosterPlayers.remove(player)) {
            player.setTeam(null); // Scollega il giocatore dalla squadra
        }
    }

    // Metodo per stampare info sulla squadra (toString per API REST)
    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", foundingYear=" + foundingYear +
                ", president='" + president + '\'' +
                ", coach='" + coach + '\'' +
                '}';
    }
}