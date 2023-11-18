package com.example.stickherogame;

import javafx.scene.image.ImageView;

public class Cherry extends ImageView implements RandomObjectGenerator{
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

    public Cherry(boolean hasBeenCollected) {
        this.hasBeenCollected = hasBeenCollected;
    }
    private final double Height=150;
    private final double Width=150;
    private boolean hasBeenCollected;

    public static boolean cherrySpawned(){
        return true;
    }

    public boolean checkCollision(Player player){
        return false;
    }
    public static void randomGenerator(){}
}
