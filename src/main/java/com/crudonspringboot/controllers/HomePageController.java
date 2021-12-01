package com.crudonspringboot.controllers;

import com.crudonspringboot.service.Service.RoleService;
import com.crudonspringboot.service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/admin")
    public String index(Model model, Principal principal){
        model.addAttribute("currentUser", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("AllRoles", roleService.getAllRoles());
        return "admin/index";
    }

    @GetMapping("/user")
    public String getUserPage(Principal principal, Model model) {
        model.addAttribute("currentUser",userService.loadUserByUsername(principal.getName()));
        return "/user/userPage";
    }

    @GetMapping("/stories")
    public String getStories(){
        return "homepage/stories";
    }

    @GetMapping("/educationalMaterial")
    public String getMaterial(){
        return "homepage/educationalMaterial";
    }

    @GetMapping("/interviews")
    public String getInterviews(){
        return "homepage/interviews";
    }

    @GetMapping("/nauchpop")
    public String getNauchpop(){
        return "homepage/nauchpop";
    }

    @GetMapping("/blog")
    public String getBlog(){
        return "homepage/blog";
    }

    @GetMapping()
    public String getHomePage(Model model){
        model.addAttribute("AllRoles", roleService.getAllRoles());
        return "homepage/main";
    }
}