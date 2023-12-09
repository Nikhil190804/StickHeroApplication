package com.example.stickherogame;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CherryTest {

    @Test
    public void testCherryInitialization() {
        // When
        Cherry cherry = new Cherry();

        // Then
        assertNotNull(cherry);
        assertFalse(cherry.isHasBeenCollected());
        assertEquals(150, cherry.getHeight());
        assertEquals(150, cherry.getWidth());
    }




}
