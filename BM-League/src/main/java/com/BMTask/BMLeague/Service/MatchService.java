package com.BMTask.BMLeague.Service;

import com.BMTask.BMLeague.Model.Match;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MatchService {

    List<Match> getFirstRoundData();
    Match updateWinnerResults(Match match,int match_id);
    List<Match> getAllMatches();
    Match updateWinner(Match match,int match_id);
}
