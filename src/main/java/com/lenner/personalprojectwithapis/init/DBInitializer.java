package com.lenner.personalprojectwithapis.init;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenner.personalprojectwithapis.models.Joke;
import com.lenner.personalprojectwithapis.models.Picture;
import com.lenner.personalprojectwithapis.models.SpaceXData;
import com.lenner.personalprojectwithapis.repository.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBInitializer {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private List<Joke> jokes = new ArrayList<>();

    public DBInitializer(PictureRepo pictureRepo,JokeRepo jokeRepo,SpaceXRepo spaceXRepo) throws IOException {

        pictureRepo.save(getPic());

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
        JsonNode spaceX = MapData("https://api.spacexdata.com/v3/launches/next");
        JsonNode launchSite = spaceX.path("launch_site");
        JsonNode rocket = spaceX.path("rocket");
        JsonNode secondStage = rocket.path("second_stage");
        JsonNode payloads = secondStage.path("payloads").get(0);

        return new SpaceXData(spaceX.get("mission_name").textValue(),spaceX.get("launch_date_local").textValue(),
                payloads.get("payload_type").textValue(),
                launchSite.get("site_name_long").textValue(),spaceX.get("details").textValue(),
                rocket.get("rocket_name").textValue());

    }

    private Picture getPic() throws IOException {
        JsonNode pictureNode = MapData(
                "https://api.nasa.gov/planetary/apod?api_key=icf7sVa7sxW26v4j6f0rWVuFyJv6pJMyyd6QMVEk");
        return new Picture(pictureNode.get("date").textValue(),pictureNode.get("explanation").textValue(),
                pictureNode.get("media_type").textValue(),
                pictureNode.get("service_version").textValue(),pictureNode.get("title").textValue(),
                pictureNode.get("url").textValue());
    }

}
