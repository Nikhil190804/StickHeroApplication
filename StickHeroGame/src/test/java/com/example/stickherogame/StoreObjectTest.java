package com.example.stickherogame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreObjectTest {

    @Test
    public void testStoreObjectInitialization() {
        // Given
        String unique = "game1";
        int score = 10;
        int highScore = 20;
        int cherryCounter = 5;

        // When
        StoreObject storeObject = new StoreObject(unique, score, highScore, cherryCounter);

        // Then
        assertEquals(unique, storeObject.getUnique());
        assertEquals(score, storeObject.getScore());
        assertEquals(highScore, storeObject.getHighScore());
        assertEquals(cherryCounter, storeObject.getCherryCounter());
    }

    // Add more test methods for other functionality in the StoreObject class

    // Example: Test for highScoreGame method
    @Test
    public void testHighScoreGame() {
        // Given
        StoreObject storeObject = new StoreObject("game1", 10, 20, 5);

        // When
        StoreObject.highScoreGame(storeObject);

        // Then
        // Add assertions or additional checks as needed
    }

    // Example: Test for sav method
    @Test
    public void testSav() {
        // Given
        StoreObject storeObject = new StoreObject("game1", 10, 20, 5);

        // When
        StoreObject.sav(storeObject);

        // Then
        // Add assertions or additional checks as needed
    }
}
