package com.BMTask.BMLeague.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LEAGUE")
public class League implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
    @SequenceGenerator(name = "COL_GEN", sequenceName = "LEAGUE_ID_SEQ",allocationSize = 1)
    @Column(name = "LEAGUE_ID")
    private int League_id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "participants_id" , nullable = false)
    Participants participants;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "match_id" , nullable = false)
    Match match;
    @Column(name = "time")
    LocalDateTime time;



    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "league_champion" , nullable = false)
    Participants participants2;


    public League(){}
    public League(LocalDateTime time) {

        this.time = time;
    }

    public int getLeague_id() {
        return League_id;
    }

    public void setLeague_id(int league_id) {
        League_id = league_id;
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Participants getParticipants2() {
        return participants2;
    }

    public void setParticipants2(Participants participants2) {
        this.participants2 = participants2;
    }
}
