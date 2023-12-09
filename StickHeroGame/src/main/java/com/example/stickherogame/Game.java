package com.example.stickherogame;


import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;


public class Game implements Render,Movable {
    private int HighScore;
    private ControllerSceneTwo controllerSceneTwo;
    private Platform leftPlatform;
    public static int SkinFlag=1;
    public static boolean isLoad=false;
    public static StoreObject LoadedObject=null;

    public Platform getLeftPlatform() {
        return leftPlatform;
    }

    public void setLeftPlatform(Platform leftPlatform) {
        this.leftPlatform = leftPlatform;
    }

    public void setRightPlatform(Platform rightPlatform) {
        this.rightPlatform = rightPlatform;
    }

    public Platform getRightPlatform() {
        return rightPlatform;
    }

    private Platform rightPlatform;

    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private  boolean isFinished;
    private Player player;
    public static Queue<Platform> platforms;
    public static Queue<Cherry> cherries;
    private final int PLATFORM_COUNT=2;
    private int CURRENT_PLATFORM_COUNT;

    public int getCURRENT_PLATFORM_COUNT() {
        return CURRENT_PLATFORM_COUNT;
    }

    public void setCURRENT_PLATFORM_COUNT(int CURRENT_PLATFORM_COUNT) {
        this.CURRENT_PLATFORM_COUNT = CURRENT_PLATFORM_COUNT;
    }

    public Game(boolean value, ControllerSceneTwo cont2, int platform_count,Platform p1,Platform p2){
        this.isFinished=value;
        Game.platforms= new ArrayDeque<>();
        Game.cherries=new ArrayDeque<>();
        this.controllerSceneTwo=cont2;
        this.CURRENT_PLATFORM_COUNT=platform_count;
        this.leftPlatform=p1;
        this.rightPlatform=p2;
    }
    @Override
    public double move(double distance) {
        //it moves the screen
        double d = distance+300;
        return d;
    }

    @Override
    public Player renderPlayer(Player player){
        player.setLayoutX(player.getX_coordinate()- 25 );
        player.setLayoutY(208);
        return player;
    }
    public void runner(){
        // run the game until not finished
        while (isFinished==false){
            Platform platform1 = Game.platforms.peek();
            platform1.setStartingX(65);
            platform1.setY(250);
            Platform.randomGenerator(platform1);
            Game.platforms.poll();
            Platform platform2 = Game.platforms.peek();
            controllerSceneTwo.renderPlatforms(platform1,platform2);
        }
    }

    public void start(){
        Random random = new Random();
        leftPlatform=new Platform( 50 + random.nextDouble() * (200 - 50),30,30 + 50 + random.nextDouble() * (200 - 50));
        Game.platforms.add(leftPlatform);
        //add second platform
        Platform.randomGenerator(Game.platforms.peek());
        //now dequee the platforms
        leftPlatform=Game.platforms.remove();
        rightPlatform=Game.platforms.remove();
        Image playerImage;
        if(Game.SkinFlag==1){
            playerImage = new Image(getClass().getResource("/com/example/stickherogame/Images/player-removebg-preview.png").toExternalForm());
        }
        else{
            playerImage = new Image(getClass().getResource("/com/example/stickherogame/Images/player2.png").toExternalForm());
        }
        if(Game.isLoad==true){
            System.out.println("score:"+Game.LoadedObject.getScore());
            player = new Player(Game.LoadedObject.getScore(),Game.LoadedObject.getCherryCounter(),45,80,null, leftPlatform.getCentreX(),0,playerImage);
        }
        else{
            player = new Player(0,0,45,80,null, leftPlatform.getCentreX(),0,playerImage);
        }
        Game.isLoad=false;
        Game.LoadedObject=null;
        player.setLayoutX(leftPlatform.getCentreX());
        player.setPreserveRatio(true);
        controllerSceneTwo.renderPlatforms(leftPlatform,rightPlatform);
        controllerSceneTwo.renderPlayerObject(player);
        setCURRENT_PLATFORM_COUNT(2);
        controllerSceneTwo.setScore();
        controllerSceneTwo.setCherry();
    }
}
