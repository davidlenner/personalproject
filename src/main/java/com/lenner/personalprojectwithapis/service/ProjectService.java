package com.lenner.personalprojectwithapis.service;

import com.google.gson.JsonObject;
import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.models.SpaceXData;
import com.lenner.personalprojectwithapis.repository.JokeRepo;
import com.lenner.personalprojectwithapis.repository.PictureRepo;
import com.lenner.personalprojectwithapis.repository.SpaceXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {

    @Autowired
    PictureRepo pictureRepo;

    @Autowired
    JokeRepo jokeRepo;

    @Autowired
    SpaceXRepo spaceXRepo;

    public Picture getPicture() {
        return pictureRepo.findAll().get(0);
    }

    public Joke getJoke(int randNum){
        return jokeRepo.getOne(Long.valueOf(randNum));
    }

    public int jokesCounter(){
        return jokeRepo.findAll().size();
    }

    public SpaceXData getSpaceX() {return spaceXRepo.findAll().get(0); }

    public String checkUrl(Picture picture){
        if (picture.getUrl().contains("youtube")) {
            return "true";
        }else{
            return "false";
        }
    }

}
