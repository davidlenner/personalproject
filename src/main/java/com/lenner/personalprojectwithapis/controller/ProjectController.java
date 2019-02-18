package com.lenner.personalprojectwithapis.controller;

import com.lenner.personalprojectwithapis.service.PersonalProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @Autowired
    PersonalProjectService personalProjectService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("url",personalProjectService.getPicture().getHdurl());
        model.addAttribute("title",personalProjectService.getPicture().getTitle());
        return "index";

    }


}
