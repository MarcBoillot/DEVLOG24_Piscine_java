package fr.cnalps.projetPiscine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a category with a unique title and a description.
 * The category's identifier is auto-generated.
 */

@Getter
@Setter
@Entity
public class Category {

    /**
     * The unique identifier for the category.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The unique title for the category.
     * This field cannot be null and has a maximum length of 50 characters.
     */

    @Column(unique = true, nullable = false, length = 50)
    private String title;

    /**
     * A brief description of the category.
     */

    private String description;

}
