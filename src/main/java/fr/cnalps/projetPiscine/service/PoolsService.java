package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Pools;
import fr.cnalps.projetPiscine.repository.PoolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class PoolsService {

    @Autowired
    private PoolsRepository poolsRepository;

    public Optional<Pools> getPiscinesById(final int id) {return poolsRepository.findById(id);}

    public Iterable<Pools> getPiscines() {return poolsRepository.findAll();}

    public void deletePiscine(final int id) {poolsRepository.deleteById(id);}

    public Pools savePool(Pools pool) {
        return poolsRepository.save(pool);
    }
}
