package com.example.stickherogame;

import javafx.animation.FadeTransition;
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
import javafx.stage.WindowEvent;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
        stage.setOnCloseRequest(this::closing);
        System.out.println("play");
        /*
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1));
        fadeOut.setNode(((Node) event.getSource()).getScene().getRoot());
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(e -> {
            try {
                // Load the new scene
                Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));

                // Create a fade in transition for the new scene
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), root);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);

                // Set up the new scene and show it
                Scene newScene = new Scene(root);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(newScene);
                fadeIn.play();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Start the fade out transition
        fadeOut.play();*/
    }

    private void closing(WindowEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"");
        alert.setTitle("Close Menu");
        alert.setResizable(true);
        alert.setContentText("Do You Really Want to Quit");
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);
        Optional<ButtonType> result=alert.showAndWait();
        if(result.isPresent() && result.get()==buttonTypeYes){
            //exit the game
        }
        else{
            //continue
            event.consume();
        }
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
        List<StoreObject> savedGamesObjects = new ArrayList<>();
        try{
            ObjectInputStream inputFile =null;
            inputFile=new ObjectInputStream(new FileInputStream("src/main/resources/com/example/stickherogame/Stored_Game.ser"));
            try{
                while(true){
                    StoreObject obj = (StoreObject) inputFile.readObject();
                    savedGamesObjects.add(obj);
                }
            }
            catch(EOFException e){

            }
        }
        catch (IOException e) {
            //
            System.out.println("142");
        }
        catch(ClassNotFoundException e){
            System.out.println("52");
        }
        System.out.println(savedGamesObjects.size());
        List<String> Stringchoices = new ArrayList<>();
        for (StoreObject obj : savedGamesObjects) {
            Stringchoices.add(obj.getUnique());
            System.out.println(obj.getUnique());
        }
       // List<String> choices = Arrays.asList("Option 1", "Option 2", "Option 3");
        ChoiceDialog<String> dialog = new ChoiceDialog<>(Stringchoices.get(0), Stringchoices);
        dialog.setTitle("Load Game");
        dialog.setHeaderText("Choose an option:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(choice -> System.out.println("Selected: " + choice));
    }




}
