package fr.cnalps.projetPiscine.model;

import jakarta.persistence.*;

/**
 * Represents an Observer object in the program.
 * This object has attributes like name, firstName, society, email, and a status which can be either 'administrateur' or 'observateur'.
 */
@Entity
public class Observer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String lastName;

    private String firstName;

    private String society;

    private String email;

    /**
     * Enum representation of the possible status for an Observer.
     */
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('administrateur','observateur')")
    private Status status;

    /**
     * Returns the ID of the Observer.
     *
     * @return the Observer's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the Observer.
     *
     * @param id the ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the name of the Observer.
     *
     * @return the Observer's name.
     */
    public String getName() {
        return lastName;
    }

    /**
     * Sets the name of the Observer.
     *
     * @param lastName the name to set.
     */
    public void setName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the Observer.
     *
     * @return the Observer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the Observer.
     *
     * @param firstName the first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the society of the Observer.
     *
     * @return the Observer's society.
     */
    public String getSociety() {
        return society;
    }

    /**
     * Sets the society of the Observer.
     *
     * @param society the society to set.
     */
    public void setSociety(String society) {
        this.society = society;
    }

    /**
     * Returns the email of the Observer.
     *
     * @return the Observer's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the Observer.
     *
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the status of the Observer.
     *
     * @return the Observer's status.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the Observer.
     *
     * @param status the status to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Enum representing the possible status values for an Observer: 'administrateur' and 'observateur'.
     */
    public enum Status {
        administrateur, observateur;
    }
}
