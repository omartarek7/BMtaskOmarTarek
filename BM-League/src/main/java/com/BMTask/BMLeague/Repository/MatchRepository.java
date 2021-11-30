package com.BMTask.BMLeague.Repository;

import com.BMTask.BMLeague.Model.Match;
import com.BMTask.BMLeague.Model.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {


//        @Modifying(clearAutomatically = true)
//        @Query("UPDATE Matches m SET m.winner = :winner and m.round = :round WHERE m.match_id = :match_id")
//        int updateMatch(@Param("match_id") int match_id, @Param("round") int round , @Param("winner") int winner);


        @Transactional
        @Modifying
        @Query("DELETE FROM Match WHERE round = :round")
        Integer deleteByRound(int round);

//        @Transactional
//        @Modifying
//        @Query("update FROM Match m Set m.result = :result and m.winner = :participants_id WHERE match_id = :match_id")
//        Integer updateByRP(int match_id, int result, Participants participants_id);
}
