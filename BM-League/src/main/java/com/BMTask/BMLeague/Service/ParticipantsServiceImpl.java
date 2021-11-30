package com.BMTask.BMLeague.Service;


import com.BMTask.BMLeague.DAO.ParticipantsDAO;
import com.BMTask.BMLeague.DAO.ParticipantsDAOImpl;
import com.BMTask.BMLeague.Model.Participants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Component
@ComponentScan("com.BMTask.BMLeague.DAO")
public class ParticipantsServiceImpl implements ParticipantsService {

    @Autowired
    private ParticipantsDAOImpl participantsDAO;


    @Transactional
    @Override
    public List<Participants> getAllPlayers() {
        return participantsDAO.getAllPlayers();
    }


    @Transactional
    @Override
    public void savePlayer(Participants participants) {
        participantsDAO.savePlayer(participants);
    }
    @Transactional
    @Override
    public List<Participants> getRandomNGroup() {
        return participantsDAO.getRandomNGroup();
    }
}
