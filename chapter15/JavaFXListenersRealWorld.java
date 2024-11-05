package chapter15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JavaFXListenersRealWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	//Define the size of the window in pixels
        double width = 400;
        double height = 400;
        
        //Create a BallPane OBJ 1/15 the size of the window and place it in the center
        BallPane ballPane = new BallPane(width / 2,height / 2, Math.min(width,height) / 15);
        
        //Create four button OBJS and set their action to the corresponding method 
        Button btUp = new Button("Up");
        btUp.setOnAction(e -> ballPane.moveUp());

        Button btDown = new Button("Down");
        btDown.setOnAction(e -> ballPane.moveDown());

        Button btLeft = new Button("Left");
        btLeft.setOnAction(e -> ballPane.moveLeft());

        Button btRight = new Button("Right");
        btRight.setOnAction(e -> ballPane.moveRight());
        
        //Create a vertical box OBJ and define its child nodes
        VBox buttons = new VBox(btUp, btDown, btLeft, btRight);
        //Set the properties of the VBox (position, and spacing of elements)
        buttons.setAlignment(Pos.TOP_LEFT);
        buttons.setSpacing(10);

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttons);
        
        //Create the scene and setup the window
        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click to move ball");
        //Display the primaryStage as a window
        primaryStage.show();
    }
    
    //Main Method Code
    public static void main(String[] args) {
        Application.launch(args);
    }
}