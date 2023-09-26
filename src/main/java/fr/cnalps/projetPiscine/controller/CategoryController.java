package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Category;
import fr.cnalps.projetPiscine.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
