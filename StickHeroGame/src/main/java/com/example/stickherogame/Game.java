package com.example.stickherogame;


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

    public Platform getLeftPlatform() {
        return leftPlatform;
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

    private boolean isFinished;
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
        return 0;
    }

    @Override
    public void render() {
    }

    public void changeScene1to2(){}
    public void generatePlatforms(){}
    public void generateCherries(){}
    Player renderPlayer(){
        return null;
    }
    Cherry renderCherries(){
        return null;
    }
    public boolean isSuccessfull(){
        return false;
    }
    public void changeScene2to3(){}
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
//        Platform.randomGenerator();
//        Platform.randomGenerator();
//        Platform platformStart = platforms.remove();
//        Platform platformEnd = platforms.remove();
//        controllerSceneTwo.renderPlatforms(platformStart,platformEnd);

    }

    public void start(){
        Random random = new Random();
        /*
        // called for first time only
        //generate 2 platforms
        Platform firstplatform = new Platform( 50 + random.nextDouble() * (200 - 50),30,0);
        //firstplatform.setCentreX(firstplatform.getStartingX()+((firstplatform.getWidthOfPlatform())/2));
        firstplatform.setCentreX(firstplatform.calculateCentrePosition());
        Game.platforms.add(firstplatform);
        Platform.randomGenerator(Game.platforms.peek());
        //update the current platfrom count
        setCURRENT_PLATFORM_COUNT(2);
        //add the platform to screen
        Platform platform1 = Game.platforms.peek();
        Game.platforms.poll();
        Platform platform2 = Game.platforms.peek();
        platform1.setCentreX(platform1.calculateCentrePosition());
        controllerSceneTwo.renderPlatforms(platform1,platform2);
        //now load a player object
        //now perform calculation on setLayoutX for player object
        player.setLayoutX(platform1.getCentreX());
        player.setPreserveRatio(true);
       // player.setLayoutX(97);
        //now add player to screen
        controllerSceneTwo.renderPlayerObjectFirstTime(player);
        System.out.println("platform"+platform1.getCentreX());*/


        leftPlatform=new Platform( 50 + random.nextDouble() * (200 - 50),30,0);
        Game.platforms.add(leftPlatform);
        //add second platform
        Platform.randomGenerator(Game.platforms.peek());
        //now dequee the platforms
        leftPlatform=Game.platforms.remove();
        rightPlatform=Game.platforms.remove();
        Image playerImage = new Image(getClass().getResource("/com/example/stickherogame/Images/player-removebg-preview.png").toExternalForm());
        Player player = new Player(0,0,45,80,null,30 + leftPlatform.getWidth()/2 ,0,playerImage);
        player.setLayoutX(leftPlatform.getCentreX());
        player.setPreserveRatio(true);
        controllerSceneTwo.renderPlatforms(leftPlatform,rightPlatform);
        controllerSceneTwo.renderPlayerObjectFirstTime(player);
        setCURRENT_PLATFORM_COUNT(2);
    }


}
