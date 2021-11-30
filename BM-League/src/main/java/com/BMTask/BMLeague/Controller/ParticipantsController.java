package com.BMTask.BMLeague.Controller;

import com.BMTask.BMLeague.Model.Participants;
import com.BMTask.BMLeague.Service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@ComponentScan("com.BMTask.BMLeague.Service")
@RequestMapping("/api")
public class ParticipantsController {

@Autowired
private ParticipantsService participantsService;

@GetMapping("/getAllParticipants")
 public  List<Participants> getAll(){
 return participantsService.getAllPlayers();
}

@PostMapping("/newParticipant")
 public Participants saveNewParticipant(@RequestBody Participants participantsObj){
     participantsService.savePlayer(participantsObj);
     return participantsObj;
}

    @GetMapping("/getRandom")
    public  List<Participants> getRandomGroup(){
        return participantsService.getRandomNGroup();
    }

}
