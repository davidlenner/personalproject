package com.lenner.personalprojectwithapis.init;

import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.repository.*;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DBInitializer {

    private RestTemplateBuilder builder = new RestTemplateBuilder();

    public DBInitializer(PictureRepo pictureRepo) {

        RestTemplate restTemplate = builder.build();

        ResponseEntity<Picture> pictureResponseEntity = restTemplate.getForEntity
                ("https://api.nasa.gov/planetary/apod?api_key=icf7sVa7sxW26v4j6f0rWVuFyJv6pJMyyd6QMVEk", Picture.class);
        pictureRepo.save(pictureResponseEntity.getBody());
    }
}
