package Chapter14;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Random;

public class exercise14_28 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create an instance of ClockPane
        ClockPane clockPane = new ClockPane();

        // Generate random hour and minute values
        Random random = new Random();
        int hour = random.nextInt(12); // Hour between 0 and 11
        int minute = random.nextInt(2) * 30; // Minute is either 0 or 30

        // Set the hour and minute in the clock
        clockPane.setHour(hour);
        clockPane.setMinute(minute);
        clockPane.setSecond(0); // Set seconds to 0

        // Set only hour and minute hands to visible
        clockPane.setHourHandVisible(true);
        clockPane.setMinuteHandVisible(true);
        clockPane.setSecondHandVisible(false);

        // Create a StackPane and add the clockPane
        StackPane pane = new StackPane();
        pane.getChildren().add(clockPane);

        // Create a Scene
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Clock Test");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Paint the clock initially
        clockPane.paintClock();
    }
    
    //IMPORTANT: DO NOT FORGET
    public static void main(String[] args) {
        launch(args);
    }
}