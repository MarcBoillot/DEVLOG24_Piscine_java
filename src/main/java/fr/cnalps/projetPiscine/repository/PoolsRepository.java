package fr.cnalps.projetPiscine.repository;

import fr.cnalps.projetPiscine.model.Pools;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Crud pour les fonctions relatives à la gestion de piscines
 */
@Repository
public interface PoolsRepository extends CrudRepository<Pools, Integer> {

}
