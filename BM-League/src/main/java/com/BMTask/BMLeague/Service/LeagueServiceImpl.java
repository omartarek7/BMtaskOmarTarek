package com.BMTask.BMLeague.Service;

import com.BMTask.BMLeague.DAO.LeagueDAO;
import com.BMTask.BMLeague.DAO.LeagueDAOImpl;
import com.BMTask.BMLeague.Model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@ComponentScan("com.BMTask.BMLeague.DAO")
public class LeagueServiceImpl implements LeagueService{

    @Autowired
    private LeagueDAOImpl leagueDAO;
    @Transactional
    @Override
    public List<League> getAllLeagueMatches() {
        return leagueDAO.getAllLeagueMatches();
    }

    @Transactional
    @Override
    public void saveLeagueMatch(League league) {
        leagueDAO.saveMatchLeague(league);
    }
}
