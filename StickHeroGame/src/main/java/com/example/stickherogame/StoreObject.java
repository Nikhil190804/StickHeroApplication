package com.example.stickherogame;

import java.io.Serializable;

public class StoreObject implements Serializable {
    private String unique;

    public StoreObject(String unique, int score, int highScore, int cherryCounter) {
        this.unique = unique;
        Score = score;
        HighScore = highScore;
        this.cherryCounter = cherryCounter;
    }

    private int Score;
    private int HighScore;
    private int cherryCounter;

    public static StoreObject loadGame(String name){
        return null;
    }
    public static void saveGame(StoreObject game){}
}