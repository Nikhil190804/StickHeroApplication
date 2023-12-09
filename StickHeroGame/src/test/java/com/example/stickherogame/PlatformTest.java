package com.example.stickherogame;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PlatformTest {


//    test if the platforms are made or not and testing that it should be random
    @Test
    public void testRandomGeneration() {
        // Given
        Platform platform = new Platform(70, 30, 100);
        Platform newPlatform1 = Platform.testRandomGenerator(platform);
        Platform newPlatform2 = Platform.testRandomGenerator(platform);
        Platform newPlatform3 = Platform.testRandomGenerator(platform);
        Platform newPlatform4 = Platform.testRandomGenerator(platform);
        assertNotNull(newPlatform1);
        assertNotNull(newPlatform2);
        assertNotNull(newPlatform3);
        assertNotNull(newPlatform4);

        assertNotEquals(platform,newPlatform1);
        assertNotEquals(platform,newPlatform2);
        assertNotEquals(platform,newPlatform3);
        assertNotEquals(platform,newPlatform4);





    }


    @Test
    public void testGetWidthOfPlatform() {
        // Given
        Platform platform = new Platform(150, 50, 200);

        // When
        double width = platform.getWidthOfPlatform();

        // Then
        assertEquals(150, width);
    }

    @Test
    public void testCalculateCentrePosition() {
        // Given
        Platform platform = new Platform(100, 50, 150);

        // When
        double centrePosition = platform.calculateCentrePosition();

        // Then
        assertEquals(100, centrePosition);
    }

    @Test
    public void testGetHeightOfPlatform() {
        // Given
        Platform platform = new Platform(120, 300, 420);

        // When
        double height = platform.getHeightOfPlatform();

        // Then
        assertEquals(150, height);
    }



    @Test
    public void testSetStartingX() {
        // Given
        Platform platform = new Platform(120, 300, 420);

        // When
        platform.setStartingX(250);

        // Then
        assertEquals(250, platform.getStartingX());
    }

    @Test
    public void testSetEndingX() {
        // Given
        Platform platform = new Platform(120, 300, 420);

        // When
        platform.setEndingX(500);

        // Then
        assertEquals(500, platform.getEndingX());
    }

    @Test
    public void testSetCentreX() {
        // Given
        Platform platform = new Platform(120, 300, 420);

        // When
        platform.setCentreX(350);

        // Then
        assertEquals(350, platform.getCentreX());
    }



    // Add more test methods as needed for other functionality


}


