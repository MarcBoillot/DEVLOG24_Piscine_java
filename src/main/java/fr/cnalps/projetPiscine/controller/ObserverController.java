package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Observer;
import fr.cnalps.projetPiscine.service.ObserverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/piscine")
public class ObserverController {
    @Autowired
    private final ObserverService service;
    public ObserverController(ObserverService service){
        this.service = service;
    }

    @GetMapping("/observer")
    public List<Observer> getAllObserver(){
        List<Observer> observerList = this.service.getAllObserver();
        return observerList ;
    }

    @GetMapping("/observer/{id}")
    public Observer getObserverById (@PathVariable(name = "id") int id) {
        return this.service.getObserverById(id);
    }
}

