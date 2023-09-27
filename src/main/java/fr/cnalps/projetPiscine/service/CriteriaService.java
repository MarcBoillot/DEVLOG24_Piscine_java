package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Criteria;
import fr.cnalps.projetPiscine.repository.CriteriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;

    @Autowired
    public CriteriaService(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public Criteria createCriteria (Criteria criteria){
        return criteriaRepository.save(criteria);
    }

    public List<Criteria> getAllCriteria() {
        return (List<Criteria>) criteriaRepository.findAll();
    }

    public Criteria getCriteriaById(int id) {
        return criteriaRepository.findById(id).orElse(null);
    }

    public Criteria updateCriteria(int id, Criteria criteria) {
        if (criteriaRepository.existsById(id)) {
            criteria.setId(id);
            return criteriaRepository.save(criteria);
        }
        return null;
    }

    public void deleteCriteria(int id) {
        if (criteriaRepository.existsById(id)) {
            criteriaRepository.deleteById(id);
        }
    }
}
