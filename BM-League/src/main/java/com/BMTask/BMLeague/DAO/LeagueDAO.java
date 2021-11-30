package com.BMTask.BMLeague.DAO;

import com.BMTask.BMLeague.Model.League;
import com.BMTask.BMLeague.Model.Participants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LeagueDAO {
    List<League> getAllLeagueMatches();
    void saveMatchLeague(League league);
}
