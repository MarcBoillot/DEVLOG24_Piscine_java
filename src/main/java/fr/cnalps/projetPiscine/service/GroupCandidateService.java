package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.GroupCandidate;
import fr.cnalps.projetPiscine.repository.GroupCandidateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupCandidateService {

    private final GroupCandidateRepository groupCandidateRepository;

    /**
     * Constructor for CriteriaService.
     *
     * @param groupCandidateRepository The repository for accessing Criteria entities from the database.
     */
    @Autowired
    public GroupCandidateService(GroupCandidateRepository groupCandidateRepository) {
        this.groupCandidateRepository = groupCandidateRepository;
    }
}
