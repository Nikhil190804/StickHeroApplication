package com.example.stickherogame;

import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerSceneTwo implements Initializable {
    private boolean flagForPauseMenu =false;
    private Timeline stickAnimation;
    private Game newGame;
    @FXML
    private AnchorPane pausemenu;
    @FXML
    private AnchorPane parent_anchorpane;
    @FXML
    private Label scoreLabel;
    @FXML
    private TextField gameInput;
    @FXML
    private Button submit;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private Line stickAsLine;
    public void pausemenu(MouseEvent event){
        flagForPauseMenu=true;
        System.out.println(pausemenu.isMouseTransparent());
        boolean playSoundResult=Sound.playSound(2);
<<<<<<< HEAD
       pausemenu.setVisible(true);
       submit.setVisible(false);
       gameInput.setVisible(false);
       gameInput.setPromptText("Enter Game Name.....");
       gameInput.clear();
=======
        pausemenu.setVisible(true);
>>>>>>> 3d9514403f43921bd4e803d24a576570e5a6b660
        System.out.println("pause");
    }

    public void resume(ActionEvent event){
        System.out.println("resume");
        //parent_anchorpane.setMouseTransparent(true);
        pausemenu.setVisible(false);
        flagForPauseMenu=false;
    }

    public void save(ActionEvent event){
        //save game logic here
        //pausemenu.setVisible(false);
        gameInput.setVisible(true);
        submit.setVisible(true);
        /*
        StoreObject store = new StoreObject("game1",newGame.getPlayer().getScore(),0,newGame.getPlayer().getCherryCounter());
        StoreObject.sav(store);
        StoreObject store2 = new StoreObject("game2",newGame.getPlayer().getScore(),0,newGame.getPlayer().getCherryCounter());
        StoreObject.sav(store2);
        StoreObject store3 = new StoreObject("game3",newGame.getPlayer().getScore(),0,newGame.getPlayer().getCherryCounter());
        StoreObject.sav(store3);*/

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parent_anchorpane.setOnMousePressed(this::createStickAsLine);
        parent_anchorpane.setOnMouseReleased(this::rotateStickAsLine);
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
        player.setLayoutX(player.getX_coordinate()- 25 );
        player.setLayoutY(208);
        parent_anchorpane.getChildren().add(player);
    }

    private void createStickAsLine(MouseEvent event) {
        double targetX =event.getX();
        double targetY =event.getY();
        if((targetX >=636 & targetX<=670) & (targetY>=1 & targetY<=40)){
            event.consume();
        }
        else{
            if(flagForPauseMenu==true) return;
            System.out.println(event.getX());
            System.out.println(event.getY());
            System.out.println("start");
            stickAsLine = new Line();
            Platform platform1 = newGame.getLeftPlatform();
            stickAsLine.setLayoutX(platform1.getLayoutX()+platform1.getWidth()+100);
            stickAsLine.setLayoutY(250);
            stickAsLine.setStartX(-100);
            stickAsLine.setEndX(-100);
            stickAsLine.setStartY(0);
            stickAsLine.setEndY(0);
            stickAsLine.setStroke(Color.BLACK);
            stickAsLine.setStrokeWidth(5);
            parent_anchorpane.getChildren().add(stickAsLine);
            stickAnimation.play();
        }
        //y from 1 to 40
        //x from 636 to 670

    }
    private void rotateStickAsLine(MouseEvent event) {
        double targetX =event.getX();
        double targetY =event.getY();
        if((targetX >=636 & targetX<=670) & (targetY>=1 & targetY<=40)){
            //consume the event here , as it has been handled in earlier method
            event.consume();
        }
        else{
            if(flagForPauseMenu==true) return;
            System.out.println("end");
            stickAnimation.stop();

            // Use the endpoint where the stick is touching the platform as the pivot point
//        double pivotX = stickAsLine.getEndX();
//        double pivotY = stickAsLine.getEndY();
            //Button but = new Button();
            //but.setLayoutX(100);
            //but.setLayoutY(200);
            //but.setOnAction(e -> System.out.println("hellooooooooooooooooooooo"));
            //parent_anchorpane.getChildren().add(but);
            double midPointY = (stickAsLine.getStartY() + stickAsLine.getEndY()) / 2;
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), stickAsLine);
            rotateTransition.setByAngle(90);
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), stickAsLine);
            translateTransition.setByY(midPointY - stickAsLine.getEndY());
            translateTransition.setByX(-((stickAsLine.getStartY() + stickAsLine.getEndY())/2));
            ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);
            //TranslateTransition p1 = new TranslateTransition();

            parallelTransition.play();
            System.out.println(stickAsLine.getStartY()+stickAsLine.getEndY());
            Platform p1 = newGame.getLeftPlatform();
            Platform p2 = newGame.getRightPlatform();
            double sticklen=stickAsLine.getStartY()+stickAsLine.getEndY();
            sticklen=Math.abs(sticklen);
            double x = p2.getLayoutX();
            double s = p1.getLayoutX()+p1.getWidth();
            boolean isPassed;
            if(s+sticklen >=x){
                //pass
                System.out.println("pass");
                isPassed=true;
            }
            else{
                isPassed = false;
                System.out.println("fail");
            }
            final double target = sticklen+s;
            parallelTransition.setOnFinished(even -> movePlayer(newGame.getPlayer(),target,isPassed));
        }
    }



    private void increaseStickLength() {
        // Increase the length of the stick
        Sound.playSound(1);
        stickAsLine.setEndY(stickAsLine.getEndY()-5);
    }

    public void initializeStick(){

    }

    public void movePlayer(Player p , double finalSetLayoutXofPlayer,boolean isPassed) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), newGame.getPlayer());
        tt.setToX((finalSetLayoutXofPlayer) - (newGame.getPlayer().getLayoutX()+20));
        tt.play();
        if(isPassed==true){
            int oldScore =newGame.getPlayer().getScore();
            newGame.getPlayer().setScore(oldScore+1);
            scoreLabel.setText("Score : "+newGame.getPlayer().getScore());
            tt.setOnFinished(e -> {
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3),stickAsLine);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setOnFinished( ev -> {
                    parent_anchorpane.getChildren().remove(stickAsLine);
                    newGame.getLeftPlatform().setLayoutX(-300);
                    newGame.getRightPlatform().setLayoutX(30);
                    newGame.setLeftPlatform(newGame.getRightPlatform());
                    newGame.getLeftPlatform().setStartingX(30);
                    newGame.getLeftPlatform().setEndingX(30+newGame.getLeftPlatform().getWidth());
                    newGame.getLeftPlatform().setCentreX(newGame.getLeftPlatform().calculateCentrePosition());
                    Platform newp=Platform.randomGenerator(newGame.getLeftPlatform());
                    newGame.setRightPlatform(newp);
                    newp.setLayoutX(newp.getStartingX());
                    newp.setLayoutY(250);
                    newp.setWidth(newp.getWidthOfPlatform());
                    newp.setHeight(newp.getHeightOfPlatform());
                    parent_anchorpane.getChildren().add(newp);
                    Player oldPlayer = newGame.getPlayer();
                    oldPlayer.setId("player");
                    Player newPlayer = new Player(oldPlayer.getScore(),oldPlayer.getCherryCounter(),oldPlayer.getFitHeight(),oldPlayer.getFitWidth(),null,newGame.getLeftPlatform().getCentreX(),0,oldPlayer.getImage());
                    parent_anchorpane.getChildren().add(newPlayer);
                    parent_anchorpane.getChildren().remove(oldPlayer);
                    newPlayer.setId("player");
                    newGame.setPlayer(newPlayer);
                    newPlayer.setLayoutX(newGame.getLeftPlatform().getCentreX()-25);
                    newPlayer.setPreserveRatio(true);
                });
                fadeTransition.play();
                /*
                Image playerImage = new Image(getClass().getResource("/com/example/stickherogame/Images/player-removebg-preview.png").toExternalForm());
                Player py = new Player(0,0,45,80,null, 30,0,playerImage);
                py.setPreserveRatio(true);
                py.setLayoutX(30);
                parent_anchorpane.getChildren().add(py);
                System.out.println(py.getLayoutX()+"new plaeyr");
                System.out.println(newGame.getPlayer().getLayoutX());
                System.out.println(newGame.getPlayer().getLayoutY());
                System.out.println(newGame.getPlayer().getX());
                System.out.println(newGame.getPlayer().getY());
                System.out.println(newGame.getPlayer().getFitWidth());
                System.out.println(newGame.getPlayer().getFitHeight());*/
                /*
                StoreObject game = new StoreObject("hg",1,2,2);
                StoreObject.saveGame(game);*/
                /*
                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3),newGame.getLeftPlatform());
                TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(3), newGame.getRightPlatform());
                TranslateTransition translateTransition3= new TranslateTransition(Duration.seconds(3), newGame.getPlayer());
                translateTransition.setToX(-(newGame.getLeftPlatform().getWidth()+30)); // Move 100 pixels to the left
                translateTransition2.setToX(30-newGame.getRightPlatform().getLayoutX()); // Move 100 pixels to the left
                double coord =30-newGame.getRightPlatform().getLayoutX();
                //coord+=(newGame.getRightPlatform().getWidthOfPlatform());
                System.out.println(coord+"coord");
                //translateTransition3.setToX(-((30+newGame.getRightPlatform().getWidthOfPlatform())/2)-25);
                translateTransition.play();
                translateTransition2.play();
                //translateTransition3.play();*/
            });
            //dont need to set another transition for
        }
        else{
            //falling transition
            tt.setOnFinished(e -> {
                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), newGame.getPlayer());
                translateTransition.setToY(190); // Set the target y-coordinate for falling
                translateTransition.play();
                translateTransition.setOnFinished(ev ->  {
                    Sound.playSound(3);
                    changeScene2to3(ev);
                    // now switch scenes and show the endscreen
                } );
            });
        }
    }

    public void changeScene2to3(ActionEvent event) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), parent_anchorpane);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        fadeOutTransition.setOnFinished(e -> {
            int highScore=0;
            int currentscore = newGame.getPlayer().getScore();
            try {
                root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try{
                ObjectInputStream inputFile =null;
                StoreObject highScoreObject=null;
                inputFile=new ObjectInputStream(new FileInputStream("src/main/resources/com/example/stickherogame/HighScore_Game.bin"));
                highScoreObject = (StoreObject)inputFile.readObject();
                highScore=highScoreObject.getHighScore();
            }
            catch(IOException | ClassNotFoundException ex){
                StoreObject highScoreObject = new StoreObject("highscore",0,currentscore,0);
                StoreObject.highScoreGame(highScoreObject);
            }
            ObservableList<Node> l = root.getChildrenUnmodifiable();
            if (currentscore > highScore) {
                highScore = currentscore;
                StoreObject highScoreObject = new StoreObject("highscore", 0, currentscore, 0);
                StoreObject.highScoreGame(highScoreObject);
            }

            for (Node n : l) {
                if (Objects.equals(n.getId(), "currentScore")) {
                    ((Label) n).setText("" + currentscore);
                } else if (Objects.equals(n.getId(), "highScore")) {
                    ((Label) n).setText("" + highScore);
                } else {
                    //pass
                }
            }
            Scene newScene = new Scene(root);
            Stage newStage = (Stage) parent_anchorpane.getScene().getWindow();
            newStage.setScene(newScene);
            // Add the transition for screen shifting
            double stickLength = Math.abs(stickAsLine.getEndY() - stickAsLine.getStartY());
            TranslateTransition shiftTransition = new TranslateTransition(Duration.seconds(1), parent_anchorpane);
            shiftTransition.setByX(stickLength); // Shift to the new left platform
            shiftTransition.setOnFinished(eventShift -> {
                parent_anchorpane.getChildren().remove(newGame.getLeftPlatform());
                newGame.getLeftPlatform().setLayoutX(-300);
                newGame.getLeftPlatform().setStartingX(30);
                newGame.getLeftPlatform().setEndingX(30 + newGame.getLeftPlatform().getWidth());
                newGame.getLeftPlatform().setCentreX(newGame.getLeftPlatform().calculateCentrePosition());
                Platform newp = Platform.randomGenerator(newGame.getLeftPlatform());
                newGame.setLeftPlatform(newp);
                newp.setLayoutX(newp.getStartingX());
                newp.setLayoutY(250);
                newp.setWidth(newp.getWidthOfPlatform());
                newp.setHeight(newp.getHeightOfPlatform());
                parent_anchorpane.getChildren().add(newp);
                newGame.setRightPlatform(Platform.randomGenerator(newp));
                newGame.getRightPlatform().setLayoutX(newGame.getRightPlatform().getStartingX());
                newGame.getRightPlatform().setLayoutY(250);
                newGame.getRightPlatform().setWidth(newGame.getRightPlatform().getWidthOfPlatform());
                newGame.getRightPlatform().setHeight(newGame.getRightPlatform().getHeightOfPlatform());
                parent_anchorpane.getChildren().add(newGame.getRightPlatform());

                // Fade in the new scene
                FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), parent_anchorpane);
                fadeInTransition.setFromValue(0.0);
                fadeInTransition.setToValue(1.0);
                fadeInTransition.play();
            });
            shiftTransition.play();
        });

        fadeOutTransition.play();
    }

    public void saveGame(ActionEvent event){
        flagForPauseMenu=false;
        String enteredText = gameInput.getText();
        System.out.println("Entered Text: " + enteredText);
        StoreObject store = new StoreObject(enteredText,newGame.getPlayer().getScore(),0,newGame.getPlayer().getCherryCounter());
        StoreObject.sav(store);
        pausemenu.setVisible(false);
    }
}