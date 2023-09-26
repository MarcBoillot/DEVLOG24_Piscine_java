package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Observer;
import fr.cnalps.projetPiscine.repository.ObserverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Observer object.
 * Provides methods for CRUD operations on Observer object.
 */
@Service
public class ObserverService {

    private final ObserverRepository observerRepository;

    /**
     * Constructor for ObserverService.
     *
     * @param observerRepository The repository for accessing Observer object from the database.
     */
    @Autowired
    public ObserverService(ObserverRepository observerRepository) {
        this.observerRepository = observerRepository;
    }

    /**
     * Creates and persists a new Observer object.
     *
     * @param observer The Observer object to be created.
     * @return The created Observer object.
     */
    public Observer createObserver(Observer observer) {
        return observerRepository.save(observer);
    }

    /**
     * Retrieves all Observer object from the database.
     *
     * @return A list of all Observer object.
     */
    public List<Observer> getAllObserver() {
        return (List<Observer>) observerRepository.findAll();
    }

    /**
     * Retrieves a specific Observer object by its ID.
     *
     * @param id The ID of the desired Observer.
     * @return The Observer object with the given ID or null if not found.
     */
    public Observer getObserverById(int id) {
        return observerRepository.findById(id).orElse(null);
    }

    /**
     * Updates a specific Observer object.
     *
     * @param id The ID of the Observer to be updated.
     * @param observer The updated Observer object.
     * @return The updated Observer object or null if not found.
     */
    public Observer updateObserver(int id, Observer observer) {
        if (observerRepository.existsById(id)) {
            observer.setId(id);
            return observerRepository.save(observer);
        }
        return null;
    }

    /**
     * Deletes a specific Observer object by its ID.
     *
     * @param id The ID of the Observer to be deleted.
     */
    public void deleteObserver(int id) {
        if (observerRepository.existsById(id)) {
            observerRepository.deleteById(id);
        }
    }

}
