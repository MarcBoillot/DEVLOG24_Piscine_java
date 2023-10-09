package fr.cnalps.projetPiscine.service;
//
//import fr.cnalps.projetPiscine.model.Images;
//import fr.cnalps.projetPiscine.repository.ImagesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import java.util.List;
//
@Service
public class ImagesService {
//    private final ImagesRepository imagesRepository;
//
//    @Autowired
//    public ImagesService(ImagesRepository imagesRepository) {
//        this.imagesRepository = imagesRepository;
//    }
//
//    public Images createImages(Images images) {
//        return imagesRepository.save(images);
//    }
//
//    public List<Images> getAllImages() {
//        return (List<Images>) imagesRepository.findAll();
//    }
//
//    public Images getImagesById(int id) {
//        return imagesRepository.findById(id).orElse(null);
//    }
//
//    public Images updateImages(int id, Images criteria) {
//        if (imagesRepository.existsById(id)) {
//            criteria.setId(id);
//            return imagesRepository.save(criteria);
//        }
//        return null;
//    }
//
//    public void deleteImages(int id) {
//        if (imagesRepository.existsById(id)) {
//            imagesRepository.deleteById(id);
//        }
//    }
}
