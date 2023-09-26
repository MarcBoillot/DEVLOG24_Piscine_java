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
    private Date date;
    @OneToMany
    private List<Candidate> candidates = new ArrayList<Candidate>();

    /**
     * Constructeur de piscines
     * @param id id de a piscine
     * @param name nom de la piscine
     * @param town ville de la piscine
     * @param date date de la piscine ATTENTION actuellement au format yyyy/MM/dd
     */
    public Pools(int id, String name, String town, Date date) {
        this.id = id;
        this.name = name;
        this.town = town;
        this.date = date;
    }

    /**
     * Constructeur vide
     */
    public Pools(){

    }

}
