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
}
