package com.FootballTeam.footballTeam.service;

import com.FootballTeam.footballTeam.model.Team;
import com.FootballTeam.footballTeam.model.Player;
import com.FootballTeam.footballTeam.repository.TeamRepository;
import com.FootballTeam.footballTeam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    // Metodo per salvare/aggiornare una squadra
    @Transactional
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    // Metodo per ottenere tutte le Squadre
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Metodo per trovare una Squadra tramite il suo Id
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    // Metodo per aggiungere una lista di giocatori a una squadra
    @Transactional
    public Team addPlayersListToTeam(Long teamId, List<Long> playerIds) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);

        if (teamOptional.isEmpty()) {
            throw new IllegalArgumentException("Squadra con ID " + teamId + " non trovata.");
        }

        Team team = teamOptional.get();
        for (Long playerId : playerIds) {
            Optional<Player> playerOptional = playerRepository.findById(playerId);
            if (playerOptional.isEmpty()) {
                System.out.println("Attenzione! Giocatore con ID " + playerId + " non trovato. Verrà ignorato.");
                continue;
            }

            Player player = playerOptional.get();

            if (player.getTeam() != null) {
                if (player.getTeam().getId().equals(teamId)) {
                    System.out.println("Attenzione! Giocatore " + player.getId() + " fa già parte del team " + teamId + ". Verrà ignorato.");
                    continue;
                } else {
                    System.out.println("Attenzione! Giocatore " + player.getId() + " fa già parte del team con ID:" + player.getTeam().getId() + " e non può essere aggiunto a:" + teamId + ". Verrà ignorato.");
                    continue;
                }
            }

            team.addPlayer(player);
            player.setIsFreeAgent(false);
            playerRepository.save(player);
        }
        return teamRepository.save(team);
    }

    // Metodo per eliminare un team tramite il suo Id
    @Transactional
    public void deleteTeam(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            for (Player player : team.getRosterPlayers()) {
                player.setTeam(null);
                player.setIsFreeAgent(true);
                playerRepository.save(player);
            }
            team.getRosterPlayers().clear();
            teamRepository.save(team);
            teamRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Team with ID " + id + " not found.");
        }
    }

    // Metodo per trovare un team per nome (si usa il metodo della Repository)
    public Team getTeamByName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    // Metodo per aggiungere un giocatore a un team esistente
    @Transactional
    public Team addPlayerToTeam(Long teamId, Long playerId) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        Optional<Player> playerOpt = playerRepository.findById(playerId);

        if (teamOpt.isEmpty() || playerOpt.isEmpty()) {
            throw new IllegalArgumentException("Team or Player not found.");
        }

        Team team = teamOpt.get();
        Player player = playerOpt.get();


        if (player.getTeam() != null) {
            if (player.getTeam().getId().equals(teamId)) {
                return team;
            } else {
                throw new IllegalArgumentException("Player with ID " + playerId + " is already assigned to Team ID " + player.getTeam().getId());
            }
        }

        team.addPlayer(player);
        player.setIsFreeAgent(false);
        playerRepository.save(player);
        return teamRepository.save(team);
    }

    // Metodo per rimuovere un giocatore da un team esistente
    @Transactional
    public Team removePlayerFromTeam(Long teamId, Long playerId) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        Optional<Player> playerOpt = playerRepository.findById(playerId);

        if (teamOpt.isEmpty() || playerOpt.isEmpty()) {
            throw new IllegalArgumentException("Team or Player not found.");
        }

        Team team = teamOpt.get();
        Player player = playerOpt.get();


        if (player.getTeam() == null || !player.getTeam().getId().equals(teamId)) {
            throw new IllegalArgumentException("Player with ID " + playerId + " is not part of Team ID " + teamId + ".");
        }

        team.removePlayer(player);
        player.setIsFreeAgent(true);
        playerRepository.save(player);
        return teamRepository.save(team);
    }
}