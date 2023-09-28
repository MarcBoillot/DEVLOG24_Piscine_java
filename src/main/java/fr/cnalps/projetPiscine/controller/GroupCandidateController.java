package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.GroupCandidate;
import fr.cnalps.projetPiscine.service.GroupCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GroupCandidateController manages the web requests related to GroupCandidate entities.
 * Provides endpoints for retrieving all GroupCandidate and getting a specific GroupCandidate by ID.
 */
@RestController
@RequestMapping(path="/group")
public class GroupCandidateController {

    @Autowired
    private final GroupCandidateService service;

    /**
     * Constructor for GroupCandidateController.
     *
     * @param service The GroupCandidateService to handle business logic related to GroupCandidate entities.
     */
    public GroupCandidateController(GroupCandidateService service) {
        this.service = service;
    }

    /**
     * Creates a new GroupCandidate object.
     *
     * @param groupCandidate The GroupCandidate object to be created.
     * @return The created GroupCandidate object.
     */
    @PostMapping
    public GroupCandidate createGroupCandidate(@RequestBody GroupCandidate groupCandidate) {
        return service.createGroupCandidate(groupCandidate);
    }

    /**
     * Retrieves all GroupCandidate object from the database.
     *
     * @return List of all GroupCandidate object.
     */
    @GetMapping
    public List<GroupCandidate> getAllGroupCandidate(){
        return this.service.getAllGroupCandidate();
    }

    /**
     * Retrieves a specific GroupCandidate by its ID.
     *
     * @param id The ID of the GroupCandidate object.
     * @return The GroupCandidate entity matching the provided ID.
     */
    @GetMapping("/{id}")
    public GroupCandidate getGroupCandidateById (@PathVariable(name = "id") int id) {
        return this.service.getGroupCandidateById(id);
    }

    /**
     * Updates a specific GroupCandidate object by its ID.
     *
     * @param id The ID of the GroupCandidate object.
     * @param groupCandidate The updated GroupCandidate object.
     * @return The updated GroupCandidate object.
     */
    @PutMapping("/{id}")
    public GroupCandidate updateGroupCandidate(@PathVariable int id, @RequestBody GroupCandidate groupCandidate) {
        return service.updateGroupCandidate(id, groupCandidate);
    }

    /**
     * Deletes a specific GroupCandidate object by its ID.
     *
     * @param id The ID of the GroupCandidate object.
     */
    @DeleteMapping("/{id}")
    public void deleteGroupCandidate(@PathVariable int id) {
        service.deleteGroupCandidate(id);
    }
}
