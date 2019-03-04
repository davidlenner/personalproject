package com.lenner.personalprojectwithapis.service;

import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.repository.JokeRepo;
import com.lenner.personalprojectwithapis.repository.PictureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    PictureRepo pictureRepo;

    @Autowired
    JokeRepo jokeRepo;

    public Picture getPicture() {
        return pictureRepo.findAll().get(0);
    }

    public List<Joke> getJoke(){
        return jokeRepo.findAll();
    }

}
