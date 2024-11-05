package chapter15;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;


//New Class that extends application
public class Exercise15_15 extends Application {
	
	//NOTICE: This project is incomplete, 
	//but I need to move on to stay on pace.
    public void start(Stage primaryStage) throws Exception {
        //Create a pane OBJ
    	StackPane pane = new StackPane();
    	
    	// Create Rectangle OBJ
    	Rectangle rect = new Rectangle(200, 200, 20, 20);
    	
        //Create the scene and setup the window
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation Test");
        //Display the primaryStage as a window
        primaryStage.show();
    }
    //Main Method Code
    public static void main(String[] args) {
        Application.launch(args);
    }
}
