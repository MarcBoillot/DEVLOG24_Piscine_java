package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Users;
import fr.cnalps.projetPiscine.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Observer object.
 * Provides methods for CRUD operations on Observer object.
 */
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Creates and persists a new Observer object.
     *
     * @param observer The Observer object to be created.
     * @return The created Observer object.
     */
    public Users createUser(Users observer) {
        return usersRepository.save(observer);
    }

    /**
     * Retrieves all Observer object from the database.
     *
     * @return A list of all Observer object.
     */
    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    /**
     * Retrieves a specific Observer object by its ID.
     *
     * @param id The ID of the desired Observer.
     * @return The Observer object with the given ID or null if not found.
     */
    public Users getUsersById(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    /**
     * Updates a specific Observer object.
     *
     * @param id The ID of the Observer to be updated.
     * @param observer The updated Observer object.
     * @return The updated Observer object or null if not found.
     */
    public Users updateUsers(int id, Users observer) {
        if (usersRepository.existsById(id)) {
            observer.setId(id);
            return usersRepository.save(observer);
        }
        return null;
    }

    /**
     * Deletes a specific Observer object by its ID.
     *
     * @param id The ID of the Observer to be deleted.
     */
    public void deleteUsers(int id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
        }
    }

}
