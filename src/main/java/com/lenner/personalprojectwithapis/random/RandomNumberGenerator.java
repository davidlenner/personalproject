package com.lenner.personalprojectwithapis.random;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator {

    public int generateRandNum(int number){
        Random random = new Random();
        return random.nextInt(number);
    }
}
