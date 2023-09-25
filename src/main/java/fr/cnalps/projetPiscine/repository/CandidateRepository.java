package fr.cnalps.projetPiscine.repository;

import fr.cnalps.projetPiscine.model.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
}
