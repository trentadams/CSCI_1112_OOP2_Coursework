package chapter15;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {

    private Circle mCircle;
    
    //No-arg constructor
    public BallPane() {
        this(0, 0, 10);
    }
    
    //Constructor
    public BallPane(double centerX, double centerY, double radius) {
    	//Create a circle obj
        mCircle = new Circle(centerX, centerY, radius);
        getChildren().add(mCircle);
    }
    
    

    public void moveUp() {
        if (mCircle.getCenterY() - mCircle.getRadius()  - 10 < 0) return;
        mCircle.setCenterY(mCircle.getCenterY() - 10);
    }
    public void moveDown() {
        if (mCircle.getCenterY() + mCircle.getRadius() + 10 > getHeight()) return;

        mCircle.setCenterY(mCircle.getCenterY() + 10);
    }
    public void moveRight() {
        if (mCircle.getCenterX() + mCircle.getRadius() + 10 > getWidth()) return;
        mCircle.setCenterX(mCircle.getCenterX() + 10);
    }
    public void moveLeft() {
        if (mCircle.getCenterX() - mCircle.getRadius()  - 10 < 0) return;
        mCircle.setCenterX(mCircle.getCenterX() - 10);

    }

}