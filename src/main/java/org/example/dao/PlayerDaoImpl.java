package org.example.dao;

import org.example.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PlayerDaoImpl implements  PlayerDao{
    private static final Logger logger = LoggerFactory.getLogger(PlayerDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Player findPlayerByID(int id) {
        Integer findId=Integer.parseInt(String.valueOf(id));
        Session session =this.sessionFactory.getCurrentSession();
        Player player = (Player) session.load(Player.class, Integer.valueOf(findId));
        return player;
    }

    @Override
    public void addPlayer(Player player) {
        Session session =this.sessionFactory.getCurrentSession();
        session.persist(player);

    }

    @Override
    public void updatePlayer(Player player) {
        Session session =this.sessionFactory.getCurrentSession();
        session.update(player);
    }

    @Override
    public void removePlayer(int id) {
        Integer removeId=Integer.parseInt(String.valueOf(id));
        Session session =this.sessionFactory.getCurrentSession();
        Player player = (Player) session.load(Player.class, Integer.valueOf(removeId));
        if(player!=null){
            session.delete(player);
        }
    }


        @Override
        @SuppressWarnings("unchecked")
         public List<Player> listPlayers() {
        Session session =this.sessionFactory.getCurrentSession();
        List<Player> players =session.createQuery("SELECT * FROM PLAYER").list();
            for(Player player: players){
                logger.info("Player list: " + player);
            }
        return players;
    }
}
