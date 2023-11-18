package com.example.stickherogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Stick Hero");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}