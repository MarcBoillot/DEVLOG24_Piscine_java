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

    public GroupCandidate createGroupCandidate (GroupCandidate groupCandidate){
        return groupCandidateRepository.save(groupCandidate);
    }

    public List<GroupCandidate> getAllGroupCandidate() {
        return (List<GroupCandidate>) groupCandidateRepository.findAll();
    }

    public GroupCandidate getGroupCandidateById(int id) {
        return groupCandidateRepository.findById(id).orElse(null);
    }

    public GroupCandidate updateGroupCandidate(int id, GroupCandidate groupCandidate) {
        if (groupCandidateRepository.existsById(id)) {
            groupCandidate.setId(id);
            return groupCandidateRepository.save(groupCandidate);
        }
        return null;
    }
}
