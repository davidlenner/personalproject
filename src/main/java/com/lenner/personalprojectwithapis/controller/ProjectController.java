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

@CrossOrigin
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    RandomNumberGenerator randomNumberGenerator;

    @GetMapping("/pic")
    public String index() throws JSONException {
        Picture picture = projectService.getPicture();

        JSONObject obj = new JSONObject();
        obj.put("type",projectService.checkUrl(picture));
        if (projectService.checkUrl(picture)){
            obj.put("picture", picture.getUrl().substring(30));
        }else {
        obj.put("picture", picture.getUrl());}
        obj.put("title", picture.getTitle());
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

