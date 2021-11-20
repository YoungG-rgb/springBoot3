package com.crudonspringboot.service.ServiceImpl;

import com.crudonspringboot.models.Publication;
import com.crudonspringboot.models.User;
import com.crudonspringboot.repository.PublicationRepository;
import com.crudonspringboot.service.Service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Publication add(Publication publication){
        return publicationRepository.save(publication);
    }

    @Override
    public void delete(Long id){
        publicationRepository.deleteById(id);
    }

    @Override
    public Publication update(Publication publication){
        return publicationRepository.save(publication);
    }

    public Publication findById(Long id){
        Publication publication = null;
        Optional<Publication> optional = publicationRepository.findById(id);
        if (optional.isPresent()){
            publication = optional.get();
        }
        return publication;
    }

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

}