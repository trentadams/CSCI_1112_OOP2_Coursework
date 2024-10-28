package Chapter14;

import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    
    // New Boolean properties
    private boolean hourHandVisible;
    private boolean minuteHandVisible;
    private boolean secondHandVisible;

    /** Construct a default clock with the current time */
    public ClockPane() {
        setCurrentTime();
        hourHandVisible = true;
        minuteHandVisible = true;
        secondHandVisible = true;
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        hourHandVisible = true;
        minuteHandVisible = true;
        secondHandVisible = true;
    }

    // Accessor methods for the new properties
    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    // Mutator methods for the new properties
    public void setHourHandVisible(boolean visible) {
        hourHandVisible = visible;
        paintClock();
    }

    public void setMinuteHandVisible(boolean visible) {
        minuteHandVisible = visible;
        paintClock();
    }

    public void setSecondHandVisible(boolean visible) {
        secondHandVisible = visible;
        paintClock();
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock();
    }

    /** Paint the clock */
    public void paintClock() {
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Draw hour hand if visible
        Line hLine = null;
        if (hourHandVisible) {
            double hLength = clockRadius * 0.5;
            double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);
        }

        // Draw minute hand if visible
        Line mLine = null;
        if (minuteHandVisible) {
            double mLength = clockRadius * 0.65;
            double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
            mLine = new Line(centerX, centerY, xMinute, minuteY);
            mLine.setStroke(Color.BLUE);
        }

        // Draw second hand if visible
        Line sLine = null;
        if (secondHandVisible) {
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
            sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);
        }

        // Add all elements to the pane
        getChildren().clear(); // Clear the pane
        getChildren().addAll(circle);
        if (hLine != null) getChildren().add(hLine);
        if (mLine != null) getChildren().add(mLine);
        if (sLine != null) getChildren().add(sLine);

        // Draw clock numbers
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
        getChildren().addAll(t1, t2, t3, t4);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}