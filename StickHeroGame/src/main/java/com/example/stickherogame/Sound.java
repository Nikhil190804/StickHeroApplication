package com.example.stickherogame;

import java.io.File;
import javafx.scene.media.*;
public class Sound {
    public static boolean playSound(int sound_flag) {
        String AudioFile = "Sound" + sound_flag+".wav";
        String AudioFilePath = "src/main/resources/com/example/stickherogame/Sounds/" + AudioFile;
       if(MainApplication.PLAY_SOUND){
           try {
               File newFile = new File(AudioFilePath);
               if (newFile.exists() == true) {
                   System.out.println("valid");
                   String uriString = newFile.toURI().toString();
                   Media media = new Media(uriString);
                   MediaPlayer mediaPlayer = new MediaPlayer(media);
                   mediaPlayer.play();
                   return true;
               } else {
                   return false;
               }
           } catch (Exception e) {
               return false;
           }
       }
       else{
           return false;
       }
    }
}

/*
Mapping of the Audio Files:-----
Sound1 :
Sound2 :
Sound3 :
Sound4 :
Sound5 :

 */