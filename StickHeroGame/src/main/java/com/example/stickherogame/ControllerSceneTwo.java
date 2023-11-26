package com.example.stickherogame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
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
        newGame = new Game(false,this);
        newGame.runner();
    }

    private void displaySoundErrorLabel() {
    }

    public void renderPlatforms(Platform platform1, Platform platform2){
        Rectangle rc = new Rectangle(platform1.getWidthOfPlatform(),platform1.getHeightOfPlatform(),platform1.getColor());
        //rc.setX(platform1.getStartingX());

        rc.setLayoutX(120);
        rc.setLayoutY(250);
        //rc.setY(0);
        platform1.setLayoutX(120);
        platform1.setLayoutY(250);
        platform1.setWidth(platform1.getWidthOfPlatform());
        platform1.setHeight(platform1.getHeightOfPlatform());
        parent_anchorpane.getChildren().add(platform1);
        //parent_anchorpane.getChildren().add(rc);
        //parent_anchorpane.getChildren().add(platform2);

    }


}
