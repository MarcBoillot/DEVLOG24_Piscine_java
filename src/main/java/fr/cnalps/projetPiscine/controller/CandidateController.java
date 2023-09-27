package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public @ResponseBody Iterable<Candidate> getAllCandidates(){
        return candidateService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Candidate> getCandidateById(@PathVariable(value ="id") int id){
        return candidateService.findById(id);
    }

    @PostMapping
    public @ResponseBody Candidate createCandidate(@RequestBody Candidate candidate){
        return candidateService.save(candidate);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String removeCandidate(@PathVariable(value = "id") int id) {
        candidateService.delete(id);
        return "Successfully deleted";
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody String modifyCandidate(@RequestBody Candidate candidate){
        candidateService.update(candidate);
        return "successfully modify";
    }
}
