package com.example.stickherogame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView implements Movable {
    private int Score;
    private int CherryCounter;
    private Stick myStick;
    private double x;
    private double y;

    public Player(int score,int cherryCounter,double height, double width,Stick stick,double x,double y,Image playerImage){
        super(playerImage);
        this.Score=score;
        this.CherryCounter=cherryCounter;
        this.setFitWidth(width);
        this.setFitHeight(height);
        this.setLayoutY(208);
        this.myStick=stick;
        this.x=x;
        this.y=y;
    }
    @Override
    public double move(double distance) {
        return 0;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getCherryCounter() {
        return CherryCounter;
    }

    public void setCherryCounter(int cherryCounter) {
        CherryCounter = cherryCounter;
    }

    public Stick getMyStick() {
        return myStick;
    }

    public void setMyStick(Stick myStick) {
        this.myStick = myStick;
    }


    public double getX_coordinate() {
        return x;
    }


    public double getY_coordinate() {
        return y;
    }

    public void incrementScore(int i) {
        this.setScore(this.getScore()+i);

    }
}