package com.lenner.personalprojectwithapis.init;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.models.SpaceXData;
import com.lenner.personalprojectwithapis.repository.*;

import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class DBInitializer {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private List<Joke> jokes = new ArrayList<>();

    public DBInitializer(PictureRepo pictureRepo,JokeRepo jokeRepo,SpaceXRepo spaceXRepo) throws IOException {

        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        ResponseEntity<Picture> pictureResponseEntity = restTemplate.getForEntity
                ("https://api.nasa.gov/planetary/apod?api_key=icf7sVa7sxW26v4j6f0rWVuFyJv6pJMyyd6QMVEk", Picture.class);
        pictureRepo.save(pictureResponseEntity.getBody());

        getJokeFromApi();
        spaceXRepo.save(getSpaceXData());
        for (Joke joke: jokes) {
            jokeRepo.save(joke);
        }



    }

    private static JsonNode MapData(String stringUrl) throws IOException {
        URL url = new URL(stringUrl);
        return objectMapper.readTree(url);
    }

    private void getJokeFromApi() throws IOException {
        JsonNode jokeNodes = MapData("https://official-joke-api.appspot.com/random_ten");
        for (JsonNode jsonNode: jokeNodes) {
            jokes.add(new Joke(jsonNode.get("id").intValue(),jsonNode.get("type").toString(),
            jsonNode.get("setup").toString(),jsonNode.get("punchline").toString()));
        }
    }

    private SpaceXData getSpaceXData() throws IOException {
        HashMap<String,String> spaceXHashMap = new HashMap<>();
        JsonNode spaceX = MapData("https://api.spacexdata.com/v3/launches/next");
        JsonNode launchSite = spaceX.path("launch_site");
        JsonNode rocket = spaceX.path("rocket");
        JsonNode secondStage = rocket.path("second_stage");
        JsonNode payloads = secondStage.path("payloads").get(0);
        /*spaceXHashMap.put("rocket_name",rocket.get("rocket_name").textValue());
        spaceXHashMap.put("site_name_long",launchSite.get("site_name_long").textValue());
        spaceXHashMap.put("mission_name",spaceX.get("mission_name").textValue());
        spaceXHashMap.put("launch_date_local",spaceX.get("launch_date_local").textValue());
        spaceXHashMap.put("details",spaceX.get("details").textValue());
        spaceXHashMap.put("payload_type",payloads.get("payload_type").textValue());
        spaceXHashMap.put("payload_mass_kg",payloads.get("payload_mass_kg").textValue());
        return new JSONObject(spaceXHashMap);*/

        return new SpaceXData(spaceX.get("mission_name").textValue(),spaceX.get("launch_date_local").textValue(),
                payloads.get("payload_type").textValue(),payloads.get("payload_mass_kg").textValue(),
                launchSite.get("site_name_long").textValue(),spaceX.get("details").textValue(),
                rocket.get("rocket_name").textValue());

    }
}
