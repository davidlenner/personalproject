package com.lenner.personalprojectwithapis.repository;

import com.lenner.personalprojectwithapis.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepo extends JpaRepository<Joke,Long> {
}
