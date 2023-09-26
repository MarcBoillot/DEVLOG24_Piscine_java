package fr.cnalps.projetPiscine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Category {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(unique = true, nullable = false, length = 50)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    private String decription;

}
