package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.repository.PoolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Scanner;

/**
 * Classe service de piscines
 */
@Service
public class PoolsService {
    /**
     * Instanciation du repository
     */
    @Autowired
    private PoolsRepository poolsRepository;

    /**
     * Fonction de création d'une piscine
     * @param pool la piscine
     * @return les nouvelles données
     */
    public Pools createPool(Pools pool) {
        return poolsRepository.save(pool);
    }

    /**
     * Fonction afficher les piscines selon leur id
     * @param id id de la piscine
     * @return la piscine avec l'id dorrecpondant
     */
    public Optional<Pools> getPoolsById(final int id) {return poolsRepository.findById(id);}

    /**
     * Fonction qui affiche toutes les piscines
     * @return toutes les piscines
     */
    public Iterable<Pools> getPools() {return poolsRepository.findAll();}

    /**
     * Fonction de suppression de piscine
     * @param pools piscines
     */
    public void deletePool(Pools pools) {poolsRepository.delete(pools);}

    /**
     * Fonction pour mettre à jour les données d'une piscine
     * @param pool la piscine
     */
    public void updatePool(Pools pool){
        poolsRepository.save(pool);
    }
}
