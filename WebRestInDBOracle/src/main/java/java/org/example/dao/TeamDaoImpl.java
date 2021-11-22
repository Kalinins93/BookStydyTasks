package org.example.dao;

import org.example.model.Player;
import org.example.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao{
    private static final Logger logger = LoggerFactory.getLogger(PlayerDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Player> findByPlayers(Team team) {
        Session session =this.sessionFactory.getCurrentSession();
        List<Player> playerList =(List<Player>)session.createSQLQuery("select * from PLAYER where team_id="+team.getId().toString()).addEntity(Player.class).list();
        return playerList;
    }

    @Override
    public Team findTeamById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Team team =(Team)session.load(Team.class,id);
        return team;
    }

}
