package com.example.stickherogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerSceneThree  {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Label currentScore;
    @FXML
    private Label highScore;
    public void home(MouseEvent event) throws IOException {
        Sound.playSound(2);
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(null);
    }

    public void restart(MouseEvent event) throws IOException{
        Sound.playSound(2);
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(this::closing);
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

}
