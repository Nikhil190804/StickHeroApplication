package com.example.stickherogame;

import javafx.scene.shape.Line;

public class Stick extends Line {
    private double length;
    private double x;
    private double y;

    public Stick(double length, double x, double y, double rotationAngle, double speed_of_rotation) {
        this.length = length;
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.rotationAngle = rotationAngle;
        this.speed_of_rotation = speed_of_rotation;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    public double getSpeed_of_rotation() {
        return speed_of_rotation;
    }

    public void setSpeed_of_rotation(double speed_of_rotation) {
        this.speed_of_rotation = speed_of_rotation;
    }

    private double rotationAngle;
    private double speed_of_rotation;

    public static void rotateAndExtend(Stick stick){}

    public void resetAll(){}

    public boolean checkCollision(Platform platform){
        return true;
    }

}
