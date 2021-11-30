package com.BMTask.BMLeague.Service;

import com.BMTask.BMLeague.Model.Participants;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface ParticipantsService {

    List<Participants> getAllPlayers();
    void savePlayer(Participants participants);
    List<Participants> getRandomNGroup();
}
