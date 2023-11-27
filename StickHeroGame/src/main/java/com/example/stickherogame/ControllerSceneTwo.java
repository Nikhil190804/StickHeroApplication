package com.example.stickherogame;

import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSceneTwo implements Initializable {
    private boolean isMousePressed;
    private Game newGame;
    @FXML
    private AnchorPane pausemenu;
    @FXML
    private AnchorPane parent_anchorpane;
    @FXML
    private Button button1;
    private Parent root;
    private Stage stage;
    private Scene scene;
    public void pausemenu(MouseEvent event){
        boolean playSoundResult=Sound.playSound(2);
       pausemenu.setVisible(true);
        System.out.println("pause");
    }

    @FXML
    public void MousePressed(MouseEvent event){}

    @FXML
    public void MouseReleased(MouseEvent event){}

    public void resume(ActionEvent event){
        System.out.println("resume");
        //parent_anchorpane.setMouseTransparent(true);
        pausemenu.setVisible(false);
    }

    public void save(ActionEvent event){
        //save game logic here
        pausemenu.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newGame = new Game(false,this,0);
        newGame.start();
    }

    private void displaySoundErrorLabel() {
    }

    public void renderPlatforms(Platform platform1, Platform platform2){
        platform1.setLayoutX(65);
        platform1.setLayoutY(250);
        platform2.setLayoutY(250);
        platform2.setLayoutX(400);
        platform1.setWidth(platform1.getWidthOfPlatform());
        platform1.setHeight(platform1.getHeightOfPlatform());
        platform2.setHeight(platform2.getHeightOfPlatform());
        platform2.setWidth(platform2.getWidthOfPlatform());
        parent_anchorpane.getChildren().add(platform1);
        parent_anchorpane.getChildren().add(platform2);
        /*
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(8), platform1);
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(8), platform2);
        translateTransition.setByX(-1000); // Move 100 pixels to the left
        translateTransition2.setByX(-1000); // Move 100 pixels to the left
        translateTransition.play();
        translateTransition2.play();
        //translateTransition.setOnFinished(run(new ActionEvent(),platform1));
        SequentialTransition parallelTransition = new SequentialTransition(translateTransition, translateTransition2);

        // Set an event handler to be executed when the parallel transition is finished
        parallelTransition.setOnFinished(event -> {
            // Code to execute after both transitions are finished
            System.out.println("Both transitions are complete!");
        });
        // Start the parallel transition
        parallelTransition.play();
        //parent_anchorpane.getChildren().add(rc);
        //parent_anchorpane.getChildren().add(platform2);*/

    }

    public void renderPlayerObject(Player player){
        parent_anchorpane.getChildren().add(player);
    }



}
