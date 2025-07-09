package com.FootballTeam.footballTeam.controller;

import com.FootballTeam.footballTeam.dto.response.PlayerResponseDto;
import com.FootballTeam.footballTeam.dto.response.TeamResponseDto;
import com.FootballTeam.footballTeam.dto.request.TeamRequestDto;
import com.FootballTeam.footballTeam.model.Team;
import com.FootballTeam.footballTeam.model.Player;
import com.FootballTeam.footballTeam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // Definisco la classe come REST Controller
@RequestMapping("/api/teams")  // Percorso per le API relative alle Squadre
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Mappare Team a TeamResponseDto
    private TeamResponseDto convertToTeamResponseDto(Team team) {
        List<PlayerResponseDto> playerDtos = null;
        if(team.getRosterPlayers() != null && !team.getRosterPlayers().isEmpty()) {
            playerDtos = team.getRosterPlayers().stream()
                    .map(player -> new PlayerResponseDto(
                            player.getId(),
                            player.getFirstName(),
                            player.getLastName(),
                            player.getPosition(),
                            player.getDateOfBirth(),
                            player.getNationality(),
                            player.getIsFreeAgent(),
                            player.getTeam() != null ? player.getTeam().getId() : null,
                            player.getTeam() != null ? player.getTeam().getTeamName() : null,
                            player.getAge(),
                            player.getJerseyNumber(),
                            player.getAppearances(),
                            player.getGoals()
                    ))
                    .collect(Collectors.toList());
        }
        return new TeamResponseDto(
                team.getId(),
                team.getTeamName(),
                team.getFoundingYear(),
                team.getPresident(),
                team.getCoach(),
                playerDtos
        );
    }

    // Mappo Player con PlayerResponseDto
    private PlayerResponseDto convertToPlayerResponseDto(Player player) {
        return new PlayerResponseDto(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getPosition(),
                player.getDateOfBirth(),
                player.getNationality(),
                player.getIsFreeAgent(),
                player.getTeam() != null ? player.getTeam().getId() : null,
                player.getTeam() != null ? player.getTeam().getTeamName() : null,
                player.getAge(),
                player.getJerseyNumber(),
                player.getAppearances(),
                player.getGoals()
        );
    }

    // Endpoint per visualizzare tutte le Squadre
    @GetMapping
    public ResponseEntity<List<TeamResponseDto>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        List<TeamResponseDto> teamDtos = teams.stream()
                .map(this::convertToTeamResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }

    // Endpoint per la creazione di un nuovo Team (metodo POST)
    @PostMapping
    public ResponseEntity<TeamResponseDto> createTeam(@Valid @RequestBody TeamRequestDto teamDto) {
        Team team = new Team();
        team.setTeamName(teamDto.getTeamName());
        team.setFoundingYear(teamDto.getFoundingYear());
        team.setPresident(teamDto.getPresident());
        team.setCoach(teamDto.getCoach());

        Team savedTeam = teamService.saveTeam(team);
        return new ResponseEntity<>(convertToTeamResponseDto(savedTeam), HttpStatus.CREATED);
    }

    // Endpoint per trovare Squadre da Id (metodo GET)
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getTeamById(@PathVariable Long id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(value -> new ResponseEntity<>(convertToTeamResponseDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint per aggiornare un team esistente (metodo PUT)
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDto> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamRequestDto teamDto) {
        Optional<Team> teamOptional = teamService.getTeamById(id);

        if (teamOptional.isPresent()) {
            Team existingTeam = teamOptional.get();

            existingTeam.setTeamName(teamDto.getTeamName());
            existingTeam.setFoundingYear(teamDto.getFoundingYear());
            existingTeam.setPresident(teamDto.getPresident());
            existingTeam.setCoach(teamDto.getCoach());

            Team updatedTeam = teamService.saveTeam(existingTeam);
            return new ResponseEntity<>(convertToTeamResponseDto(updatedTeam), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per l'eliminazione di un Team (metodo DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // Endpoint per ottenere un Team dal nome (metodo GET)
    @GetMapping("/byName")
    public ResponseEntity<TeamResponseDto> getTeamByName(@RequestParam String name) {
        Team team = teamService.getTeamByName(name);
        if (team != null) {
            return new ResponseEntity<>(convertToTeamResponseDto(team), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per aggiungere un giocatore a una Squadra (metodo POST)
    @PostMapping("/{teamId}/players/{playerId}")
    public ResponseEntity<TeamResponseDto> addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        Team updatedTeam = teamService.addPlayerToTeam(teamId, playerId);

        return new ResponseEntity<>(convertToTeamResponseDto(updatedTeam), HttpStatus.OK);
    }

    // Endpoint per aggiungere una lista di giocatori a una squadra (metodo POST)
    @PostMapping("/{teamId}/players")
    public ResponseEntity<TeamResponseDto> addPlayersListToTeam(@PathVariable Long teamId, @RequestBody List<Long> playerIds) {
        Team updatedTeam = teamService.addPlayersListToTeam(teamId, playerIds);

        return new ResponseEntity<>(convertToTeamResponseDto(updatedTeam), HttpStatus.OK);
    }

    // Endpoint per rimuovere un giocatore da un team esistente (metodo DELETE)
    @DeleteMapping("/{teamId}/players/{playerId}")
    public ResponseEntity<TeamResponseDto> removePlayerFromTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        Team updatedTeam = teamService.removePlayerFromTeam(teamId, playerId);

        return new ResponseEntity<>(convertToTeamResponseDto(updatedTeam), HttpStatus.OK);
    }
}