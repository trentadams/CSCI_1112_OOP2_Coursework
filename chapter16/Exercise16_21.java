package chapter16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application {
    
    private static final double PANE_WIDTH = 100;
    private static final double PANE_HEIGHT = 100;
    
    // Create a Text object for the message
    int counterValue = 30;
    Text message = new Text("" + counterValue);


    public void start(Stage primaryStage) {
    	
    	//Position the message text OBJ
        message.setY(50);
        message.setX(50);
        
        //Create a media OBJ
        Media sound = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        
        // Create a keyframe that decreases counterValue every second
        KeyFrame keyframe = new KeyFrame(Duration.seconds(1), event -> {
            if (counterValue > 0) {
                message.setText("" + counterValue);
                counterValue--;
            } else {
                message.setText("0");
                mediaPlayer.play();
            }
         }
        );
        
        // Create timeline obj
        Timeline counter = new Timeline(keyframe);
        counter.setCycleCount(counter.INDEFINITE);
        counter.play();
        // Create pane
        Pane pane = new Pane();
        pane.getChildren().addAll(message);
        
        // Create and set the scene
        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle("Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}