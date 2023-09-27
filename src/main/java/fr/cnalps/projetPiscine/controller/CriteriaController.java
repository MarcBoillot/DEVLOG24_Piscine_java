package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Criteria;
import fr.cnalps.projetPiscine.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/criteria")
public class CriteriaController {

    @Autowired
    private final CriteriaService service;

    public CriteriaController(CriteriaService service) {
        this.service = service;
    }

    @PostMapping
    public Criteria createCriteria(@RequestBody Criteria criteria) {
        return service.createCriteria(criteria);
    }

    @GetMapping
    public List<Criteria> getAllCriteria(){
        return this.service.getAllCriteria();
    }

    @GetMapping("/{id}")
    public Criteria getCriteriaById (@PathVariable(name = "id") int id) {
        return this.service.getCriteriaById(id);
    }
}
