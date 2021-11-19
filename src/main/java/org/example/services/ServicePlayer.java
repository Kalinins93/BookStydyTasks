package org.example.services;

import org.example.model.Player;
import org.example.model.Team;

import java.util.List;

public interface ServicePlayer  {

    public Player findPlayerByID(int id);

    public void addPlayer(Player player);

    public void updatePlayer(Player player);

    public void removePlayer(int id);

    public List<Player> listPlayers();
    public List<Player> findPlayersByTeam(Team team);
    public Team findTeamByID(int id);
}
