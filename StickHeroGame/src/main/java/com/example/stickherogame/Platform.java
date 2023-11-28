package com.example.stickherogame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class Platform extends Rectangle implements RandomObjectGenerator{
    private final double Height=150;
    private final Color color = Color.BLACK;


    public double getHeightOfPlatform() {
        return Height;
    }


    public double getWidthOfPlatform() {
        return width;
    }

    private double width;
    private double startingX;
    private double endingX;
    private double centreX;


    private static final double MIN_WIDTH = 50;
    private static final double MAX_WIDTH = 200;
    private static final double MIN_STARTING_X = 124 + 4;
    private static final double MAX_STARTING_X = 404;
    private static final double MIN_ENDING_X = 100;
    private static final double MAX_ENDING_X = 600;

    public double getMIN_WIDTH() {
        return MIN_WIDTH;
    }

    public double getMAX_WIDTH() {
        return MAX_WIDTH;
    }

    public double getMIN_STARTING_X() {
        return MIN_STARTING_X;
    }

    public double getMAX_STARTING_X() {
        return MAX_STARTING_X;
    }

    public double getMIN_ENDING_X() {
        return MIN_ENDING_X;
    }

    public double getMAX_ENDING_X() {
        return MAX_ENDING_X;
    }

    public Platform(double width, double startingX, double endingX) {
        this.width = width;
        this.startingX = startingX;
        this.endingX = this.startingX+this.width;
    }

    public static Platform randomGenerator(Platform platform1){
        Random random = new Random();

        double width = MIN_WIDTH + random.nextDouble() * (MAX_WIDTH - MIN_WIDTH);
        double startingX = platform1.getEndingX() + random.nextDouble() * (MAX_STARTING_X - MIN_STARTING_X) ;
        double endingX = startingX+width;


        Platform platform = new Platform(width, startingX, endingX);
        Game.platforms.add(platform);
        return platform;
    }




    public Color getColor() {
        return color;
    }

    public double getStartingX() {
        return startingX;
    }

    public void setStartingX(double startingX) {
        this.startingX = startingX;
    }

    public double getEndingX() {
        return endingX;
    }

    public void setEndingX(double endingX) {
        this.endingX = endingX;
    }

    public double getCentreX() {
        return centreX;
    }

    public void setCentreX(double centreX) {
        this.centreX = centreX;
    }


    public double calculateCentrePosition(){
        return getStartingX()+getEndingX()/2 ;
    }


}
