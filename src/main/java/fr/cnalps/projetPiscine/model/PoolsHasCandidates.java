package fr.cnalps.projetPiscine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Classe de la table d'association pools / candidates
 */
@Entity
@Getter
public class PoolsHasCandidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pools_id")
    private Pools pools;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
