package com.notin.senglish.model;

public class Score {
    private int score;
    private int ratings;

    public Score(int score, int ratings) {
        this.score = score;
        this.ratings = ratings;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
