package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Criteria;
import fr.cnalps.projetPiscine.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CriteriaController manages the web requests related to Criteria entities.
 * Provides endpoints for retrieving all Criteria and getting a specific Criteria by ID.
 */
@RestController
@RequestMapping(path="/criteria")
public class CriteriaController {

    @Autowired
    private final CriteriaService service;

    /**
     * Constructor for CriteriaController.
     *
     * @param service The CriteriaService to handle business logic related to Criteria entities.
     */
    public CriteriaController(CriteriaService service) {
        this.service = service;
    }

    /**
     * Creates a new Criteria object.
     *
     * @param criteria The Criteria object to be created.
     * @return The created Criteria object.
     */
    @PostMapping
    public Criteria createCriteria(@RequestBody Criteria criteria) {
        return service.createCriteria(criteria);
    }

    /**
     * Retrieves all Criteria object from the database.
     *
     * @return List of all Criteria object.
     */
    @GetMapping
    public List<Criteria> getAllCriteria(){
        return this.service.getAllCriteria();
    }

    /**
     * Retrieves a specific Criteria by its ID.
     *
     * @param id The ID of the Criteria object.
     * @return The Criteria entity matching the provided ID.
     */
    @GetMapping("/{id}")
    public Criteria getCriteriaById (@PathVariable(name = "id") int id) {
        return this.service.getCriteriaById(id);
    }

    /**
     * Updates a specific Criteria object by its ID.
     *
     * @param id The ID of the Criteria object.
     * @param criteria The updated Criteria object.
     * @return The updated Criteria object.
     */
    @PutMapping("/{id}")
    public Criteria updateCriteria(@PathVariable int id, @RequestBody Criteria criteria) {
        return service.updateCriteria(id, criteria);
    }

    /**
     * Deletes a specific Criteria object by its ID.
     *
     * @param id The ID of the Criteria object.
     */
    @DeleteMapping("/{id}")
    public void deleteCriteria(@PathVariable int id) {
        service.deleteCriteria(id);
    }
}
