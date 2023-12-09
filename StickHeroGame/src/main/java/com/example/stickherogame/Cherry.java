package com.example.stickherogame;

import javafx.scene.image.ImageView;
import java.util.*;
public class Cherry extends ImageView implements RandomObjectGenerator{
    private final double Height=150;
    private static final double Width=150;
    double x_coordinate;


    public Cherry() {

        this.hasBeenCollected = hasBeenCollected;


    }

    // Private constructor to prevent direct instantiation
    private Cherry(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }


    public static class CherryFactory {
        public static Cherry createRandomCherry(double startingX, double endingX) {
            Random random = new Random();
            double randomX = random.nextDouble() * Math.abs(startingX - endingX - Width);
            return new Cherry(randomX);
        }
    }


    private boolean hasBeenCollected = false;
    public double getHeight() {
        return Height;
    }

    public double getWidth() {
        return Width;
    }

    public boolean isHasBeenCollected() {
        return hasBeenCollected;
    }

    public void setHasBeenCollected(boolean hasBeenCollected) {
        this.hasBeenCollected = hasBeenCollected;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }



}
