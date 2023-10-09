package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Category;
import fr.cnalps.projetPiscine.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Category object.
 * Provides methods for CRUD operations on Category object.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Constructor for CategoryService.
     *
     * @param categoryRepository The repository for accessing Category entities from the database.
     */
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Creates and persists a new Category object.
     *
     * @param category The Category object to be created.
     * @return The created Category object.
     */
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Retrieves all Category object from the database.
     *
     * @return A list of all Category object.
     */
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    /**
     * Retrieves a specific Category object by its ID.
     *
     * @param id The ID of the desired Category.
     * @return The Category object with the given ID or null if not found.
     */
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * Updates a specific Category object.
     *
     * @param id The ID of the Category to be updated.
     * @param category The updated Category object.
     * @return The updated Category object or null if not found.
     */
    public Category updateCategory(int id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }

    /**
     * Deletes a specific Category object by its ID.
     *
     * @param id The ID of the Category to be deleted.
     */
    public void deleteCategory(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
    }

}
