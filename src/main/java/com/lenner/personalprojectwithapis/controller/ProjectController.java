package com.lenner.personalprojectwithapis.controller;

import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.models.SpaceXData;
import com.lenner.personalprojectwithapis.random.RandomNumberGenerator;
import com.lenner.personalprojectwithapis.service.ProjectService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@CrossOrigin
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    RandomNumberGenerator randomNumberGenerator;



    @GetMapping("/pictitle")
    public String index() throws JSONException {
        Picture picture = projectService.getPicture();
        JSONObject obj = new JSONObject();
        obj.put("type",projectService.checkUrl(picture));
        obj.put("title", picture.getTitle());
        return obj.toString();
    }
    @GetMapping("/pic")
    public String pictureUrl() throws JSONException {
        Picture picture = projectService.getPicture();
        JSONObject pictureurl = new JSONObject();
        pictureurl.put("url", picture.getUrl());
        return pictureurl.toString();
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
    public String spaceX() throws JSONException {
        SpaceXData spaceXData = projectService.getSpaceX();
        JSONObject spaceXJson = new JSONObject();
        spaceXJson.put("mission_name",spaceXData.getMissionName());
        spaceXJson.put("details",spaceXData.getDetails());
        spaceXJson.put("launch_date_local",spaceXData.getLaunchDateLocal());
        spaceXJson.put("payload_type",spaceXData.getPayloadType());
        spaceXJson.put("site_name_long",spaceXData.getSiteNameLong());
        spaceXJson.put("rocket_name",spaceXData.getRocketName());
        return spaceXJson.toString();
    }

}

