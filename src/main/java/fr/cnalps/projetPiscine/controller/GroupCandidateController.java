package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.GroupCandidate;
import fr.cnalps.projetPiscine.service.GroupCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/group")
public class GroupCandidateController {

    @Autowired
    private final GroupCandidateService service;

    public GroupCandidateController(GroupCandidateService service) {
        this.service = service;
    }

    @PostMapping
    public GroupCandidate createCriteria(@RequestBody GroupCandidate groupCandidate) {
        return service.createGroupCandidate(groupCandidate);
    }
}
