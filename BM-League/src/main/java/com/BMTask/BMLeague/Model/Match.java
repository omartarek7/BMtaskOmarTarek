package com.BMTask.BMLeague.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Entity
@Table(name = "MATCHES")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
    @SequenceGenerator(name = "COL_GEN", sequenceName = "MATCHES_ID_SEQ",allocationSize = 1)
    @Column(name = "MATCH_ID")
    private int match_id;

//,unique=true
    @Column(name = "ROUND")
    private int round;

    @Column(name = "RESULT")
    private String result;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "winner", nullable = false)
    private Participants participants;

//    @OneToMany(mappedBy = "league",fetch=FetchType.LAZY)
//    Set<League> league;

    public Match(){}
    public Match(int round, String result) {
        this.round = round;
        this.result = result;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getRound() { return round; }

    public void setRound(int round) {
        this.round = round;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
    }

}
