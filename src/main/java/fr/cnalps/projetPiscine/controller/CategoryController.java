package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Category;
import fr.cnalps.projetPiscine.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CategoryController manages the web requests related to Category entities.
 * Provides endpoints for retrieving all Category's and getting a specific Category by ID.
 */
@RestController
@RequestMapping(path="/category")
public class CategoryController {
    @Autowired
    private final CategoryService service;

    /**
     * Constructor for CategoryController.
     *
     * @param service The CategoryService to handle business logic related to Category entities.
     */
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    /**
     * Creates a new Category object.
     *
     * @param category The Category object to be created.
     * @return The created Category object.
     */
    @PostMapping
    public Category createcategory(@RequestBody Category category) {
        return service.createCategory(category);
    }

    /**
     * Retrieves all Category object from the database.
     *
     * @return List of all Category object.
     */
    @GetMapping
    public List<Category> getAllObserver(){
        return this.service.getAllCategory();
    }

    /**
     * Retrieves a specific Category by its ID.
     *
     * @param id The ID of the Category object.
     * @return The Category entity matching the provided ID.
     */
    @GetMapping("/{id}")
    public Category getObserverById (@PathVariable(name = "id") int id) {
        return this.service.getCategoryById(id);
    }

    /**
     * Updates a specific Category object by its ID.
     *
     * @param id The ID of the Category object.
     * @param category The updated Category object.
     * @return The updated Category object.
     */
    @PutMapping("/{id}")
    public Category updateObserver(@PathVariable int id, @RequestBody Category category) {
        return service.updateCategory(id, category);
    }

    /**
     * Deletes a specific Category object by its ID.
     *
     * @param id The ID of the Category object.
     */
    @DeleteMapping("/{id}")
    public void deleteObserver(@PathVariable int id) {
        service.deleteObserver(id);
    }
}
