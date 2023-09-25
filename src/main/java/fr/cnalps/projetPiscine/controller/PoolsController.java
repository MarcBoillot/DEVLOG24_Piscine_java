package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.service.PoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * Controller de piscines
 */
@RestController
@RequestMapping("piscine")
public class PoolsController {
    /**
     * Instanciation du service
     */
    @Autowired
    private PoolsService poolsService;

    /**
     * Fonction de création d'une nouvelle piscine
     * @param pool la piscine
     * @return la nouvelle piscine
     */
    @PostMapping
    public Pools createPool(@RequestBody Pools pool){
        return poolsService.savePool(pool);
    }

    /**
     * Fonction pour afficher les piscines
     * @return La liste des piscines
     */
    @GetMapping
    public Iterable<Pools>getPools(){
        return poolsService.getPools();
    }

    /**
     * Fonction pour mettre à jour les données des piscines
     * @param id l'id de la piscine
     * @param pools les piscines
     * @return les nouvelles données si existantes sinon rien
     */
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

    /**
     * Fonction qui permet de supprimer une piscine
     * @param id l'id de la piscine
     */
    @DeleteMapping
    public void deletePool(@PathVariable("id") final int id) {poolsService.deletePool(id);}
}
