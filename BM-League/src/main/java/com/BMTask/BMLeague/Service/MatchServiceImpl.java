package com.BMTask.BMLeague.Service;

import com.BMTask.BMLeague.DAO.MatchDAOImpl;
import com.BMTask.BMLeague.Model.Match;
import com.BMTask.BMLeague.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@ComponentScan("com.BMTask.BMLeague.DAO")
public class MatchServiceImpl  implements MatchService{

    @Autowired
    private MatchDAOImpl matchDAO;

    @Autowired
    private MatchRepository matchRepository;

    @Transactional
    @Override
    public List<Match> getFirstRoundData() {
        return matchDAO.getFirstRound();
    }

    @Override
    public Match updateWinnerResults(Match match, int match_id) {
        return matchDAO.updateWinnerResults(match,match_id);
    }

    @Override
    public List<Match> getAllMatches() {
        return matchDAO.getAllMatches();
    }

    @Override
    public Match updateWinner(Match match1, int match_id) {


            if (matchRepository.findById(match_id).isPresent()){
                Match existingVehicle = matchRepository.findById(match_id).get();

                existingVehicle.setResult(match1.getResult());
                existingVehicle.setParticipants(match1.getParticipants());

                Match updatedVehicle = matchRepository.save(existingVehicle);

                return updatedVehicle;
            }else{
                return null;
            }

    }
}
