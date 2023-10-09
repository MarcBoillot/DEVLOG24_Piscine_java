package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Users;
import fr.cnalps.projetPiscine.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ObserverController manages the web requests related to Observer entities.
 * Provides endpoints for retrieving all Observers and getting a specific Observer by ID.
 */
@RestController
@RequestMapping(path="/observer")
public class UsersController {
    @Autowired
    private final UsersService service;

    /**
     * Constructor for ObserverController.
     *
     * @param service The ObserverService to handle business logic related to Observer entities.
     */
    public UsersController(UsersService service){
        this.service = service;
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return service.createUser(user);
    }

    /**
     * Retrieves all Observer object from the database.
     *
     * @return List of all Observer object.
     */
    @GetMapping
    public List<Users> getAllUsers(){
        return this.service.getAllUsers();
    }

    /**
     * Retrieves a specific Observer by its ID.
     *
     * @param id The ID of the Observer object.
     * @return The Observer entity matching the provided ID.
     */
    @GetMapping("/{id}")
    public Users getUsersById (@PathVariable(name = "id") int id) {
        return this.service.getUsersById(id);
    }

    /**
     * Updates a specific Observer object by its ID.
     *
     * @param id The ID of the Observer object.
     * @param observer The updated Observer object.
     * @return The updated Observer object.
     */
    @PutMapping("/{id}")
    public Users updateUsers(@PathVariable int id, @RequestBody Users observer) {
        return service.updateUsers(id, observer);
    }

    /**
     * Deletes a specific Observer object by its ID.
     *
     * @param id The ID of the Observer object.
     */
    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable int id) {
        service.deleteUsers(id);
    }

}