package org.example.services;

import org.example.model.Player;

import java.util.List;

public interface ServicePlayer  {

    public Player findPlayerByID(int id);

    public void addPlayer(Player player);

    public void updatePlayer(Player player);

    public void removePlayer(int id);

    public List<Player> listPlayers();
}
