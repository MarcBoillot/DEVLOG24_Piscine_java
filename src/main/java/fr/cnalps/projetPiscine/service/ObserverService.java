package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Observer;
import fr.cnalps.projetPiscine.repository.ObserverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObserverService {
    @Autowired
    private final ObserverRepository observerRepository;

    public ObserverService(ObserverRepository observerRepository) {
        this.observerRepository = observerRepository;
    }

    public Observer createObserver(Observer observer) {
        return observerRepository.save(observer);
    }

    public Observer getObserverById(int id) {
        return observerRepository.findById(id).orElse(null);
    }

    public List<Observer> getAllObserver() {
        return (List<Observer>) observerRepository.findAll();
    }

    public Observer updateObserver(int id, Observer observer) {
        if (observerRepository.existsById(id)) {
            observer.setId(id);
            return observerRepository.save(observer);
        }
        return null;
    }

    public void deleteObserver(int id) {
        observerRepository.deleteById(id);
    }
}
