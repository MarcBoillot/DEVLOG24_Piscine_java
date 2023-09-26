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
@RequestMapping(path="/piscine")
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
     * Retrieves all Observer entities from the database.
     *
     * @return List of all Observer entities.
     */
    @GetMapping("/observer")
    public List<Observer> getAllObserver(){
        List<Observer> observerList = this.service.getAllObserver();
        return observerList ;
    }

    /**
     * Retrieves a specific Observer by its ID.
     *
     * @param id The ID of the Observer entity.
     * @return The Observer entity matching the provided ID.
     */
    @GetMapping("/observer/{id}")
    public Observer getObserverById (@PathVariable(name = "id") int id) {
        return this.service.getObserverById(id);
    }

}