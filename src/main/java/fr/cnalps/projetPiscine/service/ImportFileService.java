package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.model.Users;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import fr.cnalps.projetPiscine.repository.UsersRepository;
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
    private final CandidateRepository candidateRepository;

    @Autowired
    private final UsersRepository usersRepository;

    public ImportFileService(CandidateRepository candidateRepository, UsersRepository usersRepository) {
        this.candidateRepository = candidateRepository;
        this.usersRepository = usersRepository;
    }

    public Iterable<Candidate> importCandidateFromExcel(MultipartFile file) throws IOException {
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
                candidate.setEmail(currentRow.getCell(2).getStringCellValue().replaceAll("," , "."));

                candidates.add(candidate);
            }
        }

        return candidateRepository.saveAll(candidates);
    }

    public Iterable<Candidate> importCandidateFromCsv(MultipartFile file) throws IOException {
        List<Candidate> candidates = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Candidate candidate = new Candidate();
                candidate.setFirstname(values[0]);
                candidate.setLastname(values[1]);
                candidate.setEmail(values[2].replaceAll("," , "."));

                candidates.add(candidate);
            }
        }

        return candidateRepository.saveAll(candidates);
    }

    public Iterable<Users> importObserverFromExcel(MultipartFile file) throws IOException {
        List<Users> usersList = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Users users = new Users();

                users.setFirstName(currentRow.getCell(0).getStringCellValue());
                users.setName(currentRow.getCell(1).getStringCellValue());
                users.setEmail(currentRow.getCell(2).getStringCellValue().replaceAll("," , "."));
                users.setSociety(currentRow.getCell(3).getStringCellValue());
                users.setStatus(Users.Status.valueOf(currentRow.getCell(4).getStringCellValue().toLowerCase()));

                usersList.add(users);
            }
        }

        return usersRepository.saveAll(usersList);
    }

    public Iterable<Users> importObserverFromCsv(MultipartFile file) throws IOException {
        List<Users> usersList = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Users users = new Users();
                users.setFirstName(values[0]);
                users.setName(values[1]);
                users.setEmail(values[2].replaceAll("," , "."));
                users.setSociety(values[3]);
                users.setStatus(Users.Status.valueOf(values[4].toLowerCase()));

                usersList.add(users);
            }
        }

        return usersRepository.saveAll(usersList);
    }
}
