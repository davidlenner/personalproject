package com.lenner.personalprojectwithapis.init;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.repository.*;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

@Component
public class DBInitializer {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public DBInitializer(PictureRepo pictureRepo){

        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        ResponseEntity<Picture> pictureResponseEntity = restTemplate.getForEntity
                ("https://api.nasa.gov/planetary/apod?api_key=icf7sVa7sxW26v4j6f0rWVuFyJv6pJMyyd6QMVEk", Picture.class);
        pictureRepo.save(pictureResponseEntity.getBody());

    }

    private static JsonNode MapData(String url) throws IOException {
        URL url1 = new URL(url);
        return objectMapper.readTree(url1);
    }


    public JsonNode getJoke() throws IOException {
        return MapData("https://official-joke-api.appspot.com/random_joke\n");
    }
}
