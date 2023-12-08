package com.example.stickherogame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StoreObject implements Serializable {
    private String unique;
   // private static final long serialVersionUID = 42L;


    public StoreObject(String unique, int score, int highScore, int cherryCounter) {
        this.unique = unique;
        Score = score;
        HighScore = highScore;
        this.cherryCounter = cherryCounter;
    }

    private int Score;
    private int HighScore;
    private int cherryCounter;

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    public int getCherryCounter() {
        return cherryCounter;
    }

    public void setCherryCounter(int cherryCounter) {
        this.cherryCounter = cherryCounter;
    }

    public static StoreObject loadGame(String name){
return null;

    }
    public static void saveGame(StoreObject game) {
        ObjectOutputStream output_file = null;
        try{
            output_file=new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/stickherogame/Stored_Game.bin",true));
            output_file.writeObject(game);
        }
        catch (IOException e){
            System.out.println("error");
        }
        finally {
            try {
                output_file.close();
            } catch (IOException e) {
                System.out.println("error");
            }
        }
    }
    public static void highScoreGame(StoreObject game) {
        ObjectOutputStream output_file = null;
        try{
            output_file=new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/stickherogame/HighScore_Game.bin"));
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