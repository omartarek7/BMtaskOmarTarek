package com.BMTask.BMLeague.Repository;

import com.BMTask.BMLeague.Model.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants,Long> {
}
