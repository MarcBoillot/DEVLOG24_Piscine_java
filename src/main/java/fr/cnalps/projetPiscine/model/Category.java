package fr.cnalps.projetPiscine.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a category with a unique title and a description.
 * The category's identifier is auto-generated.
 */

@Getter
@Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    /**
     * Establishes a one-to-many relationship between this category and multiple criteria.
     * The 'category' field in the {@link Criteria} class corresponds to the mapped relationship.
     * Any changes made to the Category instance would also cascade to the associated Criteria instances, and
     * if a Category instance is removed, its associated Criteria instances would also be removed (orphan removal).
     */
    @OneToMany(targetEntity =Criteria.class, mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Criteria> criterias = new ArrayList<>();

    @ManyToMany
//    @JsonBackReference
    @JoinTable (name = "poolsHasCategories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "pools_id") )
    private List<Pools> poolsHasCategories;

}
