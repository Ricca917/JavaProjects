package com.FootballTeam.footballTeam.repository;

import com.FootballTeam.footballTeam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByTeamName(String teamName);
    Team findByCoach(String coach);
    // Aggiungere metodi a piacimento!
}
