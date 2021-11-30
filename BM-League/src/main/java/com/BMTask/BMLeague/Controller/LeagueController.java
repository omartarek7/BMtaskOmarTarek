package com.BMTask.BMLeague.Controller;

import com.BMTask.BMLeague.Model.League;
import com.BMTask.BMLeague.Model.Participants;
import com.BMTask.BMLeague.Service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@ComponentScan("com.BMTask.BMLeague.Service")
@RequestMapping("/api")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;
    @GetMapping("/getAllLeagueMatches")
    public List<League> getAllLeagues(){

        return leagueService.getAllLeagueMatches();
    }

    @PostMapping("/newLeague")
    public League saveNewLeague(@RequestBody League leagueObj) {
        leagueService.saveLeagueMatch(leagueObj);
        return leagueObj;
    }

}
