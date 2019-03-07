package com.lenner.personalprojectwithapis.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.lenner.personalprojectwithapis.init.DBInitializer;
import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.random.RandomNumberGenerator;
import com.lenner.personalprojectwithapis.service.ProjectService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    DBInitializer dbInitializer;

    @Autowired
    RandomNumberGenerator randomNumberGenerator;

    @GetMapping("/pic")
    public String index() throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("picture", projectService.getPicture().getUrl());
        obj.put("title", projectService.getPicture().getTitle());
        return obj.toString();
    }

    @GetMapping("/joke")
    public String joke() throws JSONException {
        int randomNumber = randomNumberGenerator.generateRandNum(projectService.jokesCounter());
        JSONObject jokeObject = new JSONObject();
        jokeObject.put("punchline",projectService.getJoke(randomNumber).getPunchline());
        jokeObject.put("setup",projectService.getJoke(randomNumber).getSetup());

        return jokeObject.toString();

    }

    @GetMapping("/spacex")
    public String spaceX() throws IOException {
        return dbInitializer.getSpaceXData().toString();
    }

}

