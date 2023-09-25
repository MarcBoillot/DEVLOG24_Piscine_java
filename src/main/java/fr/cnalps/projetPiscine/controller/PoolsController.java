package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.service.PoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("piscine")
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
    @PutMapping("{id}")
    public Pools updatePools(@PathVariable("id") final int id, @RequestBody Pools pools){
        Optional<Pools> pool = poolsService.getPoolsById(id);
        if (pool.isPresent()){
            Pools currentPool = pool.get();
            String name = pools.getName();
            if (name != null) {
                currentPool.setName(name);
            }
            String town = pools.getTown();
            if (town != null){
                currentPool.setTown(town);
            }
            Date date = pools.getDate();
            if (date != null){
                currentPool.setDate(date);
            }
            return currentPool;
        }
        else {
            return null;
        }
    }

    @DeleteMapping
    public void deletePool(@PathVariable("id") final int id) {poolsService.deletePool(id);}
}
