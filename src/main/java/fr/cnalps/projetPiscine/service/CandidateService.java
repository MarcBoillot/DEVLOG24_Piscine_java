package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Iterable<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> findById(int id){
        return candidateRepository.findById(id);
    }

    public Candidate save(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public void delete(Candidate candidate){
         candidateRepository.delete(candidate);
    }

    public void update(Candidate candidate){
        candidateRepository.save(candidate);
    }
}
