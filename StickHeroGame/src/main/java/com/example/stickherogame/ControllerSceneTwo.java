package com.example.stickherogame;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSceneTwo implements Initializable {
    private Timeline stickAnimation;
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
       parent_anchorpane.setOnMousePressed(this::print);
       parent_anchorpane.setOnMouseReleased(this::print2);
        stickAnimation = new Timeline(
                new KeyFrame(Duration.seconds(0.1), event -> increaseStickLength())
        );
        stickAnimation.setCycleCount(Timeline.INDEFINITE);
        newGame = new Game(false,this,0,null,null);
        newGame.start();
    }

    private void displaySoundErrorLabel() {
    }

    public void renderPlatforms(Platform platform1, Platform platform2){
        platform1.setLayoutX(platform1.getStartingX());
        platform1.setLayoutY(250);
        platform2.setLayoutX(platform2.getStartingX());
        platform2.setLayoutY(250);
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
        Platform platformPlayerisON = Game.platforms.peek();
        double mid_point = platformPlayerisON.getStartingX() + (platformPlayerisON.getWidth()/2);
        player.setLayoutX(mid_point);
        player.setLayoutY(250);
        parent_anchorpane.getChildren().add(player);
    }
    public void renderPlayerObjectFirstTime(Player player){
        //player.setLayoutX(player.getX_coordinate());
        //player.setLayoutY(208);
        parent_anchorpane.getChildren().add(player);

    }

    private void print(MouseEvent event) {
        System.out.println("start");
        Line line = new Line();
        line.setLayoutX(235);
        line.setLayoutY(250);
        line.setStartX(-100);
        line.setStartY(-3);
        line.setEndX(-100);
        line.setEndY(-80);
        line.setStroke(Color.RED);
        parent_anchorpane.getChildren().add(line);
        stickAnimation.play();
        /*
        System.out.println("start");
        while (true){
            try{
            Thread.sleep(1000);
                System.out.println("now");
                line.setEndX(line.getEndX()+5);
            }
            catch (Exception e){
                System.out.println("fd");
            }
        }*/
    }
    private void print2(MouseEvent event){
        System.out.println("end");
        stickAnimation.stop();
    }

    private void increaseStickLength() {
        // Increase the length of the stick
        System.out.println("increaing");
    }


}
