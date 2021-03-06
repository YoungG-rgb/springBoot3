package com.crudonspringboot.controllers.restControllers;

import com.crudonspringboot.models.Publication;
import com.crudonspringboot.service.Service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PublicationRestController {

    private final PublicationService publicationService;

    @GetMapping("/allPublications")
    public ResponseEntity<List<Publication>> getPublication(){
        List <Publication> publicationList = publicationService.getAllPublications();
        return new ResponseEntity<>(publicationList, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Publication> getPublication(@PathVariable("id") Long id){
        Publication publication = publicationService.findById(id);
        return new ResponseEntity<>(publication, HttpStatus.OK);
    }
}
