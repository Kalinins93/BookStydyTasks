package org.example.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByPlayers(long playerId);

    Team findOne(long l);
}