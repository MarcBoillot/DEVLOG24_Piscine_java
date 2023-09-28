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
    public GroupCandidate createGroupCandidate(@RequestBody GroupCandidate groupCandidate) {
        return service.createGroupCandidate(groupCandidate);
    }

    @GetMapping
    public List<GroupCandidate> getAllGroupCandidate(){
        return this.service.getAllGroupCandidate();
    }

    @GetMapping("/{id}")
    public GroupCandidate getGroupCandidateById (@PathVariable(name = "id") int id) {
        return this.service.getGroupCandidateById(id);
    }
}
