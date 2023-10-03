package fr.cnalps.projetPiscine.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * Classe pour créer les piscines
 */
@Data
@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Pools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String town;
    private Date startdate;
    private Date enddate;

    @ManyToMany
//    @JsonManagedReference
    @JoinTable (name = "poolsHasCandidates",
            joinColumns = @JoinColumn(name = "pools_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id") )
    private List<Candidate> poolsHasCandidates;

    @ManyToMany
//    @JsonManagedReference
    @JoinTable (name = "poolsHasCategories",
            joinColumns = @JoinColumn (name = "pools_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> poolsHasCategories;

    @OneToMany(targetEntity =GroupCandidate.class, mappedBy = "pool", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<GroupCandidate> groupCandidates = new ArrayList<>();

    public Pools(int id, String name, String town, Date startdate, Date enddate) {
        this.id = id;
        this.name = name;
        this.town = town;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    /**
     * Constructeur vide
     */
    public Pools(){

    }

    public Pools(int id, String name, String town) {
        this.id = id;
        this.name = name;
        this.town = town;
    }
}
