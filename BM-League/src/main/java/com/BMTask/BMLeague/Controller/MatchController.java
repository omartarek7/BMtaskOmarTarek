package com.BMTask.BMLeague.Controller;

import com.BMTask.BMLeague.Model.Match;
import com.BMTask.BMLeague.Model.Participants;
import com.BMTask.BMLeague.Repository.MatchRepository;
import com.BMTask.BMLeague.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@ComponentScan("com.BMTask.BMLeague.Service")
@RequestMapping("/api")
public class MatchController {

        @Autowired
        private MatchService matchService;

        @Autowired
        private MatchRepository matchRepository;
        @GetMapping("/getAllFirstRound")
        public List<Match> getAll(){

            return matchService.getFirstRoundData();
        }

        @PostMapping("/updateWinnerResult/{match_id}")
        public ResponseEntity<Match> updateWinnerR(@RequestBody Match match,@PathVariable("match_id") int match_id){
//        return
//         new ResponseEntity<Match>(
//                 matchService.updateWinnerResults(match,match_id)
//                 , HttpStatus.OK);

                Optional<Match> MatchData = matchRepository.findById(match_id);

                if (MatchData.isPresent()) {
                        Match match1 = MatchData.get();
                        match1.setResult(match.getResult());
                        match1.setParticipants(match.getParticipants());

                        return new ResponseEntity<>(matchRepository.save(match1), HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        }
        @GetMapping("/getAllMatches")
        public List<Match> getAllMatches(){

                return matchService.getAllMatches();
        }

        @PostMapping(value = "/updateWinner/{match_id}" , produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<Match> updateWinner(@RequestBody Match match,@PathVariable(value = "match_id") int match_id){


                        return new ResponseEntity<Match>(matchService.updateWinner(match,match_id), HttpStatus.OK);
                }


        @DeleteMapping("/delete/{round}")
        public ResponseEntity<String> deleteByRound(@PathVariable int round) {
                return new ResponseEntity<String>(matchRepository.deleteByRound(round)+" record(s) deleted", HttpStatus.OK);
        }

//        @PutMapping("/update/{match_id}/{result}/{participants_id}")
//        public ResponseEntity<String> update(@PathVariable int match_id, @PathVariable int result, @PathVariable Participants participants) {
//                return new ResponseEntity<String>(matchRepository.updateByRP(match_id,result,participants)+" record(s) updated", HttpStatus.OK);
//        }

}
