package org.example.dao;

import org.example.model.Player;
import org.example.model.Team;

public interface TeamDao {
    Team findByPlayers(Player player);
}
