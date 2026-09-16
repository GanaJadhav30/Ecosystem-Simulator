package org.ecosystem;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Rabbit extends Animal{

    private final Circle graphic;

    public Rabbit(double x, double y) {
        super(x, y);
        graphic = new Circle(10);
        graphic.setFill(Color.WHITE);
        updateGraphic();
    }

    @Override
    public void move() {
        x = x + Math.random()*2-1;
        y = y + Math.random()*2-1;

        if(x<10){
            x = 10;
        }
        if(x>World.width-10){
            x = World.width-10;
        }
        if(y<10){
            y = 10;
        }
        if(y>World.width-10){
            y = World.width-10;
        }

        updateGraphic();
    }
    public void updateGraphic(){
        graphic.setCenterX(x);
        graphic.setCenterY(y);
    }
    public Circle getGraphic(){
        return graphic;
    }
}
