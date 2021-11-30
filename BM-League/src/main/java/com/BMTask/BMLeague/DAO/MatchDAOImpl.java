package com.BMTask.BMLeague.DAO;

import com.BMTask.BMLeague.Model.Match;

import com.BMTask.BMLeague.Model.Participants;
import com.BMTask.BMLeague.Repository.MatchRepository;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class MatchDAOImpl implements MatchDAO{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MatchRepository matchRepository;
    @Override
    public List<Match> getFirstRound() {
        Session currentSession= entityManager.unwrap(Session.class);
        List<Match>  list = currentSession.createQuery("SELECT match from Match match where match.round = ?1")
                .setParameter(1, 1)
                .getResultList();
        return list;

    }

    @Override
    public Match updateWinnerResults(Match match, int id) {
        Match existingMatch = matchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
        existingMatch.setResult(match.getResult());
        existingMatch.setParticipants(match.getParticipants());
        matchRepository.save(existingMatch);
        return existingMatch;
    }

    @Override
    public List<Match> getAllMatches() {
        Session currentSession= entityManager.unwrap(Session.class);
        Query<Match> query = currentSession.createQuery("FROM Match",Match.class);
        List<Match> list =  query.getResultList();
        return list;
    }

    @Override
    public void updateWinner(Match match, int id) {
        Session currentSession= entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(match);

    }
}
