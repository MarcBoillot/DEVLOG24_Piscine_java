package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.model.Users;
import fr.cnalps.projetPiscine.service.ImportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/import")
public class ImportFileController {

    @Autowired
    private final ImportFileService service;

    public ImportFileController(ImportFileService service) {
        this.service = service;
    }

    @PostMapping("/candidate")
    public ResponseEntity<?> importCandidateFromFile(@RequestBody MultipartFile file) {
        Iterable<Candidate> candidates;

        try {
            String contentType = file.getContentType();

            if ("application/vnd.ms-excel".equals(contentType) ||
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(contentType)) {
                candidates = service.importCandidateFromExcel(file);
            } else if ("text/csv".equals(contentType)) {
                candidates = service.importCandidateFromCsv(file);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type de fichier non supporté");
            }

            return ResponseEntity.ok(candidates);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'importation: " + e.getMessage());
        }
    }

    @PostMapping("/observer")
    public ResponseEntity<?> importObserverFromFile(@RequestBody MultipartFile file) {
        Iterable<Users> usersIterable;

        try {
            String contentType = file.getContentType();

            if ("application/vnd.ms-excel".equals(contentType) ||
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(contentType)) {
                usersIterable = service.importObserverFromExcel(file);
            } else if ("text/csv".equals(contentType)) {
                usersIterable = service.importObserverFromCsv(file);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type de fichier non supporté");
            }

            return ResponseEntity.ok(usersIterable);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'importation: " + e.getMessage());
        }
    }
}
