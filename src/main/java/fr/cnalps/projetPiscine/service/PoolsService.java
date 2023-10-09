package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.model.Category;
import fr.cnalps.projetPiscine.model.Criteria;
import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import fr.cnalps.projetPiscine.repository.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

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

    /**
     * Add a candidate to a pool service function
     * @param poolId pool target id
     * @param candidateId candidate target id
     */
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

    /**
     * Delete a candidate from a pool service function
     * @param poolId pool target id
     * @param candidateId candidate target id
     */
    public void deleteCandidateFromPool(int poolId, int candidateId) {

        Optional<Pools> pool = poolsRepository.findById(poolId);
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);

        if (pool.isPresent() && candidate.isPresent()) {
            pool.get().getPoolsHasCandidates().remove(candidate.get());
            poolsRepository.save(pool.get());
        }
    }

    /**
     * Add a category to a pool service function
     * @param poolId pool target id
     * @param categoryId category target id
     */
    public void addCategoryToPool (int poolId, int categoryId){
        Optional<Pools> poolsOptional = poolsRepository.findById(poolId);
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (poolsOptional.isPresent() && categoryOptional.isPresent()){
            Pools pool = poolsOptional.get();
            Category category = categoryOptional.get();
            List<Pools> categoryInPools = category.getPoolsHasCategories();
            categoryInPools.add(pool);
            category.setPoolsHasCategories(categoryInPools);
            categoryRepository.save(category);
        }
    }

    /**
     * Delete a category from a pool service function
     * @param poolId pool target id
     * @param categoryId category target id
     */
    public void deleteCategoryFromPool(int poolId, int categoryId) {

        Optional<Pools> pool = poolsRepository.findById(poolId);
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (pool.isPresent() && category.isPresent()) {
            pool.get().getPoolsHasCategories().remove(category.get());
            poolsRepository.save(pool.get());
        }
    }

}
