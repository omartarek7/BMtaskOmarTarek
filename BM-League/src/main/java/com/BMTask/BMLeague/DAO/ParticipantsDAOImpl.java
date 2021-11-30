package com.BMTask.BMLeague.DAO;

import com.BMTask.BMLeague.Model.Participants;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class ParticipantsDAOImpl implements ParticipantsDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Participants> getAllPlayers() {

        Session currentSession= entityManager.unwrap(Session.class);
        Query<Participants> query = currentSession.createQuery("FROM Participants",Participants.class);
        List<Participants> list =  query.getResultList();


    return list;
    }
    @Override
    public void savePlayer(Participants participants) {
        Session currentSession= entityManager.unwrap(Session.class);
        currentSession.save(participants);
    }

    @Override
    public List<Participants> getRandomNGroup() {
        Session currentSession= entityManager.unwrap(Session.class);
        Query<Participants> query = currentSession.createQuery("FROM Participants",Participants.class);
        List<Participants> list =  query.getResultList();

        //Random rand = new Random();
        //Participants randomElement = list.get(rand.nextInt(list.size()));
        Collections.shuffle(list);

        int randomSeriesLength = 3;

        List<Participants> randomSeries = list.subList(0, randomSeriesLength);
        return randomSeries;
    }
}
