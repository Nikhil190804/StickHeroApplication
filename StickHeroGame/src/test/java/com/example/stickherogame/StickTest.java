package com.example.stickherogame;

import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StickTest {

    @Test
    public void testStickInitialization() {
        // Given
        double length = 10;
        double x = 20;
        double y = 30;
        double rotationAngle = 45;
        double speed_of_rotation = 5;

        // When
        Stick stick = new Stick(length, x, y, rotationAngle, speed_of_rotation);

        // Then
        assertEquals(length, stick.getLength());
        assertEquals(x, stick.getX());
        assertEquals(y, stick.getY());
        assertEquals(rotationAngle, stick.getRotationAngle());
        assertEquals(speed_of_rotation, stick.getSpeed_of_rotation());
    }

    @Test
    public void testRotateAndExtend() {
        // Given
        Stick stick = new Stick(10, 20, 30, 45, 5);

        // When
        Stick.rotateAndExtend(stick);

        // Then
        // Add assertions or additional checks as needed
    }

    @Test
    public void testResetAll() {
        // Given
        Stick stick = new Stick(10, 20, 30, 45, 5);

        // When
        stick.resetAll();

        // Then
        // Add assertions or additional checks as needed
    }

    @Test
    public void testCheckCollision() {
        // Given
        Stick stick = new Stick(10, 20, 30, 45, 5);
        Platform platform = new Platform(50, 0, 50);

        // When
        boolean collisionResult = stick.checkCollision(platform);

        // Then
        // Add assertions or additional checks as needed
        assertTrue(collisionResult);
    }
}
