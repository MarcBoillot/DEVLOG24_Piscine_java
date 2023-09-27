package fr.cnalps.projetPiscine.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PoolsHasCandidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pools_id")
    private Pools pools;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
