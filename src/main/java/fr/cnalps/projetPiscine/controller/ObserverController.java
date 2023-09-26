package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Observer;
import fr.cnalps.projetPiscine.service.ObserverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ObserverController manages the web requests related to Observer entities.
 * Provides endpoints for retrieving all Observers and getting a specific Observer by ID.
 */
@RestController
@RequestMapping(path="/observer")
public class ObserverController {
    @Autowired
    private final ObserverService service;

    /**
     * Constructor for ObserverController.
     *
     * @param service The ObserverService to handle business logic related to Observer entities.
     */
    public ObserverController(ObserverService service){
        this.service = service;
    }

    /**
     * Creates a new Observer object.
     *
     * @param observer The Observer object to be created.
     * @return The created Observer object.
     */
    @PostMapping
    public Observer createObserver(@RequestBody Observer observer) {
        return service.createObserver(observer);
    }

    /**
     * Retrieves all Observer object from the database.
     *
     * @return List of all Observer object.
     */
    @GetMapping
    public List<Observer> getAllObserver(){
        return this.service.getAllObserver();
    }

    /**
     * Retrieves a specific Observer by its ID.
     *
     * @param id The ID of the Observer object.
     * @return The Observer entity matching the provided ID.
     */
    @GetMapping("/{id}")
    public Observer getObserverById (@PathVariable(name = "id") int id) {
        return this.service.getObserverById(id);
    }

    /**
     * Updates a specific Observer object by its ID.
     *
     * @param id The ID of the Observer object.
     * @param observer The updated Observer object.
     * @return The updated Observer object.
     */
    @PutMapping("/{id}")
    public Observer updateObserver(@PathVariable int id, @RequestBody Observer observer) {
        return service.updateObserver(id, observer);
    }

    /**
     * Deletes a specific Observer object by its ID.
     *
     * @param id The ID of the Observer object.
     */
    @DeleteMapping("/{id}")
    public void deleteObserver(@PathVariable int id) {
        service.deleteObserver(id);
    }

}