package com.lenner.personalprojectwithapis.init;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.repository.*;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBInitializer {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private List<Joke> jokes = new ArrayList<>();

    public DBInitializer(PictureRepo pictureRepo,JokeRepo jokeRepo) throws IOException {

        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        ResponseEntity<Picture> pictureResponseEntity = restTemplate.getForEntity
                ("https://api.nasa.gov/planetary/apod?api_key=icf7sVa7sxW26v4j6f0rWVuFyJv6pJMyyd6QMVEk", Picture.class);
        pictureRepo.save(pictureResponseEntity.getBody());

        getJokefromApi();
        for (Joke joke: jokes) {
            jokeRepo.save(joke);
        }

        getSpaceXData();
    }

    private static JsonNode MapData(String stringUrl) throws IOException {
        URL url = new URL(stringUrl);
        return objectMapper.readTree(url);
    }

    private void getJokefromApi() throws IOException {
        JsonNode jokenodes = MapData("https://official-joke-api.appspot.com/random_ten");
        for (JsonNode jokenode: jokenodes) {
            jokes.add(new Joke(jokenode.get("id").intValue(),jokenode.get("type").toString(),
            jokenode.get("setup").toString(),jokenode.get("punchline").toString()));
        }
    }

    private void getSpaceXData() throws IOException {
        JsonNode spaceX = MapData("https://api.spacexdata.com/v3/launches/latest");
        JsonNode rocket = spaceX.path("rocket");
        JsonNode secondStage = rocket.path("second_stage");
        JsonNode payloads = secondStage.path("payloads");
        for (JsonNode jsonNode:payloads) {

            System.out.println(jsonNode.get("nationality"));
        }
    }
}
