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
        if (team.getRosterPlayers() != null && !team.getRosterPlayers().isEmpty()) {
            for (Player player : team.getRosterPlayers()) {
                if (player.getId() != null) {
                    Optional<Player> existingPlayer = playerRepository.findById(player.getId());
                    if (existingPlayer.isPresent()) {
                        existingPlayer.get().setTeam(team);
                    } else {
                        throw new IllegalArgumentException("Player with Id " + player.getId() + "not found.");
                    }
                } else {
                    player.setTeam(team);
                }
            }
        }
        return teamRepository.save(team);
    }

    // Metodo per trovare una Squadra trami il suo Id
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    // Metodo per eliminare un team tramite il suo Id
    @Transactional
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
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

        if (teamOpt.isPresent() && playerOpt.isPresent()) {
            Team team = teamOpt.get();
            Player player = playerOpt.get();

            team.addPlayer(player);
            return teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Team or Player not found.");
        }
    }

    // Metodo per rimuovere un giocatore da un team esistente
    public Team removePlayerFromTeam(Long teamId, Long playerId) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        Optional<Player> playerOpt = playerRepository.findById(playerId);

        if (teamOpt.isPresent() && playerOpt.isPresent()) {
            Team team = teamOpt.get();
            Player player = playerOpt.get();

            team.removePlayer(player);
            return teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Team or Player not found.");
        }
    }
}
