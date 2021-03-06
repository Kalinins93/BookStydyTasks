package org.example.services;

import org.example.dao.PlayerDao;
import org.example.dao.TeamDao;
import org.example.model.Player;
import org.example.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicePlayerImpl implements ServicePlayer {
    @Autowired
    private PlayerDao playerDAO;
    @Autowired
    private TeamDao teamDao;
    @Override
    public Player findPlayerByID(int id) {
        Player player = this.playerDAO.findPlayerByID(id);
        return player;
    }

    @Override
    public void addPlayer(Player player) {
        this.playerDAO.addPlayer(player);
    }

    @Override
    public void updatePlayer(Player player) {
        this.playerDAO.updatePlayer(player);
    }

    @Override
    public void removePlayer(int id) {
        this.playerDAO.removePlayer(id);
    }

    @Override
    public List<Player> listPlayers() {

        return this.playerDAO.listPlayers();
    }

    @Override
    public List<Player> findPlayersByTeam(Team team) {

        return this.teamDao.findByPlayers(team);
    }

    @Override
    public Team findTeamByID(int id) {
        return this.teamDao.findTeamById(id);
    }
}
