package com.crudonspringboot.controllers;

import com.crudonspringboot.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomepageController {
    @Autowired
    RoleService roleService;

    @GetMapping()
    public String getHomePage(Model model){
        model.addAttribute("AllRoles", roleService.getAllRoles());
        return "/main";
    }
}
