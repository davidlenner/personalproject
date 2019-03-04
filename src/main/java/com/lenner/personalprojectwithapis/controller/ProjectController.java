package com.lenner.personalprojectwithapis.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.lenner.personalprojectwithapis.init.DBInitializer;
import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.service.ProjectService;
import org.json.JSONArray;
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
    ProjectService projectService;

    @Autowired
    DBInitializer dbInitializer;

    @GetMapping("/pic")
    public String index() throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("picture", projectService.getPicture().getUrl());
        obj.put("title", projectService.getPicture().getTitle());
        return obj.toString();
    }

    @GetMapping("/joke")
    public String joke() throws JSONException {
        JSONArray jokes = new JSONArray();
        for (Joke joke: projectService.getJoke()) {
            JSONObject jokeObject = new JSONObject();
            jokeObject.put("punchline",joke.getPunchline());
            jokeObject.put("setup",joke.getSetup());
            jokes.put(jokeObject);
        }
        return jokes.toString();
    }

}

