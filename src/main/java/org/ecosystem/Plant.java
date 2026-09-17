package org.ecosystem;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Plant {
    private double x;
    private double y;

    private double energy;

    private final Circle graphic;

    public Plant(double x,double y){
        this.x = x;
        this.y = y;
        this.energy=30;

        graphic = new Circle(5, Color.DARKGREEN);
        updateGraphic();
    }

    private void updateGraphic(){
        graphic.setCenterX(x);
        graphic.setCenterY(y);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getEnergy(){
        return energy;
    }

    public Circle getGraphic(){
        return graphic;
    }
}
