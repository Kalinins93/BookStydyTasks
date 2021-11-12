package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_Sequence")
    @SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num")
    private int num;

    @Column(name = "position")
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

}