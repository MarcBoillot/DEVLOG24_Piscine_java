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
     * Fonction pour supprimer une piscine
     * @param id id de la piscine à supprimer
     */
    public void deletePool(final int id) {poolsRepository.deleteById(id);}

    /**
     * Fonction de mise à jour d'une piscine
     * @param pool la piscine
     * @return les nouvelles données
     */
    public Pools savePool(Pools pool) {
        return poolsRepository.save(pool);
    }
}
