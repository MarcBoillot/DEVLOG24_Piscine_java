package fr.cnalps.projetPiscine.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe pour créer les piscines
 */
@Data
@Entity
public class Pools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String town;
    private Date startdate;
    private Date enddate;
    @OneToMany
    private List<Candidate> candidates = new ArrayList<Candidate>();

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

}
