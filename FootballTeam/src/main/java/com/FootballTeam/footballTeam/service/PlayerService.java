package com.FootballTeam.footballTeam.service;

import com.FootballTeam.footballTeam.model.Player;
import com.FootballTeam.footballTeam.model.Team;
import com.FootballTeam.footballTeam.repository.PlayerRepository;
import com.FootballTeam.footballTeam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired; // Con Autowired faremo fare a spring le iniezioni necessarie
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Serve per gestire le Transazioni

import java.util.List;
import java.util.Optional; // Utilizzato per i metodi "findBy..."

@Service
public class PlayerService {
    private final PlayerRepository playerRepository; // Iniezione per accedere ai dati giocatori
    private final TeamRepository teamRepository; // Iniezione per accedere ai dati delle squadre

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    //Metodo per salvare/aggiornare un giocatore
    @Transactional
    public Player savePlayer(Player player) {
        if (player.getTeam() != null && player.getTeam().getId() != null) { // Check esistenza della squadra
            Optional<Team> existingTeam = teamRepository.findById(player.getTeam().getId());
            if (existingTeam.isPresent()) {
                player.setTeam(existingTeam.get());
                existingTeam.get().addPlayer(player);
            } else {
                throw new IllegalArgumentException("Team with ID " + player.getTeam().getId() + "not found.");
            }
        } else if (player.getTeam() != null && player.getTeam().getId() == null) {
            player.setTeam(null);
        }
        return playerRepository.save(player);
    }

    // Metodo per trovare un giocatore dal suo Id
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    // Metodo per ottenere tutti i giocatori
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Metodo per eliminare un giocatore dal suo Id
    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    // Metodo per trovare giocatori per team Id
    public List<Player> getPlayerByTeamId(Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }

    // Metodo per trovare giocatori per Ruolo
    public List<Player> getPlayerByPosition(String position) {
        return playerRepository.findByPosition(position);
    }

    // Metodo per trovare giocatori per Nazionalità
    public List<Player> getPlayersByNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }

    // Metodo per trovare giocatori se hanno un team
    public List<Player> getFreePlayers() {
        return playerRepository.findByIsFreeAgentTrue();
    }

}

