package com.example.stickherogame;

import com.example.stickherogame.Player;
import com.example.stickherogame.Stick;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        // Given
        int initialScore = 0;
        int initialCherryCounter = 0;
        double height = 80;
        double width = 45;
        Stick stick = new Stick(10, 1, 2, 90, 12);  // Provide the correct parameters for the Stick constructor
        double x = 100;
        double y = 150;
//        Image playerImage = new Image("/path/to/player/image.png"); // Replace with the actual path

        // When
        Player player = new Player(initialScore, initialCherryCounter, height, width, stick, x, y, null);

        // Then
        assertNotNull(player);
        assertEquals(initialScore, player.getScore());
        assertEquals(initialCherryCounter, player.getCherryCounter());
        assertEquals(height, player.getFitHeight());
        assertEquals(width, player.getFitWidth());
        assertEquals(208, player.getLayoutY());
        assertEquals(stick, player.getMyStick());
        assertEquals(x, player.getX_coordinate());
        assertEquals(y, player.getY_coordinate());
    }

    @Test
    public void testPlayerMovement() {
        // Given
        Player player = new Player(0, 0, 80, 45, new Stick(10, 1, 2, 90, 12), 100, 150, null);

        // When
        double distanceMoved = player.move(50);

        // Then
        assertEquals(0, distanceMoved);  // Assuming your move method always returns 0 for now
    }

    @Test
    public void testScoreIncrement() {
        // Given
        Player player = new Player(0, 0, 80, 45, new Stick(10, 1, 2, 90, 12), 100, 150, null);

        // When
        player.setScore(5);
        player.incrementScore(10);

        // Then
        assertEquals(15, player.getScore());
    }


//    @Test
//    public void testRandomGenerator() {
//        // Given
//        Platform platform1 = new Platform(100, 50, 150);
//
//        // When
//        Platform newPlatform = Platform.randomGenerator(platform1);
//
//        // Then
//        assertNotNull(newPlatform);
////        assertTrue(newPlatform.getWidthOfPlatform() >= platform1.getMIN_WIDTH() &&
////                newPlatform.getWidthOfPlatform() <= platform1.getMAX_WIDTH());
////        assertTrue(newPlatform.getStartingX() >= platform1.getEndingX() + platform1.getMIN_STARTING_X() &&
////                newPlatform.getStartingX() <= platform1.getEndingX() + platform1.getMAX_STARTING_X());
////        assertTrue(newPlatform.getEndingX() >= newPlatform.getStartingX() &&
////                newPlatform.getEndingX() <= newPlatform.getStartingX() + platform1.getMAX_WIDTH());
////        assertEquals((newPlatform.getStartingX() + newPlatform.getEndingX()) / 2, newPlatform.getCentreX());
//    }




    // Add more test methods as needed for other functionality
}
