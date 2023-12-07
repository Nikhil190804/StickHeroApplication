package com.example.stickherogame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StoreObject implements Serializable {
    private String unique;
    private static final long serialVersionUID = 42L;


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
    public static void saveGame(StoreObject game) {
        ObjectOutputStream output_file = null;
        try{
            output_file=new ObjectOutputStream(new FileOutputStream("saved_game.txt"));
            output_file.writeObject(game);
        }
        catch (IOException e){
            System.out.println("error");
        }
        finally {
           // output_file.close();
        }
    }
}