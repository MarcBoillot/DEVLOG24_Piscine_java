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
@RequestMapping("/pools")
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
        return poolsService.createPool(pool);
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
     * Fonction pour trouver les piscines par leurs id
     * @param id id de la piscine
     * @return les données de la piscine
     */
    @GetMapping("/{id}")
    public @ResponseBody Optional<Pools> getPoolsById(@PathVariable(value = "id") int id){
        return poolsService.getPoolsById(id);
    }

    /**
     * Fonction pour mettre à jour une piscine
     * @param pool la piscine
     * @return un message de confirmation
     */
    @PutMapping("/{id}")
    public @ResponseBody String updatePool(@RequestBody Pools pool){
        poolsService.updatePool(pool);
        return "Update successful";
    }

    /**
     * Fonction de suppréssion de piscines
     * @param id de la piscine
     */
    @DeleteMapping("/{id}")
    public @ResponseBody void deletePool(@PathVariable(value = "id") int id) {
        poolsService.deletePool(id);
    }

    @PostMapping("/{poolId}/candidate/{candidateId}")
    public @ResponseBody String addCandidateToPool(@PathVariable("poolId") int poolId, @PathVariable("candidateId") int candidate_id){
        poolsService.addCandidateToPool(poolId, candidate_id);
        return "Candidat ajouté à la piscine";
    }
//    @DeleteMapping("/{poolId}/candidate/{candidateId}")
//    public @ResponseBody String DeleteCandidateFromPool(@PathVariable ("poolId") int poolId, @PathVariable ("CandidateId") int candidate_id){
//        poolsService.deleteCandidateFromPool(poolId, candidate_id);
//        return "Candidat retiré de la piscine";
//    }
}
