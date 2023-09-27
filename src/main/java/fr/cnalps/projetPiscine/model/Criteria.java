package fr.cnalps.projetPiscine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a criteria with a unique title and a description.
 * The criteria identifier is auto-generated.
 */
@Getter
@Setter
@Entity
public class Criteria {

    /**
     * The unique identifier for the criteria.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The unique title for the criteria.
     * This field cannot be null and has a maximum length of 50 characters.
     */
    @Column(unique = true, nullable = false, length = 50)
    private String title;

    /**
     * A brief description of the category.
     */
    private String description;
}
