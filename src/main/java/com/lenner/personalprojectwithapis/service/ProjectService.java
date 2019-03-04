package com.lenner.personalprojectwithapis.service;

import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.repository.PictureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    PictureRepo pictureRepo;

    public Picture getPicture() {
        return pictureRepo.findAll().get(0);
    }

}
