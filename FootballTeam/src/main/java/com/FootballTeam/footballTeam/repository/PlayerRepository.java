package com.FootballTeam.footballTeam.repository;
import com.FootballTeam.footballTeam.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // Definisco a Spring che questa interfaccia è un componente Repo/DAO
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeamId(Long teamId); // Cerca Giocatore per Id
    List<Player> findByPosition(String position); // Cerca Giocatore per Posizione
    List<Player> findByFirstName(String firstName);
    List<Player> findByLastName(String lastName);
    List<Player> findByNationality(String nationality);
    List<Player> findByIsFreeAgentTrue();
    // Aggiungere metodi a piacimento!
}
