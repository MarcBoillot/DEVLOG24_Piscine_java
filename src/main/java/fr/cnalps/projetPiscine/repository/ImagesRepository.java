package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fr.cnalps.projetPiscine.model.Images;

@Repository
public interface ImagesRepository extends CrudRepository<Images, Integer> {

}
