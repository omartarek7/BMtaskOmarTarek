package com.BMTask.BMLeague.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Table(name = "PARTICIPANTS")
public class Participants  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
    @SequenceGenerator(name = "COL_GEN", sequenceName = "PARTICIPANTS_ID_SEQ",allocationSize = 1)
    @Column(name = "PARTICIPANTS_ID")

    private Long participants_id ;

    @Column(name = "FULL_NAME")
    private String FullName;

    @Column(name = "GENDER")
    private String Gender;



    @Column(name = "EMAIL")
    private String Email;

    @OneToMany(mappedBy = "participants", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Participants> participants;

//    @OneToMany(mappedBy = "league")
//    Set<League> league;


    public Participants(){

    }

    public Participants(String fullName, String gender ,String email) {
        FullName = fullName;
        Gender = gender;
        Email = email;
    }

    public Long getParticipants_id() {
        return participants_id;
    }

    public void setParticipants_id(Long participants_id) {
        this.participants_id = participants_id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Set<Participants> getParticipants() {
        return participants;
    }
    @JsonIgnore
    public void setParticipants(Set<Participants> participants) {
        this.participants = participants;
    }
}
