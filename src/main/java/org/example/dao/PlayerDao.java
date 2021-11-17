package org.example.dao;

import org.example.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PlayerDao {

    public Player findPlayerByID(int id);

    public void addPlayer(Player player);

    public void updatePlayer(Player player);

    public void removePlayer(int id);

    public List<Player> listPlayers();
}
