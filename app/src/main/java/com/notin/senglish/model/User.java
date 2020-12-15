package com.notin.senglish.model;

import java.util.HashMap;

public class User {
    private String id;
    private String email;
    private HashMap<Integer, Score> mapScore;

    public User(String id, String email, HashMap<Integer, Score> mapScore) {
        this.id = id;
        this.email = email;
        this.mapScore = mapScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<Integer, Score> getMapScore() {
        return mapScore;
    }

    public void setMapScore(HashMap<Integer, Score> mapScore) {
        this.mapScore = mapScore;
    }
}
