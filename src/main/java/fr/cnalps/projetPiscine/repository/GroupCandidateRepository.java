package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.GroupCandidate;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCandidateRepository extends CrudRepository<GroupCandidate, Integer>{
}
