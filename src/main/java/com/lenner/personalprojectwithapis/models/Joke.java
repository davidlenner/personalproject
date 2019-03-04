package com.lenner.personalprojectwithapis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Joke {

    @Id
    @GeneratedValue
    private Long dbId;
    private Integer id;
    private String type;
    private String setup;
    private String punchline;

    public Joke() {
    }

    public Joke(Integer id, String type, String setup, String punchline) {
        this.id = id;
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }
}
