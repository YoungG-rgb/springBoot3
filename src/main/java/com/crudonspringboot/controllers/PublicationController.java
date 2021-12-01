package com.crudonspringboot.controllers;

import com.crudonspringboot.service.Service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class PublicationController {

    private final PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("posts/{id}")
    public String getPost(@PathVariable("id") Long id, Model model){
        String text = new String(publicationService.findById(id).getPublicationText());
        model.addAttribute("post", publicationService.findById(id));
        model.addAttribute("text", text);
        return "homepage/post";
    }

}
