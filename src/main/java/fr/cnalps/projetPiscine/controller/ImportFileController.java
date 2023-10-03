package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.service.ImportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/candidate")
public class ImportFileController {

    @Autowired
    private final ImportFileService service;

    public ImportFileController(ImportFileService service) {
        this.service = service;
    }

    @PostMapping("/import")
    public ResponseEntity<?> importFile(@RequestBody MultipartFile file) {
        Iterable<Candidate> candidates;

        try {
            String contentType = file.getContentType();

            if ("application/vnd.ms-excel".equals(contentType) ||
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(contentType)) {
                candidates = service.importFromExcel(file);
            } else if ("text/csv".equals(contentType)) {
                candidates = service.importFromCsv(file);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type de fichier non supporté");
            }

            return ResponseEntity.ok(candidates);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'importation: " + e.getMessage());
        }
    }
}
