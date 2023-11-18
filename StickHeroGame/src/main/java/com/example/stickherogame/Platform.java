package com.example.stickherogame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform extends Rectangle implements RandomObjectGenerator{
    private final double Height=150;


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

    public static void randomGenerator(){}

    private final Color color = Color.BLACK;
    private double width;
    private double startingX;
    private double endingX;
    private double centreX;

    public double calculateCentrePosition(){
        return 0;
    }

    public Platform(double width, double startingX, double endingX) {
        this.width = width;
        this.startingX = startingX;
        this.endingX = endingX;
    }
}
