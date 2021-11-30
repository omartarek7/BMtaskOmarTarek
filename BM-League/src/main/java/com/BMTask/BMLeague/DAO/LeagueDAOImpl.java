package com.BMTask.BMLeague.DAO;

import com.BMTask.BMLeague.Model.League;
import com.BMTask.BMLeague.Model.Participants;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class LeagueDAOImpl implements LeagueDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<League> getAllLeagueMatches() {
        Session currentSession= entityManager.unwrap(Session.class);
        Query<League> query = currentSession.createQuery("FROM League",League.class);
        List<League> list =  query.getResultList();
        return list;
    }

    @Override
    public void saveMatchLeague(League league) {
        Session currentSession= entityManager.unwrap(Session.class);
        currentSession.save(league);
    }
}
