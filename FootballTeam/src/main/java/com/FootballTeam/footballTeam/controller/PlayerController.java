package com.FootballTeam.footballTeam.controller;

import com.FootballTeam.footballTeam.dto.PlayerRequestDto;
import com.FootballTeam.footballTeam.dto.PlayerResponseDto;
import com.FootballTeam.footballTeam.model.Player;
import com.FootballTeam.footballTeam.model.Team;
import com.FootballTeam.footballTeam.service.PlayerService;
import com.FootballTeam.footballTeam.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Per gestire i codici di stato (es. 400 e 200)
import org.springframework.http.ResponseEntity; // Questo server per risposte HTTP
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // Definisco questa classe come REST Controller
@RequestMapping("/api/players") // Definisco una Route per le API relative ai Players
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;

    @Autowired // Spring si occupa direttamente dell'iniezione!
    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    // Mappo Player con PlayerResponseDto
    private PlayerResponseDto convertToPlayerResponseDto(Player player) {
        Long teamId = (player.getTeam() != null) ? player.getTeam().getId() : null;
        String teamName = (player.getTeam() != null) ? player.getTeam().getTeamName() : null;

        return new PlayerResponseDto(
                player.getId(),
                player.getFirstName(),
                player.getLastName(),
                player.getPosition(),
                player.getDateOfBirth(),
                player.getNationality(),
                player.getIsFreeAgent(),
                teamId,
                teamName,
                player.getAge(),
                player.getJerseyNumber(),
                player.getAppearances(),
                player.getGoals()
        );
    }

    // Endpoint per creare un Giocatore
    // Inserisco i dati del DTO su Player
    @PostMapping
    public ResponseEntity<PlayerResponseDto> createPlayer(@Valid @RequestBody PlayerRequestDto playerDto) { // Applicazione DTO e @Valid per validazione
        Player player = new Player();   // Creazione entità player!
        player.setFirstName(playerDto.getFirstName());
        player.setLastName(playerDto.getLastName());
        player.setNationality(playerDto.getNationality());
        player.setAge(playerDto.getAge());
        player.setDateOfBirth(playerDto.getDateOfBirth());
        player.setPosition(playerDto.getPosition());
        player.setJerseyNumber(playerDto.getJerseyNumber());
        player.setAppearances(playerDto.getAppearances());
        player.setGoals(playerDto.getGoals());
        player.setIsFreeAgent(playerDto.getIsFreeAgent());

    // Gestione dell'associazione team-player se l'ID è presente nel DTO
        if (playerDto.getTeamId() != null) {
            Optional<Team> teamOptional = teamService.getTeamById(playerDto.getTeamId());
            if (teamOptional.isPresent()) {
                player.setTeam(teamOptional.get());
            } else {
                System.out.println("Attenzione! Team con ID " + playerDto.getTeamId() + " non trovato");
            }
        } else {
            player.setTeam(null);
        }

        Player savedPlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(convertToPlayerResponseDto(savedPlayer), HttpStatus.CREATED);
    }

    // Endpoint per ottenere TUTTI i giocatori (Metodo GET)
    // Restituisce la lista di tutti i giocatori con status 200 "OK"
    @GetMapping
    public ResponseEntity<List<PlayerResponseDto>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        List<PlayerResponseDto> playerDtos = players.stream()
                .map(this::convertToPlayerResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(playerDtos, HttpStatus.OK);
    }

    // Endpoint per ottenere un giocatore tramite Id (metodo GET)
    // Se il giocatore è presente, ritorna 200 "OK" altrimenti 400 "NOT_FOUND"
    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(value -> new ResponseEntity<>(convertToPlayerResponseDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint per aggiornare un giocatore esistente (metodo PUT)
    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> updatePlayer(@PathVariable Long id, @Valid @RequestBody PlayerRequestDto playerDto) {
        Optional<Player> playerOptional = playerService.getPlayerById(id);

        if (playerOptional.isPresent()) {
            Player existingPlayer = playerOptional.get();

            // Aggiornamento dati del Giocatore con DTO
            existingPlayer.setFirstName(playerDto.getFirstName());
            existingPlayer.setLastName(playerDto.getLastName());
            existingPlayer.setNationality(playerDto.getNationality());
            existingPlayer.setAge(playerDto.getAge());
            existingPlayer.setDateOfBirth(playerDto.getDateOfBirth());
            existingPlayer.setPosition(playerDto.getPosition());
            existingPlayer.setJerseyNumber(playerDto.getJerseyNumber());
            existingPlayer.setAppearances(playerDto.getAppearances());
            existingPlayer.setGoals(playerDto.getGoals());
            existingPlayer.setIsFreeAgent(playerDto.getIsFreeAgent());

            // Aggiornamento del team (es. Trasferimento giocatore)
            if (playerDto.getTeamId() != null) {
                Optional<Team> teamOptional = teamService.getTeamById(playerDto.getTeamId());
                if (teamOptional.isPresent()) {
                    existingPlayer.setTeam(teamOptional.get());
                } else {
                    System.out.println("Attenzione! Team con ID " + playerDto.getTeamId() + " non trovato!");
                }
            } else {
                existingPlayer.setTeam(null); // Svincola il giocatore se non ha una squadra a lui associata!
            }

            Player updatedPlayer = playerService.savePlayer(existingPlayer);
            return new ResponseEntity<>(convertToPlayerResponseDto(updatedPlayer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per eliminare un giocatore (metodo DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per ottenere giocatori per ruolo (metodo GET)
    // ES. /api/players/byPosition?position=Attaccante
    @GetMapping("/ByPosition")
    public ResponseEntity<List<PlayerResponseDto>> getPlayersByPosition(@RequestParam String position) {
        List<Player> players = playerService.getPlayerByPosition(position);
        List<PlayerResponseDto> playerDtos = players.stream()
                .map(this:: convertToPlayerResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(playerDtos, HttpStatus.OK);
    }

    // Endpoint per ottenere giocatori svincolati [(senza squadra) metodo GET]
    @GetMapping("/free")
    public ResponseEntity<List<PlayerResponseDto>> getFreePlayers() {
        List<Player> players = playerService.getFreePlayers();
        List<PlayerResponseDto> playerDtos = players.stream()
                .map(this::convertToPlayerResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(playerDtos, HttpStatus.OK); // 200 OK + Lista giocatori svincolati
    }

    @GetMapping("/ByNationality")
    public ResponseEntity<List<PlayerResponseDto>> getPlayersByNationality(@RequestParam String nationality) {
        List<Player> players = playerService.getPlayersByNationality(nationality);
        List<PlayerResponseDto> playerDtos = players.stream()
                .map(this::convertToPlayerResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(playerDtos,HttpStatus.OK); // 200 OK  + Giocatori per nazionalità
    }
}