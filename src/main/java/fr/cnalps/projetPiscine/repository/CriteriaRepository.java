package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.Criteria;
import org.springframework.stereotype.Repository;

/**
 * CRUD criterias interface
 */
@Repository
public interface CriteriaRepository extends CrudRepository<Criteria, Integer>{
}
