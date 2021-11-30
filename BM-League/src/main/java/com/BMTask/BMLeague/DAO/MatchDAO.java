package com.BMTask.BMLeague.DAO;

import com.BMTask.BMLeague.Model.Match;
import com.BMTask.BMLeague.Model.Participants;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MatchDAO {

    List<Match> getFirstRound();
    Match updateWinnerResults(Match match,int id);
    List<Match> getAllMatches();
    void updateWinner(Match match,int id);
}
