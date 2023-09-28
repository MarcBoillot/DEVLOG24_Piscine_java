package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import fr.cnalps.projetPiscine.repository.PoolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * Fonction de création d'une piscine
     *
     * @param pool la piscine
     * @return les nouvelles données
     */
    public Pools createPool(Pools pool) {
        return poolsRepository.save(pool);
    }

    /**
     * Fonction afficher les piscines selon leur id
     *
     * @param id id de la piscine
     * @return la piscine avec l'id dorrecpondant
     */
    public Optional<Pools> getPoolsById(final int id) {
        return poolsRepository.findById(id);
    }

    /**
     * Fonction qui affiche toutes les piscines
     *
     * @return toutes les piscines
     */
    public Iterable<Pools> getPools() {
        return poolsRepository.findAll();
    }

    /**
     * Fonction de suppression de piscine
     *
     * @param pools piscines
     */
    public void deletePool(int pools) {
        poolsRepository.deleteById(pools);
    }

    /**
     * Fonction pour mettre à jour les données d'une piscine
     *
     * @param pool la piscine
     */
    public void updatePool(Pools pool) {
        poolsRepository.save(pool);
    }

    public void addCandidateToPool(int poolId, int candidateId) {

        Optional<Pools> poolOptional = poolsRepository.findById(poolId);
        Optional<Candidate> candidateOptional = candidateRepository.findById(candidateId);

        if (poolOptional.isPresent() && candidateOptional.isPresent()) {
            Pools pool = poolOptional.get();
            Candidate candidate = candidateOptional.get();

            List<Pools> candidateInPools = candidate.getCandidateInPools();
            candidateInPools.add(pool);
            candidate.setCandidateInPools(candidateInPools);

            candidateRepository.save(candidate);
        }
    }
    public void deleteCandidateFromPool(int poolId, int candidateId) {

        Optional<Pools> pool = poolsRepository.findById(poolId);
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);

        if (pool.isPresent() && candidate.isPresent()) {
            pool.get().getPoolsHasCandidates().remove(candidate.get());
            poolsRepository.save(pool.get());
        }
    }

}
