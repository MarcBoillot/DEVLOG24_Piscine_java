package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ImportFileService {

    @Autowired
    private static CandidateRepository candidateRepository;

    public static Iterable<Candidate> importFromExcel(MultipartFile file) throws IOException {
        List<Candidate> candidates = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Candidate candidate = new Candidate();

                candidate.setFirstname(currentRow.getCell(0).getStringCellValue());
                candidate.setLastname(currentRow.getCell(1).getStringCellValue());

                candidates.add(candidate);
            }
        }

        return candidateRepository.saveAll(candidates);
    }

    public static Iterable<Candidate> importFromCsv(MultipartFile file) throws IOException {
        List<Candidate> candidates = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Candidate candidate = new Candidate();
                candidate.setFirstname(values[0]);
                candidate.setLastname(values[1]);

                candidates.add(candidate);
            }
        }

        return candidateRepository.saveAll(candidates);
    }
}
