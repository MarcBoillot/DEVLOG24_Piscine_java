package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Category;
import fr.cnalps.projetPiscine.model.Observer;
import fr.cnalps.projetPiscine.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/category")
public class CategoryController {
    @Autowired
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category createcategory(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllObserver(){
        return this.service.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getObserverById (@PathVariable(name = "id") int id) {
        return this.service.getCategoryById(id);
    }
}
