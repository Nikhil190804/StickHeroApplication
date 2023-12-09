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
import javafx.stage.WindowEvent;
import javafx.scene.control.ButtonType;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


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
    }

    private void closing(WindowEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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

    public void skins(ActionEvent event) {
        boolean playSoundResult=Sound.playSound(2);
        List<String> choices = Arrays.asList("Skin 1 (Default)", "Skin 2");
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Skins");
        dialog.setHeaderText("Choose an option:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(choice -> {
            if(choice.equals("Skin 1 (Default)")){
                Game.SkinFlag=1;
            }
            else{
                Game.SkinFlag=2;
            }
        });
    }

    public void loadAndSave(MouseEvent event) {
        boolean playSoundResult=Sound.playSound(2);
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
                // EOF reached
            }
        }
        catch (IOException e) {
            // Some IO execption occured
        }
        catch(ClassNotFoundException e){
            // Class doesn't exist
        }
        List<String> Stringchoices = new ArrayList<>();
        for (StoreObject obj : savedGamesObjects) {
            Stringchoices.add(obj.getUnique());
        }
        ChoiceDialog<String> dialog = new ChoiceDialog<>(Stringchoices.get(0), Stringchoices);
        dialog.setTitle("Load Game");
        dialog.setHeaderText("Choose an option:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(choice -> {
            //iterate over the array
            for (StoreObject obj : savedGamesObjects) {
                if(obj.getUnique().equals(choice)){
                    Game.isLoad=true;
                    Game.LoadedObject=obj;
                    //now start the game with these offsets
                    try {
                        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                    } catch (IOException e) {
                        //IO exception occured
                    }
                    scene = new Scene(root);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(this::closing);
                    break;
                }
            }
        });
    }
}
