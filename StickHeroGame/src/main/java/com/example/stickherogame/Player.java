package com.example.stickherogame;

import javafx.scene.image.ImageView;

public class Player extends ImageView implements Movable {
    private int Score;
    private int CherryCounter;
    private final double Height;
    private final double Width;
    private Stick myStick;
    private double x;
    private double y;

    public Player(int score,int cherryCounter,double height, double width,Stick stick,double x,double y){
        this.Score=score;
        this.CherryCounter=cherryCounter;
        this.Height=height;
        this.Width=width;
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

    public double getHeight() {
        return Height;
    }

    public double getWidth() {
        return Width;
    }

    public Stick getMyStick() {
        return myStick;
    }

    public void setMyStick(Stick myStick) {
        this.myStick = myStick;
    }

}
