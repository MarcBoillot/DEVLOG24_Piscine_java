package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.GroupCandidate;
import fr.cnalps.projetPiscine.repository.GroupCandidateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing GroupCandidate object.
 * Provides methods for CRUD operations on GroupCandidate object.
 */
@Service
public class GroupCandidateService {

    private final GroupCandidateRepository groupCandidateRepository;

    /**
     * Constructor for GroupCandidateService.
     *
     * @param groupCandidateRepository The repository for accessing GroupCandidate entities from the database.
     */
    @Autowired
    public GroupCandidateService(GroupCandidateRepository groupCandidateRepository) {
        this.groupCandidateRepository = groupCandidateRepository;
    }

    /**
     * Creates and persists a new GroupCandidate object.
     *
     * @param groupCandidate The GroupCandidate object to be created.
     * @return The created GroupCandidate object.
     */
    public GroupCandidate createGroupCandidate (GroupCandidate groupCandidate){
        return groupCandidateRepository.save(groupCandidate);
    }

    /**
     * Retrieves all GroupCandidate object from the database.
     *
     * @return A list of all GroupCandidate object.
     */
    public List<GroupCandidate> getAllGroupCandidate() {
        return (List<GroupCandidate>) groupCandidateRepository.findAll();
    }

    /**
     * Retrieves a specific GroupCandidate object by its ID.
     *
     * @param id The ID of the desired GroupCandidate.
     * @return The GroupCandidate object with the given ID or null if not found.
     */
    public GroupCandidate getGroupCandidateById(int id) {
        return groupCandidateRepository.findById(id).orElse(null);
    }

    /**
     * Updates a specific GroupCandidate object.
     *
     * @param id The ID of the GroupCandidate to be updated.
     * @param groupCandidate The updated GroupCandidate object.
     * @return The updated GroupCandidate object or null if not found.
     */
    public GroupCandidate updateGroupCandidate(int id, GroupCandidate groupCandidate) {
        if (groupCandidateRepository.existsById(id)) {
            groupCandidate.setId(id);
            return groupCandidateRepository.save(groupCandidate);
        }
        return null;
    }

    /**
     * Deletes a specific GroupCandidate object by its ID.
     *
     * @param id The ID of the GroupCandidate to be deleted.
     */
    public void deleteGroupCandidate(int id) {
        if (groupCandidateRepository.existsById(id)) {
            groupCandidateRepository.deleteById(id);
        }
    }
}
