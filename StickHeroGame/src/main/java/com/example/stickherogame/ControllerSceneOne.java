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
import javafx.stage.Stage;
import java.io.IOException;


public class ControllerSceneOne {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void playbutton(ActionEvent event) throws IOException {
        boolean playSoundResult=Sound.playSound(2);
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("play");
    }

    public void help(MouseEvent event) {
        boolean playSoundResult=Sound.playSound(2);
        Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.CLOSE);
        alert.setTitle("Help");
        alert.setResizable(true);
        alert.setContentText("Hold the screen to spawn sticks");
        alert.show();
    }


    public void sound(MouseEvent event) {
        boolean playSoundResult=Sound.playSound(2);
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
        boolean playSoundResult=Sound.playSound(2);
        System.out.println("skins");
    }

    public void loadAndSave(MouseEvent event) {
        boolean playSoundResult=Sound.playSound(2);
        System.out.println("loadandsave");
    }

}
