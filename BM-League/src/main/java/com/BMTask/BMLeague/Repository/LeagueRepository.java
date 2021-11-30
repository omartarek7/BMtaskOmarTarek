package com.BMTask.BMLeague.Repository;

import com.BMTask.BMLeague.Model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League,Integer> {
}
