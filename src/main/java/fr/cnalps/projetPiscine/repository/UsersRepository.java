package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{
}
