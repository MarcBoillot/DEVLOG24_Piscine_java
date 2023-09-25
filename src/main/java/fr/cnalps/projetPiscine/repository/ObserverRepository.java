package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.Observer;
import org.springframework.stereotype.Repository;

@Repository
public interface ObserverRepository extends CrudRepository<Observer, Integer>{
}
