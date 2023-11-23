package com.example.stickherogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class ControllerSceneOne {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void playbutton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("play");
        Game newGame = new Game(false,stage);
        newGame.runner();
    }

    public void help(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.CLOSE);
        alert.setTitle("Help");
        alert.setResizable(true);
        alert.setContentText("Hold the screen to spawn sticks");
        alert.show();
    }


    public void sound(MouseEvent event) {
        String id_of_image = ((ImageView) event.getSource()).getId();
        if (id_of_image.equals("sound")) {
            System.out.println("sound");
            MainApplication.PLAY_SOUND = false;
            Image newImage = new Image(getClass().getResource("/com/example/stickherogame/Images/mute.jpg").toExternalForm());
            ((ImageView) event.getSource()).setImage(newImage);
            ((ImageView) event.getSource()).setId("mute");
        } else {
            System.out.println("mute");
            MainApplication.PLAY_SOUND = true;
            Image newImage = new Image(getClass().getResource("/com/example/stickherogame/Images/sound_icon.png").toExternalForm());
            ((ImageView) event.getSource()).setImage(newImage);
            ((ImageView) event.getSource()).setLayoutX(8);
            ((ImageView) event.getSource()).setLayoutY(329);
            ((ImageView) event.getSource()).setId("sound");
        }
    }

    public void skins(MouseEvent event) {
        System.out.println("skins");
    }

    public void loadAndSave(MouseEvent event) {
        System.out.println("loadandsave");
    }

}
