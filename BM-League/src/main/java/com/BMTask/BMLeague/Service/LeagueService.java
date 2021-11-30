package com.BMTask.BMLeague.Service;

import com.BMTask.BMLeague.Model.League;
import com.BMTask.BMLeague.Model.Participants;

import java.util.List;

public interface LeagueService {
    List<League> getAllLeagueMatches();
    void saveLeagueMatch(League league);
}
