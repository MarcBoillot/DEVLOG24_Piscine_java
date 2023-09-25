package fr.cnalps.projetPiscine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Pools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String town;
    private Date date;

    public Pools(int id, String name, String town, Date date) {
        this.id = id;
        this.name = name;
        this.town = town;
        this.date = date;
    }
    public Pools(){

    }
}
