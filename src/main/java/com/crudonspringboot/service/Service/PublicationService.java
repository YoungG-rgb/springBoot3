package com.crudonspringboot.service.Service;

import com.crudonspringboot.models.Publication;

import java.util.List;

public interface PublicationService {
    Publication add(Publication publication);
    void delete(Long id);
    Publication update(Publication publication);
    public Publication findById(Long id);
    public List<Publication> getAllPublications();
}
