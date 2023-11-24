package com.example.stickherogame;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.util.Duration;
import java.util.Stack;

public class ControllerSceneOne {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void playbutton(ActionEvent event) throws IOException {
        boolean playSoundResult=Sound.playSound(2);
        if(playSoundResult==false){
            //show a label on screen
            /*
            Label no_sound_label = new Label();
            no_sound_label.setText("Cant Play Sound!!!!!!");
            no_sound_label.setTextFill(Color.RED);
            no_sound_label.setFont(Font.font("System", FontWeight.BOLD, 14));
            scene = new Scene(no_sound_label,100,100);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3),no_sound_label);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.play();*/
        }

        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("play");
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
