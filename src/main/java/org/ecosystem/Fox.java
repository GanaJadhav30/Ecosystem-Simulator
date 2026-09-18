package org.ecosystem;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;


public class Fox extends Animal{

    private final Circle graphic;
    private final double SPEED = 2;
    private final double HUNTING_DISTANCE=10;

    //constructor
    public Fox(double x ,double y){
        super(x,y);
        graphic = new Circle(20, Color.ORANGE);
        updateGraphic();
    }

    //updates ecosystem
    public void update(List<Animal> animals){
        Rabbit nearestRabbit = findNearestRabbit(animals);
        if(nearestRabbit!=null){
//            moveToward(nearestRabbit);
            if(distanceTo(nearestRabbit)<HUNTING_DISTANCE){
                eat(nearestRabbit);
            }

        }else{
            randomMovement();
        }
        keepItInsideWorld();
        updateGraphic();
    }
    //Move toward rabbit
    public void moveToward(Rabbit rabbit){
        double dx = rabbit.getx()-x;
        double dy = rabbit.gety()-y;
        double distance = Math.sqrt(dx*dx + dy*dy);

        if(distance>0) {
            x = x + (dx / distance) * SPEED;
            y = y + (dy / distance) * SPEED;
        }
    }
    //find the nearest rabbit
    public Rabbit findNearestRabbit(List<Animal> animals){
        Rabbit nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        for(Animal animal : animals){
            if(animal instanceof Rabbit rabbit) {
                double distance = distanceTo(rabbit);
                if (nearestDistance > distance) {
                    nearestDistance = distance;
                    nearest = rabbit;
                }
            }
        }
        return nearest;
    }

    //distance between rabbit and fox
    public double distanceTo(Rabbit rabbit){
        double dx = rabbit.getx()-x;
        double dy = rabbit.gety()-y;
        return Math.sqrt(dx *dx + dy*dy);
    }


    //random movement
    public void randomMovement(){
        x = x + Math.random()*2-1;
        y = y + Math.random()*2-1;
        keepItInsideWorld();
    }

    //fox eats rabbit
    public void eat(Rabbit rabbit){
        rabbit.die();
    }



    //places fox on screen
    public void updateGraphic(){
        graphic.setCenterX(x);
        graphic.setCenterY(y);
    }

    //setter used to return fox circle
    public Circle getGraphic(){
        return graphic;
    }

    //keep the fox inside the world
    public void keepItInsideWorld(){
        //left wall
        if(x<20){
            x = 20;
        }
        //right wall
        if(x>World.WIDTH-20){
            x = World.WIDTH-20;
        }
        //top wall
        if(y<20){
            y = 20;
        }
        //bottom wall
        if(y>World.HEIGHT-20){
            y = World.HEIGHT-20;
        }
    }
    @Override
    public void move() {

    }
}
