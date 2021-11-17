package org.example.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "team_Sequence")
    @SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
    private Long team_id;

    @Column(name = "name")
    private String name;

    private List<Player> players;


}