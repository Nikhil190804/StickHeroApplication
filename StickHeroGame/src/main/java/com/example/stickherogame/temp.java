package com.example.stickherogame;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class temp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Animate Me");
        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("JavaFX Animation Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a KeyValue representing the target property and value
        KeyValue keyValue = new KeyValue(button.translateXProperty(), 200);

        // Create a KeyFrame with a specified duration and target values
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);

        // Create a Timeline and add the KeyFrame
        Timeline timeline = new Timeline(keyFrame);

        // Set the cycle count (indefinite means the animation will continue indefinitely)
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Play the animation
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
