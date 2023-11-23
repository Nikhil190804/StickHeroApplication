package com.example.stickherogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    static boolean PLAY_SOUND = true;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image(getClass().getResource("/com/example/stickherogame/Images/game logo.jpg").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Stick Hero");


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}