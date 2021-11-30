package com.BMTask.BMLeague.DAO;

import com.BMTask.BMLeague.Model.Participants;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ParticipantsDAO {
    List<Participants> getAllPlayers();
    void savePlayer(Participants participants);
    List<Participants> getRandomNGroup();
}
