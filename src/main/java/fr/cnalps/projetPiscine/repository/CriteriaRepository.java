package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends CrudRepository<Criteria, Integer>{
}
