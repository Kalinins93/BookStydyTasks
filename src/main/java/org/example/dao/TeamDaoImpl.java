package org.example.dao;

import org.example.model.Player;
import org.example.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDaoImpl implements TeamDao{
    private static final Logger logger = LoggerFactory.getLogger(PlayerDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Team findByPlayers(Player player) {
        Session session =this.sessionFactory.getCurrentSession();
        Team team = (Team) session.load(Team.class, player.getTeam().getId());
        return team;
    }
}
