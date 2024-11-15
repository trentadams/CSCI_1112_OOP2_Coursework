package chapter16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextMoveAndColorChange extends Application {
    
    private static final double PANE_WIDTH = 500;  // Pane width for boundary check
    private static final double PANE_HEIGHT = 400; // Pane height for vertical centering
    
    Text message = new Text("Programming is fun");
    double textXPosition = 250;

    public void start(Stage primaryStage) {
        // Create a Text object for the message
        
        message.setY(200); // Center the text vertically
        message.setX(250);
        
        // Create buttons to move the text
        Button moveLeftButton = new Button("Move Left");
        Button moveRightButton = new Button("Move Right");
        
        // Add actions to the buttons
        moveLeftButton.setOnAction(e -> moveTextLeft(textXPosition));
        moveRightButton.setOnAction(e -> moveTextRight(textXPosition));

        // Create radio buttons to change the text color
        RadioButton redButton = new RadioButton("Red");
        RadioButton greenButton = new RadioButton("Green");
        RadioButton blueButton = new RadioButton("Blue");
        
        // Group radio buttons together
        ToggleGroup colorGroup = new ToggleGroup();
        redButton.setToggleGroup(colorGroup);
        greenButton.setToggleGroup(colorGroup);
        blueButton.setToggleGroup(colorGroup);
        
        // Add listeners to radio buttons to change text color
        redButton.setOnAction(e -> changeTextColor(Color.RED));
        greenButton.setOnAction(e -> changeTextColor(Color.GREEN));
        blueButton.setOnAction(e -> changeTextColor(Color.BLUE));

        // Set default color to black
        redButton.setSelected(true);
        message.setFill(Color.RED);
        
        // Create a layout to hold the buttons and radio buttons
        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.BOTTOM_CENTER);
        controlPanel.getChildren().addAll(moveLeftButton, moveRightButton, redButton, greenButton, blueButton);
        
        // Create 
        Pane root = new Pane();
        root.getChildren().addAll(message, controlPanel);
        
        // Create and set the scene
        Scene scene = new Scene(root, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle("Text Move and Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Method to move the text to the left
    public void moveTextLeft(double textX) {
        if (textX > 0) {
            textXPosition -= 10;
            textX -= 10;
            message.setX(textX);
        }
    }

    // Method to move the text to the right
    public void moveTextRight(double textX) {
        if (textX < PANE_WIDTH - message.getLayoutBounds().getWidth()) {
            textXPosition += 10;
            textX += 10;
            message.setX(textX);
            
        }
    }

    // Method to change the color of the text
    private void changeTextColor(Color color) {
        message.setFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}