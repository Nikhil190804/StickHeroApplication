package com.example.stickherogame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    public static void highScoreGame(StoreObject game) {
        ObjectOutputStream output_file = null;
        try{
            output_file=new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/stickherogame/HighScore_Game.bin"));
            output_file.writeObject(game);
        }
        catch (IOException e){
        }
        finally {
            // output_file.close();
        }


    }

    public static void sav(StoreObject game){
        List<StoreObject> savedGamesObjects = new ArrayList<>();
        ObjectInputStream inputFile = null;
        ObjectOutputStream output_file = null;
        try{
            inputFile = new ObjectInputStream(new FileInputStream("src/main/resources/com/example/stickherogame/Stored_Game.ser"));
            while (true) {
                StoreObject obj = (StoreObject) inputFile.readObject();
                savedGamesObjects.add(obj);
            }
        }
        catch (FileNotFoundException e){
            //first time access
            savedGamesObjects.add(game);
        }
        catch (IOException e) {
            savedGamesObjects.add(game);
        }
        catch (ClassNotFoundException e){}
        //now write the data
        try {
            output_file = new ObjectOutputStream(new FileOutputStream("src/main/resources/com/example/stickherogame/Stored_Game.ser"));
            for(int i=0;i<savedGamesObjects.size();i++){
                output_file.writeObject(savedGamesObjects.get(i));
            }
        } catch (IOException e) {
        } finally {
            try {
                output_file.close();
            } catch (IOException e) {
            }
        }
    }
}