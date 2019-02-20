package com.lenner.personalprojectwithapis.controller;

import com.lenner.personalprojectwithapis.service.PersonalProjectService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProjectController {

    @Autowired
    PersonalProjectService personalProjectService;

    @GetMapping("/pic")
    public String index() throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("url",personalProjectService.getPicture().getUrl());
        obj.put("title",personalProjectService.getPicture().getTitle());
        return obj.toString();
    }

}

