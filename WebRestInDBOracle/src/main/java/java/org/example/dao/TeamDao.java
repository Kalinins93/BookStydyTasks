package org.example.dao;

import org.example.model.Player;
import org.example.model.Team;

import java.util.List;

public interface TeamDao {
    List<Player> findByPlayers(Team team);
    Team findTeamById(int id);
}
