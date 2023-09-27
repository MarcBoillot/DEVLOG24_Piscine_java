package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Criteria;
import fr.cnalps.projetPiscine.repository.CriteriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Criteria object.
 * Provides methods for CRUD operations on Criteria object.
 */
@Service
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;

    /**
     * Constructor for CriteriaService.
     *
     * @param criteriaRepository The repository for accessing Criteria entities from the database.
     */
    @Autowired
    public CriteriaService(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    /**
     * Creates and persists a new Criteria object.
     *
     * @param criteria The Criteria object to be created.
     * @return The created Criteria object.
     */
    public Criteria createCriteria (Criteria criteria){
        return criteriaRepository.save(criteria);
    }

    /**
     * Retrieves all Criteria object from the database.
     *
     * @return A list of all Criteria object.
     */
    public List<Criteria> getAllCriteria() {
        return (List<Criteria>) criteriaRepository.findAll();
    }

    /**
     * Retrieves a specific Criteria object by its ID.
     *
     * @param id The ID of the desired Criteria.
     * @return The Criteria object with the given ID or null if not found.
     */
    public Criteria getCriteriaById(int id) {
        return criteriaRepository.findById(id).orElse(null);
    }

    /**
     * Updates a specific Criteria object.
     *
     * @param id The ID of the Criteria to be updated.
     * @param criteria The updated Criteria object.
     * @return The updated Criteria object or null if not found.
     */
    public Criteria updateCriteria(int id, Criteria criteria) {
        if (criteriaRepository.existsById(id)) {
            criteria.setId(id);
            return criteriaRepository.save(criteria);
        }
        return null;
    }

    /**
     * Deletes a specific Criteria object by its ID.
     *
     * @param id The ID of the Criteria to be deleted.
     */
    public void deleteCriteria(int id) {
        if (criteriaRepository.existsById(id)) {
            criteriaRepository.deleteById(id);
        }
    }
}
