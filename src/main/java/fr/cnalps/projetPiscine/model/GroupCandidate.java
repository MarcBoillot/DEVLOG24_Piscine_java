package fr.cnalps.projetPiscine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a group of candidat with a title not null.
 * The group identifier is auto-generated.
 */
@Getter
@Setter
@Entity
@Table(name = "GROUPCANDIDATE")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class GroupCandidate {

    /**
     * The unique identifier for the group.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The title for the group.
     * This field cannot be null and has a maximum length of 100 characters.
     */
    @Column(nullable = false, length = 100)
    private String title;

    /**
     * Establishes a one-to-many relationship between this group and multiple candidate.
     * The 'groupcandidate' field in the {@link Candidate} class corresponds to the mapped relationship.
     * Any changes made to the group instance would also cascade to the associated Candidate instances.
     */
    @OneToMany(targetEntity =Candidate.class, mappedBy = "groupcandidate", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Candidate> candidates = new ArrayList<>();

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "pool_id", nullable = false)
    private Pools pool;
}
