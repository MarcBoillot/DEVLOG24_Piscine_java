package fr.cnalps.projetPiscine.repository;

import fr.cnalps.projetPiscine.model.Pools;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolsRepository extends CrudRepository<Pools, Integer> {

}
