package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.service.PoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pools")
public class PoolsController {
    @Autowired
    private PoolsService poolsService;

    @PostMapping
    public Pools createPool(@RequestBody Pools pool){
        return poolsService.savePool(pool);
    }
    @GetMapping
    public Iterable<Pools>getPools(){
        return poolsService.getPools();
    }

}
